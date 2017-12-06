package edu.mayo.mea3d.preprocess.meta;

import edu.mayo.kmdp.metadata.Annotation;
import edu.mayo.kmdp.metadata.ControlledTerm;
import edu.mayo.kmdp.metadata.MultiTermAnnotation;
import edu.mayo.kmdp.metadata.SimpleAnnotation;
import edu.mayo.kmdp.metadata.TermAnnotation;
import edu.mayo.mea3d.util.Util;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class DictionaryReader {


	private final int HEADER_ROW;
	private final String ID_COL_HEADER;
	private final String LABEL_COL_HEADER;
	private final String DESCR_COL_HEADER;
	private final String CODE_COL_HEADER;
	private final String URI_COL_HEADER;


	private final XSSFWorkbook dictionary;
	private Map<String,XSSFRow> entryCache;


	private boolean                 strict = false;
	private DictionaryConfig        config;


	public DictionaryReader( XSSFWorkbook dict, boolean strict, DictionaryConfig config ) {
		this.dictionary = dict;
		this.entryCache = new HashMap<>();

		this.config = config;

		this.HEADER_ROW = Integer.valueOf( config.get( DictionaryConfig.p_HEADER_ROW ) );
		this.ID_COL_HEADER = config.get( DictionaryConfig.p_ID_DICT_COL );
		this.LABEL_COL_HEADER = config.get( DictionaryConfig.p_TITLE_DICT_COL );
		this.DESCR_COL_HEADER = config.get( DictionaryConfig.p_DESCR_DICT_COL );
		this.CODE_COL_HEADER = config.get( DictionaryConfig.p_CODE_DICT_COL );
		this.URI_COL_HEADER = config.get( DictionaryConfig.p_URI_DICT_COL );
	}


	public ControlledTerm readEntry( XSSFRow row ) {
		ControlledTerm term = new ControlledTerm();

		XSSFRow header = row.getSheet().getRow( HEADER_ROW );
		for ( int j = 0; j < header.getLastCellNum(); j++ ) {

			String key = header.getCell( j ).getStringCellValue();
			String value = row.getCell( j ).getStringCellValue();
			if ( ! Util.isEmpty( key ) && ! Util.isEmpty( value ) ) {

				if ( ID_COL_HEADER.equals( key ) ) {
					// This and subsequent columns are internal only
					return term;
				} else if ( LABEL_COL_HEADER.equals( key ) ) {
					term.withLabel( value );
				} else if ( DESCR_COL_HEADER.equals( key ) ) {
					term.withDescription( value );
				} else if ( CODE_COL_HEADER.equals( key ) ) {
					term.withLocalId( value );
				} else if ( URI_COL_HEADER.equals( key ) ) {
					// Assumption: only one URI/URL is used for dictionary entries of this kind
					term.withUri( parseLinks( value ).keySet().iterator().next() );
				}

			}

		}
		return term;
	}

	public Annotation createAnnotation( String name, List<XSSFRow> rows ) {
		SimpleAnnotation anno;
		switch ( rows.size() ) {
			case 0:
				anno = new SimpleAnnotation();
				break;
			case 1:
				anno = new TermAnnotation().withConceptRef( readEntry( rows.get( 0 ) ) );
				break;
			default:
				anno = new MultiTermAnnotation().withConceptRefs(
						rows.stream().map( this::readEntry ).collect( toList() ) );
		}

		return anno.withLabel( name );
	}


	public List<XSSFRow> getDictionaryEntry( List<String> dictionaryIDs ) {
		return dictionaryIDs.stream()
		                             .map( ( dictID ) -> {
			                             if ( entryCache.containsKey( dictID ) ) {
				                             return Optional.of( entryCache.get( dictID ) );
			                             }
			                             return lookupEntry( dictID, dictionary );
		                             } )
		                             .filter( Optional::isPresent )
		                             .map( Optional::get )
		                             .collect( Collectors.toList() );
	}

	private Map<URI,String> parseLinks( String linksStr ) {
		Map<URI,String> links = new LinkedHashMap<>();
		StringTokenizer tokenizer = new StringTokenizer( linksStr, "\n" );
		while ( tokenizer.hasMoreTokens() ) {
			String tok = tokenizer.nextToken();
			int urlStart = tok.lastIndexOf( '(' );
			int urlEnd = tok.lastIndexOf( ')' );

			String label = tok.substring( 0, urlStart ).trim();
			String url = tok.substring( urlStart + 1, urlEnd ).trim();

			links.put( URI.create( url ), label);
		}
		return links;
	}

	public Optional<XSSFRow> lookupEntry( String dictID, XSSFWorkbook dictionary ) {
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
				if ( ID_COL_HEADER.equals( header.getCell( idx ).getStringCellValue() ) ) {
					return idx;
				}
			} while ( header.getCell( idx++ ) != null );
		}
		return -1;
	}



}
