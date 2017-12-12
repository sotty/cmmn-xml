package com.signavio.cmmn.xml.v11;


import com.signavio.cmmn.xml.v11.translator.CMMNShapeTranslator;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.DiagramBuilder;
import com.signavio.schema.cmmn._1.DiagramMetaData;
import org.json.JSONException;
import org.omg.spec.CMMN.xml.v11.CmmnXmlExporter;
import org.omg.spec.CMMN.xml.v11.NameSpaceMapper;
import org.omg.spec.cmmn._20151109.model.TDefinitions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.zip.ZipEntry;


public class CmmnXmlShapeExporter extends CmmnXmlExporter<Diagram> {


	public static Optional<String> export( InputStream zipSource ) {
		ZipHelper zips = new ZipHelper( zipSource );
		try {
			Optional<ZipEntry> zipEntry = zips.getModelEntry();
			if ( zipEntry.isPresent() ) {
				return Optional.ofNullable( export( zips.unzip(), zips.getId( zipEntry.get().getName() ) ) );
			}
		} catch ( Exception e ) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static String export( byte[] model, String artifactId ) throws Exception {
		return new CmmnXmlShapeExporter( model, true ).generateXml( artifactId );
	}

	public CmmnXmlShapeExporter( byte[] model, boolean validating ) throws JSONException {
		this( DiagramBuilder.parseJson( new String( model ) ), validating );
	}

	public CmmnXmlShapeExporter( Diagram source, boolean validating ) {
		super( source, validating );
	}

	@Override
	protected BiFunction<Diagram, String, TDefinitions> getTranslator() {
		return new CMMNShapeTranslator( new CustomObjectFactory() );
	}

	protected void configureMarshaller(TDefinitions definition, Marshaller marshaller) throws PropertyException {
		String localNs = definition.getTargetNamespace() ;

		NameSpaceMapper namespaceMapper = (NameSpaceMapper) marshaller.getProperty( NAMESPACE_MAPPER_PROPERTY );

		namespaceMapper.putNewNamespaceMapping( com.signavio.cmmn.xml.v11.Constants.NS_NAME_SIGNAVIO_EXTENSIONS,
		                              com.signavio.cmmn.xml.v11.Constants.NS_SCHEMA_SIGNAVIO );

		namespaceMapper.putNewNamespaceMapping( Constants.NS_NAME_SIGNAVIO,
		                                        localNs );

		marshaller.setProperty(NAMESPACE_MAPPER_PROPERTY, namespaceMapper);
	}

	protected JAXBContext getJAXBInstance() throws JAXBException {
		return JAXBContext.newInstance( CustomObjectFactory.class, TDefinitions.class, DiagramMetaData.class );
	}

}
