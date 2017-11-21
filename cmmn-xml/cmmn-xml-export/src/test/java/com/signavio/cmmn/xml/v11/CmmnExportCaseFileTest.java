package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Node;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnExportCaseFileTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "fl", "signavio/caseFile.json" );
	}


	@Test
	public void  testCaseFiles() throws IOException, JSONException {
		Node cfid1 = xNode( "fl", "/cmmn:definitions/cmmn:caseFileItemDefinition[@name='B']" );
		Node cfid2 = xNode( "fl", "/cmmn:definitions/cmmn:caseFileItemDefinition[@name='A']" );

		assertNotNull( cfid1 );
		assertNotNull( cfid2 );

		Node cfm = xNode( "fl", "/cmmn:definitions/cmmn:case/cmmn:caseFileModel" );
		assertNotNull( cfm );

		Node cfi1 = xNode( "fl", "/cmmn:definitions/cmmn:case/cmmn:caseFileModel/cmmn:caseFileItem[@name='B']" );
		Node cfi2 = xNode( "fl", "/cmmn:definitions/cmmn:case/cmmn:caseFileModel/cmmn:caseFileItem[@name='A']" );

		assertNotNull( cfi1 );
		assertNotNull( cfi2 );
		assertEquals( attr( cfi1, "definitionRef" ), attr( cfid1, "id" ) );
		assertEquals( attr( cfi2, "definitionRef" ), attr( cfid2, "id" ) );

		Node s1 = xNode( "fl", "//cmmn:caseFileItemOnPart[@sourceRef='fileA']" );
		Node s2 = xNode( "fl", "//cmmn:caseFileItemOnPart[@sourceRef='fileB']" );

		assertNotNull( s1 );
		assertNotNull( s2 );
	}

}
