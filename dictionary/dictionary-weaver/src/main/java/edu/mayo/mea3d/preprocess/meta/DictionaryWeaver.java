package edu.mayo.mea3d.preprocess.meta;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.function.BiConsumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static edu.mayo.mea3d.util.Util.resolveResource;

public class DictionaryWeaver {

	private static final String DEFAULT_DICT        = "/Dictionary.xlsx";

	private static final String DICT_NS             = "http://www.signavio.com/schema/dmn/1.1/";
	private static final String DICT_EL             = "diagramMetaData";
	private static final String ID                  = "Id";

	private static final String DICT_PATTERN_ST     = "(.*)(/glossary/)([a-z\\d]+)(.*)";

	private static final int HEADER_ROW             = 5;

	private static final Pattern    PATTERN         = Pattern.compile( DICT_PATTERN_ST );

	private static final String     DEF_TITLE       = "Title";
	private static final String     DEF_DESCR       = "Description";
	private static final String     DEF_LINKS       = "Relevant Documents";
	private static final String     GENERIC_H       = "*";

	private final XSSFWorkbook      dictionary;
	private Map<String,XSSFRow>     entryCache;
	private boolean                 strict = false;

	private final static Map<String,BiConsumer<Element,Map<String,String>>> handlers;
	
	static {
		handlers = new HashMap<>();

		handlers.put( DEF_TITLE, DictionaryWeaver::injectTitle );
		handlers.put( DEF_DESCR, DictionaryWeaver::injectDescription );
		handlers.put( DEF_LINKS, DictionaryWeaver::injectLinks );
		handlers.put( GENERIC_H, DictionaryWeaver::injectCustom );
	}

	public DictionaryWeaver() {
		this( false );
	}

	public DictionaryWeaver( boolean strict ) {
		this( getDefaultDictionary().orElseGet( XSSFWorkbook::new ), strict );
	}

	public DictionaryWeaver( XSSFWorkbook dict, boolean strict ) {
		this.dictionary = dict;
		this.entryCache = new HashMap<>();
		this.strict = strict;
	}

	public Document weave( Document dox ) {
		NodeList metas = dox.getElementsByTagNameNS( DICT_NS, DICT_EL );

		asElementStream( metas )
				.filter( this::isDictionaryElement )
				.filter( this::hasDictionaryEntry )
				.forEach(
						(el) -> getDictionaryEntry( el )
								.ifPresent( (entry) -> doInject( el, entry ) ) );

		return dox;
	}

	private boolean hasDictionaryEntry( Element element ) {
		return getDictionaryEntry( element ).isPresent();
	}

	private Optional<XSSFRow> getDictionaryEntry( Element el ) {
		return getDictionaryID( el )
				.map( ( dictID ) -> {
					      if ( entryCache.containsKey( dictID ) ) {
						      return Optional.of( entryCache.get( dictID ) );
					      }
					      return lookupEntry( dictID, dictionary );
				      }
				    ).orElse( Optional.empty() );
	}

	private Optional<String> getDictionaryID( Element el ) {
		Matcher m = PATTERN.matcher( el.getAttribute( "value" ) );
		if ( m.find() && m.groupCount() >= 3 ) {
			return Optional.of( m.group( 3 ) );
		} else {
			return Optional.empty();
		}
	}

	private Optional<XSSFRow> lookupEntry( String dictID, XSSFWorkbook dictionary ) {
		int D = dictionary.getNumberOfSheets();
		for ( int j = 0; j < D; j++ ) {
			XSSFSheet sheet = dictionary.getSheetAt( j );

			int N = sheet.getFirstRowNum();
			int M = sheet.getLastRowNum();
			int ID_COL = lookupSheetIDColumn( sheet );
			if ( ID_COL < 0 ) {
				if ( strict ) {
					throw new IllegalStateException( "Could not find ID Header for " + sheet.getSheetName() );
				} else {
					return Optional.empty();
				}
			}

			for ( int k = N; k <= M; k++ ) {
				XSSFRow row = sheet.getRow( k );
				if ( row != null ) {
					if ( row.getLastCellNum() >= ID_COL ) {
						if ( dictID.equals( row.getCell( ID_COL ).getStringCellValue() ) ) {
							return Optional.of( row );
						}
					}
				}
			}
		}
		if ( strict ) {
			throw new IllegalStateException( "Could not find entry for " + dictID );
		} else {
			return Optional.empty();
		}
	}

	private int lookupSheetIDColumn( XSSFSheet sheet ) {
		XSSFRow header = sheet.getRow( HEADER_ROW );
		if ( header != null ) {
			int idx = 0;
			do {
				if ( ID.equals( header.getCell( idx ).getStringCellValue() ) ) {
					return idx;
				}
			} while ( header.getCell( idx++ ) != null );
		}
		return -1;
	}

	private void doInject( Element el, XSSFRow row ) {
		XSSFRow header = row.getSheet().getRow( HEADER_ROW );
		for ( int j = 0; j < header.getLastCellNum(); j++ ) {
			String key = header.getCell( j ).getStringCellValue();
			String value = row.getCell( j ).getStringCellValue();
			Map<String,String> pair = new HashMap<>();
			pair.put( key, value );

			if ( ID.equals( key ) ) {
				// This and subsequent columns are internal only
				return;
			}

			if ( handlers.containsKey( key ) ) {
				handlers.get( key ).accept( el, pair );
			} else {
				handlers.get( GENERIC_H ).accept( el, pair );
			}

		}
	}

	private static void injectTitle( Element element, Map<String,String> titleMap ) {
		Document dox = element.getOwnerDocument();
		Element title = dox.createElementNS( DICT_NS, getPrefix( dox, DICT_NS ) + "term" );
		title.appendChild( dox.createTextNode( titleMap.get( DEF_TITLE ) ) );
		element.appendChild( title );
	}

	private static void injectDescription( Element element, Map<String,String> descrMap ) {
		String descrStr = descrMap.get( DEF_DESCR );
		if ( descrStr == null || descrStr.length() == 0 ) {
			return;
		}

		Document dox = element.getOwnerDocument();
		Element descr = dox.createElementNS( DICT_NS, getPrefix( dox, DICT_NS ) + "description" );
		descr.appendChild( dox.createCDATASection( descrStr ) );
		element.appendChild( descr );
	}

	private static void injectLinks( Element element, Map<String,String> linksMap ) {
		String linksStr = linksMap.get( DEF_LINKS );
		if ( linksStr == null || linksStr.length() == 0 ) {
			return;
		}

		Document dox = element.getOwnerDocument();
		Element links = dox.createElementNS( DICT_NS, getPrefix( dox, DICT_NS ) + "links" );

		StringTokenizer tokenizer = new StringTokenizer( linksStr, "\n" );
		while ( tokenizer.hasMoreTokens() ) {
			String tok = tokenizer.nextToken();
			int urlStart = tok.lastIndexOf( '(' );
			int urlEnd = tok.lastIndexOf( ')' );

			String label = tok.substring( 0, urlStart ).trim();
			String url = tok.substring( urlStart + 1, urlEnd ).trim();

			Element link = dox.createElementNS( DICT_NS, getPrefix( dox, DICT_NS ) + "link" );
			link.setAttribute( "label", label );
			link.setAttribute( "url", url );

			links.appendChild( link );
		}

		element.appendChild( links );
	}

	private static void injectCustom( Element element, Map<String,String> custom ) {
		Document dox = element.getOwnerDocument();

		for ( String key : custom.keySet() ) {
			String elemName = key.toLowerCase().trim().replace( " ", "_" );
			String elemValue = custom.get( key );
			Element el = dox.createElementNS( DICT_NS, getPrefix( dox, DICT_NS ) + elemName );
			el.appendChild( dox.createTextNode( elemValue ) );
			element.appendChild( el );
		}
	}


	private boolean isDictionaryElement( Element element ) {
		return element.hasAttribute( "value" ) && element.getAttribute( "value" ).matches( DICT_PATTERN_ST );
	}

	private Stream<Element> asElementStream( NodeList nodes ) {
		int N = nodes.getLength();
		Collection<Node> nodeList = new ArrayList<>( N );
		for ( int j = 0; j < N; j++ ) {
			nodeList.add( nodes.item( j ) );
		}
		return nodeList.stream()
		               .filter( Element.class::isInstance )
		               .map( Element.class::cast );
	}


	public static Optional<XSSFWorkbook> getDefaultDictionary() {
		try {
			return getDictionary( resolveResource( DEFAULT_DICT ).openStream() );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static Optional<XSSFWorkbook> getDictionary( InputStream is ) {
		try {
			return Optional.of( new XSSFWorkbook( is ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}


	private static String getPrefix( Document dox, String namespace ) {
		NamedNodeMap map = dox.getDocumentElement().getAttributes();
		for ( int j = 0; j < map.getLength(); j++ ) {
			Attr attr = ( Attr ) map.item( j );
			if ( namespace.equals( attr.getValue() ) ) {
				String xmlns = attr.getName();
				return xmlns.substring( xmlns.indexOf( ":" ) + 1 ) + ":";
			}
		}
		return "";
	}

}
