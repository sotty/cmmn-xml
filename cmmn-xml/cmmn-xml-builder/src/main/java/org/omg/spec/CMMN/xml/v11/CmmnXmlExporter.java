package org.omg.spec.CMMN.xml.v11;


import org.omg.spec.cmmn._20151109.model.ObjectFactory;
import org.omg.spec.cmmn._20151109.model.TDefinitions;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.validation.Schema;
import java.io.ByteArrayInputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Optional;
import java.util.function.Function;


public abstract class CmmnXmlExporter<T> {
	
	public static final String NAMESPACE_MAPPER_PROPERTY = "com.sun.xml.bind.namespacePrefixMapper";
	
	private T source;
	private boolean validating;

	public static boolean DEFAULT_VALIDATION = false;
	
	
	public CmmnXmlExporter( final T source ) {
		this(source,DEFAULT_VALIDATION);
	}

	public CmmnXmlExporter( final T source, final boolean validating ) {
		this.source = source;
		this.validating = validating;
	}

	public T getSource() {
		return source;
	}

	public void setSource( T source ) {
		this.source = source;
	}

	public boolean isValidating() {
		return validating;
	}

	public void setValidating( boolean validating ) {
		this.validating = validating;
	}

	public String generateXml() {
		TDefinitions definitions = getTranslator().apply( source );

		try {
			return marshall(definitions, validating);
		} catch (JAXBException | SAXException e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract Function<T,TDefinitions> getTranslator();

	public boolean validateCMMN_XML( final String xml ) {
		return new CMMNSchemaValidator().validate( new ByteArrayInputStream( xml.getBytes() ) );
	}


	protected abstract void configureMarshaller( final TDefinitions definition, final Marshaller marshaller ) throws PropertyException;
	
	
	protected void marshall( final TDefinitions definition, final Writer writer, final boolean validating ) throws JAXBException, SAXException {
		ObjectFactory factory = new CMMNObjectFactory();
		Marshaller marshaller = getMarshaller();
		configureMarshaller(definition, marshaller);

		if ( validating ) {
			Optional<Schema> schema = CMMNSchemaValidator.getSchema();
			schema.ifPresent( marshaller::setSchema );
		}

		marshaller.marshal(factory.createDefinitions(definition), writer);
	}
	
	
	public String marshall( final TDefinitions definition, final boolean validating ) throws JAXBException, SAXException {
		Writer writer = new StringWriter();
		marshall(definition, writer, validating);
		return writer.toString();
	}
	
	public String marshall( final TDefinitions definition ) throws JAXBException, SAXException {
		return marshall( definition, DEFAULT_VALIDATION );
	}

	protected void marshall( final TDefinitions definition, final Writer writer ) throws JAXBException, SAXException {
		marshall( definition, writer, DEFAULT_VALIDATION );
	}

	protected Marshaller getMarshaller() throws JAXBException, SAXException {
		Marshaller marshaller = getJAXBInstance().createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		marshaller.setProperty(NAMESPACE_MAPPER_PROPERTY, new NameSpaceMapper());
		return marshaller;
	}
	
	protected JAXBContext getJAXBInstance() throws JAXBException {
		return JAXBContext.newInstance( CMMNObjectFactory.class, TDefinitions.class );
	}
}
