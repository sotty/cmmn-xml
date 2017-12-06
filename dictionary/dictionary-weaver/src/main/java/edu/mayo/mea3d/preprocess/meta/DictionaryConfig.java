package edu.mayo.mea3d.preprocess.meta;

import edu.mayo.mea3d.util.PropertiesUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;
import java.util.regex.Pattern;

import static edu.mayo.mea3d.util.PropertiesUtil.pString;
import static edu.mayo.mea3d.util.Util.resolveResource;
import static edu.mayo.mea3d.util.XMLUtil.getPrefix;

public class DictionaryConfig {

	// Regular expressions for dictionary entries
	// Unescaped \[\{\".*\":\"(.*)\",\".*\":\"(.*)\"\}\]
	public static final String URL_PATTERN_ST          = "\\[\\{\\\".*\\\":\\\"(.*)\\\",\\\".*\\\":\\\"(.*)\\\"\\}\\]";  //
	public static final String DICT_PATTERN_ST         = "(/glossary/)([a-z\\d]+)";
	public static final Pattern DCT_PATTERN            = Pattern.compile( DICT_PATTERN_ST );
	public static final Pattern URL_PATTERN            = Pattern.compile( URL_PATTERN_ST );


	// Dictionary Informaation
	public static final String p_DEFAULT_DICT      = "DEFAULT_DICT";
	public static final String p_HEADER_ROW        = "HEADER_ROW";
	public static final String p_ID_DICT_COL       = "ID_DICT_COL";
	public static final String p_TITLE_DICT_COL    = "LABEL_DICT_COL";
	public static final String p_DESCR_DICT_COL    = "DESCR_DICT_COL";
	public static final String p_CODE_DICT_COL     = "CODE_DICT_COL";
	public static final String p_URI_DICT_COL      = "URI_DICT_COL";

	// Dictionary Information
	public static final String p_ATTR_GX           = "ATTR_DICT_REF";


	// Parent model Information
	public static final String p_MODEL_NS          = "MODEL_NS";
	public static final String p_EL_MODEL_EXT      = "EL_MODEL_EXTENSIONS";

	// Dictionary metadata schema
	public static final String p_METADATA_NS       = "METADATA_NS";
	public static final String p_EL_ANNOTATION     = "EL_ANNOTATION";
	public static final String p_EL_ANNOTATED_ITEM = "EL_ANNOTATED_ITEM";


	public static final String META_EL             = "meta";
	public static final String META_VALUE          = "concept";
	public static final String p_SURR_NS           = "SURR_NS";
	public static final String p_SURR_PFX          = "SURR_PFX";


	public static Properties       defaults = PropertiesUtil.props( "/dictionaryWeaver.properties" ).get();
	private Properties  config;


	public DictionaryConfig() {
		this.config = PropertiesUtil.props( defaults ).get();
	}

	public DictionaryConfig( Properties config ) {
		this.config = PropertiesUtil.props( defaults ).get();
		if ( config != null ) {
			this.config.putAll( config );
		}
	}

	public String get( String name ) {
		return pString( name, config )
				.orElseThrow( IllegalStateException::new );
	}

	public Optional<XSSFWorkbook> getDefaultDictionary() {
		try {
			return getDictionary( resolveResource( get( p_DEFAULT_DICT ) ).openStream() );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public Optional<XSSFWorkbook> getDictionary( InputStream is ) {
		try {
			return Optional.of( new XSSFWorkbook( is ) );
		} catch ( IOException e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}


	public Element modelExt( Document dox, String elementName ) {
		return dox.createElementNS( get( p_MODEL_NS ), getPrefix( dox, get( p_MODEL_NS ) )  + elementName );
	}


}
