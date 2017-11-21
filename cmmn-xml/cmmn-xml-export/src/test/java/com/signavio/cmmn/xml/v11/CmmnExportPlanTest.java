package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnExportPlanTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "at", "signavio/task_attr.json" );
		load( "dc", "signavio/discretionary.json" );
		load( "fg", "signavio/fragments.json" );
		load( "hp", "signavio/human_plan.json" );
	}


	@Test
	public void testTaskAttributes() throws IOException, JSONException {
		Node r = xNode( "at", "//cmmn:task[@name='A']/cmmn:defaultControl/cmmn:repetitionRule" );
		Node q = xNode( "at", "//cmmn:task[@name='A']/cmmn:defaultControl/cmmn:requiredRule" );
		Node m = xNode( "at", "//cmmn:task[@name='A']/cmmn:defaultControl/cmmn:manualActivationRule" );

		assertNotNull( r );
		assertNotNull( q );
		assertNotNull( m );

		Node c = xNode( "at", "//cmmn:planningTable/cmmn:discretionaryItem[@definitionRef='sid-task']" );
		assertNotNull( c );
	}

	@Test
	public void testDiscretionary() throws IOException, JSONException {
		Node outerTable = xNode( "dc", "//cmmn:case/cmmn:casePlanModel/cmmn:planningTable[@id='sid-ptable']/cmmn:discretionaryItem[@definitionRef='sid-stage']" );
		Node innerTable = xNode( "dc", "//cmmn:case/cmmn:casePlanModel/cmmn:stage[@id='sid-stage']/cmmn:planningTable/cmmn:discretionaryItem[@definitionRef='sid-task']" );

		assertNotNull( innerTable );
		assertNotNull( outerTable );
	}

	@Test
	public void testDiscretionaryFragments() throws IOException, JSONException {
		NodeList discrList = xList( "fg", "//cmmn:case/cmmn:casePlanModel/cmmn:planningTable/cmmn:discretionaryItem" );
		assertEquals( 3, discrList.getLength() );

		NodeList taskList = xList( "fg", "//cmmn:case/cmmn:casePlanModel/cmmn:task" );
		assertEquals( 3, taskList.getLength() );

		NodeList fragList = xList( "fg", "//cmmn:case/cmmn:casePlanModel/cmmn:planFragment" );
		assertEquals( 2, fragList.getLength() );

		Node itemA = xNode( "fg", "//cmmn:case/cmmn:casePlanModel/cmmn:planFragment[@id='frag1']/cmmn:planItem[@definitionRef='taskA']" );
		assertNotNull( itemA );

	}

	@Test
	public void testDiscretionaryLinkHumanTask() throws IOException, JSONException {
		NodeList items = xList( "hp", "//cmmn:case/cmmn:casePlanModel/cmmn:planItem" );
		assertEquals( 1, items.getLength() );

		Node d = xNode( "hp", "//cmmn:case/cmmn:casePlanModel/cmmn:decisionTask[@id='dTask']" );
		Node h = xNode( "hp", "//cmmn:case/cmmn:casePlanModel/cmmn:humanTask[@id='hTask']" );

		assertNotNull( d );
		assertNotNull( h );

		Node dx = xNode( "hp", "//cmmn:case/cmmn:casePlanModel/cmmn:humanTask[@id='hTask']/cmmn:planningTable/cmmn:discretionaryItem[@definitionRef='dTask']" );
	}

}
