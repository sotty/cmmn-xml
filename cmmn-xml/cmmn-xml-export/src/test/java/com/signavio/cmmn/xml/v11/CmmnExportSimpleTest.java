package com.signavio.cmmn.xml.v11;


import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.Map;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;
import static org.testng.AssertJUnit.assertSame;
import static org.testng.AssertJUnit.assertTrue;

public class CmmnExportSimpleTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "hw", "signavio/hello-world.json" );
		load( "all", "signavio/all.json" );
	}


	@Test
	public void testRoot() throws IOException, JSONException {
		NodeList v = xList( "hw", "/cmmn:definitions" );
		assertEquals( 1, v.getLength() );
		Node root = v.item( 0 );
		Map<String,Document> map = xmls;
		assertSame( root, map.get( "hw" ).getDocumentElement() );

		assertEquals( Constants.DEFAULT_EXPORTER, attr( root, "exporter" ) );
	}

	@Test
	public void testPreserveIDs() throws IOException, JSONException {
		Node p = xNode( "hw", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:processTask[@name='a']" );
		assertNotNull( p );
		assertEquals( "a", attr( p, "name" ) );

		assertEquals( "sid-BC817AFD-637F-43F8-9C9C-A613C8F8325F", attr( p, "id" ) );
	}

	@Test
	public void testNamespaces() {
		Node n = xNode( "hw", "/cmmn:definitions" );
		assertEquals( org.omg.spec.CMMN.xml.v11.Constants.NS_OMG_CMMN_v11, attr( n, "xmlns:cmmn" ) );
		assertEquals( org.omg.spec.CMMN.xml.v11.Constants.NS_OMG_CMMN_CMMNDI_v11, attr( n, "xmlns:cmmndi" ) );
		assertEquals( org.omg.spec.CMMN.xml.v11.Constants.NS_OMG_CMMN_DC_v11, attr( n, "xmlns:dc" ) );
		assertEquals( Constants.NS_SCHEMA_SIGNAVIO, attr( n, "xmlns:" + Constants.NS_NAME_SIGNAVIO_EXTENSIONS ) );

		assertEquals( org.omg.spec.CMMN.xml.v11.Constants.NS_OMG_CMMN_DI_v11, attr( n, "xmlns:di" ) );

		String tgt = attr( n, "targetNamespace" ).toString();
		String sig = attr( n, "xmlns:" + Constants.NS_NAME_SIGNAVIO ).toString();

		assertEquals( sig, Constants.NS_DIAGRAM_SIGNAVIO + tgt );
	}


	@Test
	public void testProcessTask() throws IOException, JSONException {
		Node t = xNode( "hw", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:processTask" );
		assertNotNull( t );
		assertEquals( "a", attr( t, "name") );
		assertEquals( "true", attr( t, "isBlocking" ) );
	}

	@Test
	public void testTask() throws IOException, JSONException {
		NodeList l = xList( "hw", "/cmmn:definitions//cmmn:task" );
		assertNotNull( l );
		assertEquals( 1, l.getLength() );
		Node t = l.item( 0 );
		assertEquals( "b", attr( t,"name"  ) );
		assertEquals( "true", attr( t, "isBlocking" ) );
	}

	@Test
	public void testDocumentation() throws IOException, JSONException {
		Node d = xNode( "hw", "/cmmn:definitions/cmmn:case/cmmn:documentation" );
		assertNotNull( d );
		assertEquals( "text/plain", attr( d, "textFormat" ) );
		assertEquals( "This is a Doc", d.getTextContent() );
	}

	@Test
	public void testPlanDefinitionLinks() throws IOException, JSONException {
		NodeList l = xList( "hw", "//cmmn:planItem" );
		assertNotNull( l );
		assertEquals( 2, l.getLength() );
		for ( int j = 0; j < l.getLength(); j++ ) {
			Node planItem = l.item( j );
			String refId = ( String ) attr( planItem, "definitionRef" );
			Node ref = xNode( "hw", "//*[@id='" + refId + "']" );
			assertNotNull( ref );
			assertTrue( "task".equals( ref.getLocalName() ) || "processTask".equals( ref.getLocalName() ) );
		}
	}

	//@Test
	public void testLoadFullExample() throws IOException, JSONException {
		NodeList l = xList( "all", "//cmmn:definitions" );
		assertNotNull( l );
	}

}
