package com.signavio.cmmn.xml.v11;


import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.DiagramBuilder;
import org.json.JSONException;
import org.omg.spec.CMMN.xml.v11.CmmnXmlExporter;
import org.omg.spec.CMMN.xml.v11.CmmnXmlTestBase;

import java.util.Optional;

import static org.testng.AssertJUnit.fail;

public class CmmnXmlShapeTestBase extends CmmnXmlTestBase {


	@Override
	protected Optional<CmmnXmlExporter> getExporter( String model, String id, boolean validate ) {
		try {
			Diagram diagram = DiagramBuilder.parseJson( model, id );
			return Optional.of( new CmmnXmlShapeExporter( diagram, validate ) );
		} catch ( JSONException e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
		return Optional.empty();
	}


}
