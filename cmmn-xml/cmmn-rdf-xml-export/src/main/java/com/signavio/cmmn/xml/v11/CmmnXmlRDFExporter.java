package com.signavio.cmmn.xml.v11;


import com.signavio.cmmn.xml.v11.translator.CMMNRdfTranslator;
import org.apache.jena.rdf.model.Model;
import org.omg.spec.CMMN.xml.v11.CmmnXmlExporter;
import org.omg.spec.CMMN.xml.v11.NameSpaceMapper;
import org.omg.spec.cmmn._20151109.model.TDefinitions;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.util.function.Function;


public class CmmnXmlRDFExporter extends CmmnXmlExporter<Model> {


	public CmmnXmlRDFExporter( Model source, boolean validating ) {
		super( source, validating );
	}

	@Override
	protected Function<Model, TDefinitions> getTranslator() {
		return new CMMNRdfTranslator( new CustomObjectFactory() );
	}

	protected void configureMarshaller(TDefinitions definition, Marshaller marshaller) throws PropertyException {
		String localNs = Constants.NS_DIAGRAM_SIGNAVIO + definition.getTargetNamespace() ;

		NameSpaceMapper namespaceMapper = (NameSpaceMapper) marshaller.getProperty( NAMESPACE_MAPPER_PROPERTY );

		namespaceMapper.putNewNamespaceMapping( com.signavio.cmmn.xml.v11.Constants.NS_NAME_SIGNAVIO_EXTENSIONS,
		                              com.signavio.cmmn.xml.v11.Constants.NS_SCHEMA_SIGNAVIO );

		namespaceMapper.putNewNamespaceMapping( Constants.NS_NAME_SIGNAVIO,
		                                        localNs );

		marshaller.setProperty(NAMESPACE_MAPPER_PROPERTY, namespaceMapper);
	}

	protected JAXBContext getJAXBInstance() throws JAXBException {
		return JAXBContext.newInstance( CustomObjectFactory.class, TDefinitions.class );
	}

}
