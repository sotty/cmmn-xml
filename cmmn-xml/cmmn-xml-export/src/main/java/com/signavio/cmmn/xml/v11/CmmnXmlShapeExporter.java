package com.signavio.cmmn.xml.v11;


import com.signavio.cmmn.xml.v11.translator.CMMNShapeTranslator;
import com.signavio.diagram.model.Diagram;
import com.signavio.schema.cmmn._1.DiagramMetaData;
import org.omg.spec.CMMN.xml.v11.CmmnXmlExporter;
import org.omg.spec.CMMN.xml.v11.NameSpaceMapper;
import org.omg.spec.cmmn._20151109.model.TDefinitions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.util.function.BiFunction;


public class CmmnXmlShapeExporter extends CmmnXmlExporter<Diagram> {


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
