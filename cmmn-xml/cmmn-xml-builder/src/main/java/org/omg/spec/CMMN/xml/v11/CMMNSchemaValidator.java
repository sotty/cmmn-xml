package org.omg.spec.CMMN.xml.v11;

import org.apache.xerces.dom.DOMInputImpl;
import org.w3c.dom.ls.LSInput;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Validates an XML document against the CMMN 1.1 schema(s)
 */
public class CMMNSchemaValidator {

	private static final Map<String,String> schemaSources = Utils.toLinkedMap(
			new String[][] {
					{"/xsd/DC.xsd", "http://www.omg.org/spec/CMMN/20151109/DC.xsd"},
					{"/xsd/DI.xsd", "http://www.omg.org/spec/CMMN/20151109/DI.xsd"},
					{"/xsd/CMMNDI11.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMNDI11.xsd" },
					{"/xsd/CMMN11.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMN11.xsd"},
					{"/xsd/CMMN11CaseModel.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMN11CaseModel.xsd"},

			} );
	/**
	 * Validates an XML document against the CMMN 1.1 schema(s)
	 * @param xml An {@link InputStream} from which a CMMN document can be retrieved
	 */
	public boolean validate( final InputStream xml ) {

		Optional<Schema> schema = getSchema();
		if ( schema.isPresent() ) {
			Validator validator = schema.get().newValidator();
			try {
				validator.validate( new StreamSource( xml ) );
			} catch ( SAXException | IOException e ) {
				return false;
			}
			return true;
		}
		return false;
	}

	/**
	 * Retrieves the OMG CMMN v1.1 schema(s)
	 * @return  An Optional {@link Schema} object that can be used to validate CMMN documents
	 */
	public static Optional<Schema> getSchema() {
		SchemaFactory schemaFactory = SchemaFactory.newInstance( XMLConstants.W3C_XML_SCHEMA_NS_URI );
		schemaFactory.setResourceResolver( ( type, namespaceURI, publicId, systemId, baseURI ) -> {
			if ( baseURI != null ) {
				return null;
			} else {
				String key = "/xsd/" + systemId;
				Optional<InputStream> is = resolveURL( key, schemaSources.get( key ) );

				return is.<LSInput>map( inputStream -> new DOMInputImpl( publicId,
				                                                         systemId,
				                                                         baseURI,
				                                                         inputStream,
				                                                         "UTF-8" ) ).orElse( null );
			}
		} );

		List<Source> sources = schemaSources.keySet().stream()
		                                    .map( (src) -> resolveURL( src, schemaSources.get( src ) ) )
		                                    .filter( Optional::isPresent )
		                                    .map( Optional::get )
		                                    .map( StreamSource::new )
		                                    .collect( Collectors.toList() );


		try {
			return Optional.of( schemaFactory.newSchema( sources.toArray( new Source[ sources.size() ] ) ) );
		} catch ( SAXException  e ) {
			e.printStackTrace();
			System.exit( -1 );
		}
		return Optional.empty();
	}


	/**
	 * Resolves a schema document in the classpath.
	 * If not found, as a fallback solution, tries
	 * to retrieve the schema from the public OMG repositories
	 *
	 * @param local   The path to the schema
	 * @param remote  The URL to the remote location
	 * @return An Optional {@link InputStream} pointing to the actual schema, if found
	 */
	private static Optional<InputStream> resolveURL( final String local, final String remote ) {
		URL fileURL = CMMNSchemaValidator.class.getResource( local );
		File f = new File( fileURL.getPath() );
		if ( f.exists() ) {
			try {
				return Optional.of( new FileInputStream( f ) );
			} catch ( FileNotFoundException e ) {
				e.printStackTrace();
			}
		} else {
			try {
				InputStream is = fileURL.openStream();
				byte[] bytes = new byte[ is.available() ];
				is.read( bytes );

				return Optional.of( new ByteArrayInputStream( bytes ) );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}

		HttpURLConnection connection = null;
		try {
			URL url = new URL( remote );
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("HEAD");
			int code = connection.getResponseCode();
			if ( code == 200 ) {
				return Optional.of( url.openStream() );
			}
		} catch ( IOException e ) {
			return Optional.empty();
		} finally {
			if ( connection != null ) {
				connection.disconnect();
			}
		}

		return Optional.empty();
	}
}
