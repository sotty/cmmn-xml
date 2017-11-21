package com.signavio.cmmn.xml.v11;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.omg.spec.CMMN.xml.v11.CmmnXmlExporter;
import org.omg.spec.CMMN.xml.v11.CmmnXmlTestBase;

import java.io.ByteArrayInputStream;
import java.util.Optional;

import static org.testng.AssertJUnit.fail;

public class CmmnXmlRdfTestBase extends CmmnXmlTestBase {


	protected Optional<CmmnXmlExporter> getExporter( String model, String id, boolean validate ) {
		try {
			Model rdfModel = ModelFactory.createDefaultModel() ;
			rdfModel.read( new ByteArrayInputStream( model.getBytes() ), Constants.NS_DIAGRAM_SIGNAVIO, null );
			return Optional.of( new CmmnXmlRDFExporter( rdfModel, validate ) );
		} catch ( Exception e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
		return Optional.empty();
	}


}
