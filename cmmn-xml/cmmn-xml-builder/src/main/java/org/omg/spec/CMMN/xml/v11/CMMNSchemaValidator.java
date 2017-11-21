package org.omg.spec.CMMN.xml.v11;


import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
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
					{"/xsd/CMMN11.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMN11.xsd"},
					{"/xsd/CMMN11CaseModel.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMN11CaseModel.xsd"},
					{"/xsd/CMMNDI11.xsd", "http://www.omg.org/spec/CMMN/20151109/CMMNDI11.xsd" } }
			);
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

		List<Source> sources = schemaSources.keySet().stream()
		                                    .map( (src) -> resolveURL( src, schemaSources.get( src ) ) )
		                                    .filter( Optional::isPresent )
		                                    .map( Optional::get )
		                                    .collect( Collectors.toList() );


		try {
			return Optional.of( schemaFactory.newSchema( sources.toArray( new Source[ sources.size() ] ) ) );
		} catch ( SAXException e ) {
			e.printStackTrace();
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
	 * @return An Optional {@link Source} pointing to the actual schema, if found
	 */
	private static Optional<Source> resolveURL( final String local, final String remote ) {
		URL fileURL = CMMNSchemaValidator.class.getResource( local );
		if ( fileURL != null ) {
			File f = new File( fileURL.getPath() );
			if ( f.exists() ) {
				return Optional.of( new StreamSource( f ) );
			}
		}

		HttpURLConnection connection = null;
		try {
			URL url = new URL( remote );
			connection = (HttpURLConnection) url.openConnection();

			connection.setRequestMethod("HEAD");
			int code = connection.getResponseCode();
			if ( code == 200 ) {
				return Optional.of( new StreamSource( url.openStream() ) );
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
