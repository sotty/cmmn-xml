package com.signavio.cmmn.xml.v11;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnExportComplexTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "c2", "signavio/complex2.json" );
		load( "c1", "signavio/complex1.json" );
	}


	@Test
	public void testComplexSentriesWithPlanningAndEvents() {
		assertNotNull( xList( "c2", "/cmmn:definitions" ) );

		assertNotNull( xNode( "c2", "//cmmn:casePlanModel/cmmn:planItem/cmmn:entryCriterion" ) );
		assertNotNull( xNode( "c2", "//cmmn:casePlanModel/cmmn:sentry/cmmn:planItemOnPart" ) );
		assertNotNull( xNode( "c2", "//cmmn:casePlanModel/cmmn:stage" ) );

		assertEquals( 2, xList( "c2", "//cmmn:casePlanModel/cmmn:stage/cmmn:sentry" ).getLength() );
		assertEquals( 1, xList( "c2", "//cmmn:casePlanModel/cmmn:stage/cmmn:planItem" ).getLength() );
		assertNotNull( xNode( "c2", "//cmmn:casePlanModel/cmmn:stage/" +
				"cmmn:planningTable/cmmn:discretionaryItem/cmmn:exitCriterion" ) );

	}

	@Test
	public void testCPM() {
		assertNotNull( xList( "c1", "/cmmn:definitions" ) );
	}




}
