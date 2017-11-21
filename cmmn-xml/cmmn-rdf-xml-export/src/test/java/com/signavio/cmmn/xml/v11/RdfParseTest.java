package com.signavio.cmmn.xml.v11;


import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

public class RdfParseTest  {

	@Test
	public void testRDF() throws IOException, SAXException {

		InputStream is = RdfParseTest.class.getResourceAsStream( "/rdf/hello_world.rdf.xml" );

		Model rdfModel = ModelFactory.createDefaultModel() ;
		rdfModel.read( is, Constants.NS_DIAGRAM_SIGNAVIO, null );

		rdfModel.write( System.out );
	}


}
