package edu.mayo.mea3d.preprocess.meta;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.kmdp.MetadataHelper;
import edu.mayo.kmdp.metadata.AboutRel;
import edu.mayo.kmdp.metadata.Annotation;
import edu.mayo.kmdp.metadata.AssetSurrogate;
import edu.mayo.kmdp.metadata.DocumentInfo;
import edu.mayo.kmdp.metadata.FormalNotation;
import edu.mayo.kmdp.metadata.IDReference;
import edu.mayo.kmdp.metadata.MultiTermAnnotation;
import edu.mayo.kmdp.metadata.ObjectFactory;
import edu.mayo.kmdp.metadata.SimpleAnnotation;
import edu.mayo.kmdp.metadata.TermAnnotation;
import edu.mayo.kmdp.util.JaxbUtil;
import edu.mayo.kmdp.util.PropertiesUtil;
import edu.mayo.kmdp.util.schemas.StandardsNamespaceMapper;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import java.net.URI;
import java.util.Optional;

import static edu.mayo.kmdp.MetadataHelper.id;
import static edu.mayo.kmdp.MetadataHelper.t;
import static edu.mayo.kmdp.registry.Registry.KMDP_SURR;
import static edu.mayo.kmdp.registry.Registry.OMG_CMMN;
import static edu.mayo.kmdp.registry.Registry.OMG_CMMN_v11;
import static edu.mayo.kmdp.registry.Registry.OMG_DMN;
import static edu.mayo.kmdp.registry.Registry.OMG_DMN_v11;
import static edu.mayo.kmdp.registry.Registry.W3C_XML;
import static edu.mayo.kmdp.registry.Registry.W3C_XML_v11;
import static edu.mayo.kmdp.util.JSONUtil.jDate;
import static edu.mayo.kmdp.util.JSONUtil.jNode;
import static edu.mayo.kmdp.util.JSONUtil.jString;
import static edu.mayo.kmdp.util.XMLUtil.asElementStream;
import static edu.mayo.kmdp.util.XPathUtil.xList;
import static edu.mayo.kmdp.util.XPathUtil.xNode;
import static edu.mayo.kmdp.util.XPathUtil.xString;


public class SigExtractionStrategy implements ExtractionStrategy {

	private IdentityMapper mapper;

	@Override
	public IdentityMapper getMapper() {
		return mapper;
	}

	public void setMapper( IdentityMapper mapper ) {
		this.mapper = mapper;
	}

	@Override
	public AssetSurrogate extractXML( Document dox, JsonNode meta ) {

		AssetSurrogate surr = newSurrogate();
		Optional<String> resId = getResourceID( dox );
		Optional<String> docId = getArtifactID( dox );
		String head = meta.get( "headRevision" ).asText();


		resId.ifPresent( (id) -> surr.setAssetID( new IDReference()
				                                          .withUri( URI.create( id ) )
				                                          .withVersionedUri( URI.create( id + "/v/" + head ) ) ) );

		jString( "name", meta ).map( surr::withTitle );
		jString( "name", meta ).map( (t) -> surr.getKnowledge().get( 0 ).withName( t ) );

		jDate( "creationDate", meta ).map( surr::withCreationDate );

		jNode( "revisionInfos", meta )
				.flatMap( (n) -> jNode( head, n ) )
				.flatMap( (m) -> jDate( "date", m ) )
				.map( surr::withLastChangeDate );

		surr.withCurrentPublicationStatus( t( "http://purl.org/spar/pso/draft" ) );

		getRepLanguage( dox, false ).ifPresent( surr::withRepresentation );

		if ( docId.isPresent() ) {
			String id = docId.get();
			DocumentInfo docInfo = new DocumentInfo();
			surr.withDocument( docInfo );

			docInfo.withDocID( id( id, head ) );

			getRepLanguage( dox, true ).ifPresent( docInfo::withNotation );
		}


		extractAnnotations( surr, dox );

		resolveDependencies( surr, dox );

		return surr;
	}

	private void resolveDependencies( AssetSurrogate surr, Document dox ) {
		NodeList refs = xList( dox, "//*[@externalRef]" );
		asElementStream( refs ).filter( (n) -> n.hasAttribute( "xmlns" ) )
		                       .map( (n) -> n.getAttribute( "xmlns" ) )
		                       .filter( mapper::hasIdMapped )
		                       .forEach( (artifactId) ->
			                       mapper.getResourceId( artifactId )
			                             .ifPresent( (resourceId) ->
			                             	surr.withAssociatedTo( mapper.associate( surr.getAssetID().getUri().toString(),
			                             			                                 resourceId,
					                                                                 MetadataHelper.DEPENDS ) )
		                        ) );
	}

	private void extractAnnotations( AssetSurrogate surr, Document dox ) {
		NodeList annos = dox.getElementsByTagNameNS( KMDP_SURR, TermAnnotation.class.getSimpleName() );

		JaxbUtil.unmarshall( ObjectFactory.class, Annotation.class, annos, PropertiesUtil.empty() ).stream()
		        .filter( (anno) -> anno instanceof TermAnnotation || anno instanceof MultiTermAnnotation )
		        .map( SimpleAnnotation.class::cast )
		        .filter( (sa) -> sa.getLabel().toLowerCase().contains( "concept" ) )
		        .map( (anno) -> new AboutRel().withTarget( anno )  )
		        .forEach( (about) -> surr.getKnowledge().get( 0 ).withAbout( about ) );
	}


	@Override
	public Optional<String> getResourceID( Document dox ) {
		return Optional.ofNullable( xString( dox, "//*[@label='knowledgeResourceId']/@value" ) );
	}

	@Override
	public Optional<String> getArtifactID( Document dox ) {
		Optional<String> lang = detectRepLanguage( dox );

		return lang.map(  (l) -> {
			switch ( l ) {
				case OMG_DMN:
				case OMG_DMN_v11:
					return xString( dox, "//*/@namespace" );
				case OMG_CMMN:
				case OMG_CMMN_v11:
					return xString( dox, "//*/@targetNamespace" );
				default:
					return null;
			}
		} );
	}

	@Override
	public Optional<FormalNotation> getRepLanguage( Document dox, boolean concrete ) {
		if ( xNode( dox,  "//cmmn:definitions" ) != null ) {
			return Optional.of( new FormalNotation()
					                    .withRepLanguage( id( OMG_CMMN, OMG_CMMN_v11 ) )
					                    .withSyntax( concrete ? id( W3C_XML, W3C_XML_v11 ) : null ) );
		}
		if ( xNode( dox,  "//dmn:definitions" ) != null ) {
			return Optional.of( new FormalNotation()
					                    .withRepLanguage( id( OMG_DMN, OMG_DMN_v11 ) )
					                    .withSyntax( concrete ? id( W3C_XML, W3C_XML_v11 ) : null ) );
		}
		return Optional.empty();
	}

	public Optional<String> detectRepLanguage( Document dox ) {
		if ( xNode( dox,  "//cmmn:definitions" ) != null ) {
			return Optional.of( OMG_CMMN_v11 );
		}
		if ( xNode( dox,  "//dmn:definitions" ) != null ) {
			return Optional.of( OMG_DMN_v11 );
		}
		return Optional.empty();
	}

	@Override
	public String getMetadataEntryNameForID( String id ) {
		return "Signavio Export/model_" +
				id.substring( id.lastIndexOf( '/' ) + 1, id.lastIndexOf( '.' ) ) +
				"/model_meta.json";
	}



}
