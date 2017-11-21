package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.omg.spec.CMMN.xml.v11.NameSpaceMapper;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathFactory;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;

public class CmmnExportConnectorTest extends CmmnXmlShapeTestBase {

	@DataProvider(name = "docs")
	public static Object[][] documents() {
		return new Object[][] {
				{"signavio/connector1.json"},
				{"signavio/connector2.json"},
				{"signavio/connector3.json"},
				{"signavio/connector4.json"}
		};
	}

	@Test( dataProvider = "docs" )
	public void testConnector( String src ) throws IOException, JSONException {
		clear();
		load( "ev", src );

		xpath = XPathFactory.newInstance().newXPath();
		xpath.setNamespaceContext( new NameSpaceMapper().getNamespaceContext() );

		NodeList l = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem" );
		assertEquals( 2, l.getLength() );

		NodeList e = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:eventListener" );
		assertEquals( 1, e.getLength() );

		NodeList t = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:task" );
		assertEquals( 1, t.getLength() );

		NodeList s = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:sentry" );
		assertEquals( 1, s.getLength() );

		Node x = xNode( "ev", "//cmmn:exitCriterion" );
		assertNotNull( x );

		Node on = xNode( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:sentry/cmmn:planItemOnPart" );
		assertNotNull( on );

		// The tasks' item's exitCriterion points to the sentry
		assertSame( l.item( 0 ), x.getParentNode() );
		assertEquals( attr( t.item( 0 ), "id" ), attr( x.getParentNode(), "definitionRef") );
		assertEquals( attr( s.item( 0 ), "id" ), attr( x, "sentryRef") );

		// The sentry's ON references the planItem defined by the eventListener
		assertEquals( attr( l.item( 1 ), "definitionRef" ), attr( e.item( 0 ), "id") );
		assertEquals( attr( l.item( 1 ), "id" ), attr( on, "sourceRef" ) );
	}

}
