package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class CmmnExportEventListenerTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "ev", "signavio/events.json" );
	}

	@Test
	public void testEventListeners() throws IOException, JSONException {
		NodeList l = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:stage/cmmn:planItem" );
		assertEquals( 3, l.getLength() );

		NodeList e = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:stage/cmmn:eventListener" );
		assertEquals( 1, e.getLength() );

		NodeList t = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:stage/cmmn:timerEventListener" );
		assertEquals( 1, t.getLength() );

		NodeList u = xList( "ev", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:stage/cmmn:userEventListener" );
		assertEquals( 1, u.getLength() );

		assertEquals( attr( e.item( 0 ), "id" ),
		              attr( l.item( 0 ), "definitionRef" ) );

		assertEquals( attr( t.item( 0 ), "id" ),
		              attr( l.item( 1 ), "definitionRef" ) );

		assertEquals( attr( u.item( 0 ), "id" ),
		              attr( l.item( 2 ), "definitionRef" ) );

	}

}
