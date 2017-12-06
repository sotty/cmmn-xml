package edu.mayo.mea3d.preprocess.meta;

import edu.mayo.kmdp.metadata.Annotation;
import edu.mayo.kmdp.metadata.BasicAnnotation;
import edu.mayo.kmdp.metadata.MultiTermAnnotation;
import edu.mayo.kmdp.metadata.ObjectFactory;
import edu.mayo.kmdp.metadata.SimpleAnnotation;
import edu.mayo.kmdp.metadata.TermAnnotation;
import edu.mayo.mea3d.util.JaxbUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Matcher;

import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.DCT_PATTERN;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.URL_PATTERN;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_ATTR_GX;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_EL_ANNOTATED_ITEM;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_EL_ANNOTATION;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_METADATA_NS;
import static edu.mayo.mea3d.preprocess.meta.MetadataAttributeNameMapper.map;
import static edu.mayo.mea3d.util.Util.normalize;
import static edu.mayo.mea3d.util.XMLUtil.asElementStream;
import static edu.mayo.mea3d.util.schemas.MEA3DNamespaceMapper.NS_KMDP_SURR;
import static edu.mayo.mea3d.util.schemas.MEA3DNamespaceMapper.NS_OMG_CMMN_v11;
import static edu.mayo.mea3d.util.schemas.MEA3DNamespaceMapper.NS_OMG_DMN_v11;
import static edu.mayo.mea3d.util.schemas.MEA3DNamespaceMapper.PFX_KMDP_SURR;

public class DictionaryEntryWeaver {

	private String METADATA_NS;
	private String METADATA_EL;
	private String ANNOTATED_ITEM;
	private String DICT_REFERENCE_ATTR;


	private DictionaryConfig        config;
	private DictionaryReader        reader;

	private ObjectFactory           of = new ObjectFactory();
	private Map<String,BaseAnnotationHandler> handlers = new HashMap<>();


	public DictionaryEntryWeaver() {
		this( false );
	}

	public DictionaryEntryWeaver( boolean strict ) {
		this( null, strict );
	}

	public DictionaryEntryWeaver( boolean strict, Properties p ) {
		this( null, strict, p );
	}

	public DictionaryEntryWeaver( InputStream dict, boolean strict ) {
		this( dict, strict, null );
	}

	public DictionaryEntryWeaver( InputStream dict, boolean strict, Properties p ) {
		this.config = new DictionaryConfig( p );

		Optional<XSSFWorkbook> dictionary = dict != null ? config.getDictionary( dict ) : config.getDefaultDictionary();
		this.reader = new DictionaryReader( dictionary.orElseGet( XSSFWorkbook::new ),
		                                    strict,
		                                    this.config );

		METADATA_NS = config.get( p_METADATA_NS );
		METADATA_EL = config.get( p_EL_ANNOTATION );

		ANNOTATED_ITEM = config.get( p_EL_ANNOTATED_ITEM );

		DICT_REFERENCE_ATTR = config.get( p_ATTR_GX );

		handlers.put( METADATA_EL, new MetadataAnnotationHandler( config ) );
		handlers.put( ANNOTATED_ITEM, new AnnotatedFragmentHandler( config ) );
	}




	public Document weave( Document dox ) {
		dox.getDocumentElement().setAttributeNS( "http://www.w3.org/2000/xmlns/",
		                                         "xmlns:" + "xsi",
		                                         "http://www.w3.org/2001/XMLSchema-instance" );

		dox.getDocumentElement().setAttributeNS( "http://www.w3.org/2000/xmlns/",
		                                         "xmlns:" + PFX_KMDP_SURR,
		                                         NS_KMDP_SURR );

		dox.getDocumentElement().setAttributeNS( "http://www.w3.org/2001/XMLSchema-instance",
		                                         "xsi:" + "schemaLocation",
		                                         getSchemaLocations( dox ) );

		NodeList metas = dox.getElementsByTagNameNS( METADATA_NS, METADATA_EL );
		NodeList dicts = dox.getElementsByTagName( ANNOTATED_ITEM );

		// Custom Attributes whose value is a Dictionary Entry
		weaveDictionaryMetadata( metas );

		// Model Fragments that are bound to Dictionary Entry
		weaveDictionaryFragments( dicts );

		// Attributes that are not bound to Dictionary Entries
		weaveNonDictionaryMetadata( metas );

		// This should go away eventually..
		fixBugs( dox );

		return dox;
	}


	private void weaveNonDictionaryMetadata( NodeList metas ) {
		// rewire dictionary-bound attributes
		asElementStream( metas )
				.forEach(
						(el) -> doRewrite( el ) );
	}

	private void weaveDictionaryMetadata( NodeList metas ) {
		// rewire dictionary-bound attributes
		asElementStream( metas )
				.filter( this::isDictionaryElement )
				.filter( this::hasDictionaryEntry )
				.forEach(
						(el) -> doInjectTerm( el,
						                      reader.getDictionaryEntry( handler( el ).getDictionaryIDs( el ) ) ) );

		// remove empty attributes
		asElementStream( metas )
				.filter( this::isEmptyAttribute )
				.forEach(
						(el) -> el.getParentNode().removeChild( el ) );
	}

	private void weaveDictionaryFragments( NodeList dicts ) {
		asElementStream( dicts )
				.filter( (el) -> el.hasAttributeNS( METADATA_NS, DICT_REFERENCE_ATTR ) )
				.forEach(
						(el) -> doInjectTerm( el,
						                      reader.getDictionaryEntry( handler( el ).getDictionaryIDs( el ) ) ) );

	}

	private BaseAnnotationHandler handler( Element el ) {
		return handlers.getOrDefault( el.getLocalName(), new GenericAnnotationHandler() );
	}


	private void doInjectTerm( Element el, List<XSSFRow> rows ) {
		BaseAnnotationHandler handler = handler( el );

		String name = handler.getAnnotationName( el );

		if ( ! rows.isEmpty() ) {
			Annotation anno = reader.createAnnotation( name, rows );
			handler.replaceProprietaryElement( el, handler.wrap( toChildElement( anno, el ) ) );
		}
	}


	private void doRewrite( Element el ) {
		extractKeyValuePairs( el.getAttribute( "value" ), el.getAttribute( "name" ) )
				.forEach( (k,v) -> {
					Annotation anno = new BasicAnnotation()
							.withLabel( map( k ) )
							.withValue( v );
					handler( el ).replaceProprietaryElement( el, toChildElement( anno, el ) );
				} );
	}

	private Map<String, String> extractKeyValuePairs( String value, String deflt ) {
		HashMap<String,String> map = new HashMap<>();
		Matcher m = URL_PATTERN.matcher( value );
		if ( m.find() ) {
			map.put( getUrlKey( m.group( 1 ), deflt ), m.group( 2 ) );
		}
		return map;
	}


	private boolean isEmptyAttribute( Element el ) {
		String value = el.getAttribute( "value" );
		return value.isEmpty() || "[]".equals( value );
	}

	private boolean hasDictionaryEntry( Element element ) {
		return ! handler( element ).getDictionaryIDs( element ).isEmpty();
	}



	private boolean isDictionaryElement( Element element ) {
		return element.hasAttribute( "value" )
				&& DCT_PATTERN.matcher( element.getAttribute( "value" ) ).find();
	}


	private String getUrlKey( String value, String deflt ) {
		if ( MetadataAttributeNameMapper.KNOWLEDGE_RES_ID.equals( map( deflt ) ) ) {
			return MetadataAttributeNameMapper.KNOWLEDGE_RES_ID;
		}
		return normalize( value );
	}



	private Element toChildElement( Annotation ann, Element parent ) {
		Element el;
		if ( BasicAnnotation.class.equals( ann.getClass() ) ) {
			el = JaxbUtil.toElement( of,
			                         (BasicAnnotation) ann,
			                         of::createBasicAnnotation);
		} else if ( TermAnnotation.class.equals( ann.getClass() ) ) {
			el = JaxbUtil.toElement( of,
			                         (TermAnnotation) ann,
			                         of::createTermAnnotation );
		} else if ( MultiTermAnnotation.class.equals( ann.getClass() ) ) {
			el = JaxbUtil.toElement( of,
			                         (MultiTermAnnotation) ann,
			                         of::createMultiTermAnnotation );
		} else if ( SimpleAnnotation.class.equals( ann.getClass() ) ) {
			el = JaxbUtil.toElement( of,
			                         (SimpleAnnotation) ann,
			                         of::createSimpleAnnotation );
		} else {
			throw new IllegalStateException( "Unmanaged annotation tyep" + ann.getClass().getName() );
		}

		parent.getOwnerDocument().adoptNode( el );
		parent.appendChild( el );
		return el;
	}



	//FIXME This should eventually go away
	private void fixBugs( Document dox ) {
		asElementStream( dox.getElementsByTagName( "decisionService" ) )
				.forEach( (el) -> el.getParentNode().removeChild( el ) );
	}



	private String getSchemaLocations( Document dox ) {
		StringBuilder sb = new StringBuilder();

		sb.append( NS_KMDP_SURR ).append( " " ).append( "xsd/edu/mayo/kmdp/surrogate.xsd" );

		String baseNS = dox.getDocumentElement().getNamespaceURI();
		if ( baseNS.contains( "DMN" ) ) {
			sb.append( " " ).append( NS_OMG_DMN_v11 ).append( " " ).append( NS_OMG_DMN_v11 );
		} else if ( baseNS.contains( "CMMN" ) ) {
			sb.append( " " ).append( NS_OMG_CMMN_v11 ).append( " " ).append( NS_OMG_CMMN_v11 );
		}

		return sb.toString();
	}



}
