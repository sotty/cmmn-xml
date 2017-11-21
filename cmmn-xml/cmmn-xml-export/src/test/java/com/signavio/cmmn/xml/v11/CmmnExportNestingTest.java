package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;

public class CmmnExportNestingTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "ns", "signavio/nested.json" );
		load( "cp", "signavio/caseplan.json" );
		load( "tk", "signavio/tasks.json" );
	}


	@Test
	public void testNestedStages() throws IOException, JSONException {
		NodeList l = xList( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel//cmmn:stage" );
		assertEquals( 3, l.getLength() );

		NodeList s = xList( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel//cmmn:stage/cmmn:stage" );
		assertEquals( 2, s.getLength() );

		NodeList t = xList( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel//cmmn:task" );
		assertEquals( 3, t.getLength() );

		NodeList r = xList( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel//cmmn:planItem" );
		assertEquals( 6, r.getLength() );

		NodeList f = xList( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem" );
		assertEquals( 1, f.getLength() );

		Node a = xNode( "ns", "//cmmn:stage[@name='Inner1']/cmmn:task" );
		assertNotNull( a );
		assertEquals( "A", attr( a, "name" ) );

		Node c = xNode( "ns", "//cmmn:stage[@name='Outer']/cmmn:task" );
		assertNotNull( c );
		assertEquals( "C", attr( c, "name" ) );
	}

	@Test
	public void testCasePlan() {
		NodeList l = xList( "cp", "/cmmn:definitions/cmmn:case" );
		assertEquals( 2, l.getLength() );

		NodeList t = xList( "cp", "//cmmn:task" );
		assertEquals( 1, t.getLength() );

		Node mp = xNode( "cp", "//cmmn:case/cmmn:casePlanModel[@name='MasterPlan']" );
		assertNotNull( mp );
		assertEquals( "true", attr( mp, "autoComplete" ) );

		Node doc = xNode( "cp", "//cmmn:case/cmmn:casePlanModel[@name='MasterPlan']/cmmn:documentation" );
		assertEquals( "Descr", doc.getTextContent().trim() );
		assertSame( t.item( 0 ).getParentNode(), mp );

		Node ap = xNode( "cp", "//cmmn:case/cmmn:casePlanModel[@name='AnotherMasterPlan']" );
		assertNotNull( ap );
		assertEquals( 0, ap.getChildNodes().getLength() );

	}

	@Test
	public void testTasks() {
		NodeList l = xList( "tk", "//cmmn:planItem" );
		assertEquals( 6, l.getLength() );

		NodeList t = xList( "tk", "//cmmn:task" );
		assertEquals( 1, t.getLength() );

		NodeList hb = xList( "tk", "//cmmn:humanTask[@isBlocking='true']" );
		assertEquals( 1, hb.getLength() );

		NodeList hnb = xList( "tk", "//cmmn:humanTask[@isBlocking='false']" );
		assertEquals( 1, hnb.getLength() );

		NodeList p = xList( "tk", "//cmmn:processTask" );
		assertEquals( 1, p.getLength() );

		NodeList c = xList( "tk", "//cmmn:caseTask" );
		assertEquals( 1, c.getLength() );

		NodeList d = xList( "tk", "//cmmn:decisionTask" );
		assertEquals( 1, d.getLength() );

		NodeList px = xList( "tk", "//cmmn:process" );
		assertEquals( 1, px.getLength() );

		NodeList dx = xList( "tk", "//cmmn:decision" );
		assertEquals( 1, dx.getLength() );

	}

}
