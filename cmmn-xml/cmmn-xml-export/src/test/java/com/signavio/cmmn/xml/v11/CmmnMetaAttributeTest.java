package com.signavio.cmmn.xml.v11;

import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnMetaAttributeTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "ns", "signavio/metadata.sgx" );
	}

	@Test
	public void testMetadata() throws IOException, JSONException {
		Node id = xNode( "ns", "//sigExt:diagramMetaData[@name='assetid']" );
		String kt = xString( "ns", "//sigExt:diagramMetaData[@name='knowledgeassettype']/@value" );
		assertNotNull( id );
		assertNotNull( kt );

		assertEquals( "/glossary/13f9acb4b9be4182b0d4f3923177f1a2", kt );
	}

}
