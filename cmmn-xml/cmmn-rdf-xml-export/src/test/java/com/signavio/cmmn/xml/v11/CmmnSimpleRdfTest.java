package com.signavio.cmmn.xml.v11;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.NodeList;

import java.io.IOException;

import static org.testng.AssertJUnit.assertNotNull;

public class CmmnSimpleRdfTest extends CmmnXmlRdfTestBase {

	@BeforeTest
	public void init() {
		load( "hw", "rdf/hello_world.rdf.xml" );
	}


	@Test
	public void testRoot() throws IOException {
		NodeList t = xList( "hw", "//cmmn:task[@name='A']//repetitionRule" );
		assertNotNull( t );
	}


}
