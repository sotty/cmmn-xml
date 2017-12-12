package com.signavio.cmmn.xml.v11;

import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnReferencesTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "ns", "signavio/externalLink.json" );
		load( "in", "signavio/Inner Case.sgx" );
		load( "ou", "signavio/Outer Case.sgx" );
	}


	@Test
	public void testDecisionModelReference() throws IOException, JSONException {
		Node dc = xNode( "ns", "//cmmn:decision" );

		assertNotNull( dc );
		assertEquals( "sid-198ED8DC-D26F-4CA1-A847-871643A75596",
		              attr( dc, "externalRef" ).toString() );
		assertEquals( "http://www.signavio.com/dmn/1.1/diagram/03b8da84c0f243209163a37cc9231d1d.xml",
		              attr( dc, "xmlns" ).toString() );
	}

	@Test
	public void testCaseModelReference() throws IOException, JSONException {
		String innerNS = xString( "in", "//cmmn:definitions/@targetNamespace" );

		assertEquals( "http://www.signavio.com/cmmn/1.1/diagram/62f5410e0fbf46009e8cb807e4289f86.xml",
		              innerNS);

		String loc = xString( "ou", "//cmmn:caseTask/@caseRef" );
		assertEquals( "_",
		              loc );

		Node ref = xNode( "ou", "//cmmn:caseTask" );

		assertEquals( innerNS,
		              ( ( Element ) ref ).getAttribute( "xmlns" ) );
	}

}
