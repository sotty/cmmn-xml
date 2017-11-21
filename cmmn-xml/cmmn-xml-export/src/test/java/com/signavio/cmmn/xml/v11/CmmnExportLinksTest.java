package com.signavio.cmmn.xml.v11;

import org.json.JSONException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertSame;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

public class CmmnExportLinksTest extends CmmnXmlShapeTestBase {

	@BeforeTest
	public void init() {
		load( "ns", "signavio/sentry.json" );
		load( "s2s", "signavio/sentry2sentry.json" );
		load( "sNs", "signavio/manyS2S.json" );
		load( "ml", "signavio/milestone.json" );
	}


	@Test
	public void testTaskLinkedSentry() throws IOException, JSONException {
		Node ec = xNode( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem/cmmn:entryCriterion" );
		Node xc = xNode( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem/cmmn:exitCriterion" );
		Node st = xNode( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:sentry" );
		Node ts = xNode( "ns", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:task" );

		assertNotNull( ec );
		assertNull( xc );
		assertNotNull( st );
		assertNotNull( ts );

		assertEquals( attr( st, "id" ), attr( ec, "sentryRef" ) );
		assertEquals( attr( ts, "id" ), attr( ec.getParentNode(), "definitionRef" ) );
	}

	@Test
	public void testSentryLinkedSentry() throws IOException, JSONException {
		NodeList pil = xList( "s2s", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem" );
		NodeList sts = xList( "s2s", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:sentry" );
		NodeList exc = xList( "s2s", "/cmmn:definitions//cmmn:exitCriterion" );
		NodeList enc = xList( "s2s", "/cmmn:definitions//cmmn:entryCriterion" );
		NodeList onx = xList( "s2s", "/cmmn:definitions//cmmn:planItemOnPart" );

		assertEquals( 2, pil.getLength() );
		assertEquals( 2, sts.getLength() );
		assertEquals( 1, exc.getLength() );
		assertEquals( 1, enc.getLength() );
		assertEquals( 1, onx.getLength() );

		Node taskA = xNode( "s2s", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:task[@id='sid-taskA']"  );
		Node taskB = xNode( "s2s", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:task[@id='sid-taskB']"  );
		assertNotNull( taskA );
		assertNotNull( taskB );

		Node taskAItem = xNode( "s2s", "//cmmn:planItem[@definitionRef='" + attr( taskA, "id" )+ "']"  );
		Node taskBItem = xNode( "s2s", "//cmmn:planItem[@definitionRef='" + attr( taskB, "id" )+ "']"  );
		assertNotNull( taskAItem );
		assertNotNull( taskBItem );

		Node exit = exc.item( 0 );
		Node entr = enc.item( 0 );
		assertSame( taskAItem, exit.getParentNode()  );
		assertSame( taskBItem, entr.getParentNode()  );

		String exitSentryId = ( String ) attr( exit, "sentryRef" );
		Node exitSentry = xNode( "s2s", "//cmmn:sentry[@id='" + exitSentryId + "']" );
		assertNotNull( exitSentry );
		NodeList onExit = xList( "s2s", "//cmmn:sentry[@id='" + exitSentryId + "']/cmmn:planItemOnPart" );
		assertEquals( 0, onExit.getLength() );

		String entrSentryId = ( String ) attr( entr, "sentryRef" );
		NodeList onEntr = xList( "s2s", "//cmmn:sentry[@id='" + entrSentryId + "']/cmmn:planItemOnPart" );
		assertEquals( 1, onEntr.getLength() );

		assertEquals( attr( exit, "id" ), attr( onEntr.item( 0 ), "exitCriterionRef" ) );
		assertEquals( attr( taskAItem, "id" ), attr( onEntr.item( 0 ), "sourceRef" ) );
	}

	@Test
	public void testMany2ManySentry() throws IOException, JSONException {
		NodeList tsk = xList( "sNs", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:task" );
		assertEquals( 4, tsk.getLength() );

		NodeList def = xList( "sNs", "/cmmn:definitions/cmmn:case/cmmn:casePlanModel/cmmn:planItem" );
		assertEquals( 4, def.getLength() );

		NodeList exc = xList( "sNs", "//cmmn:exitCriterion" );
		assertEquals( 2, exc.getLength() );

		NodeList inc = xList( "sNs", "//cmmn:entryCriterion" );
		assertEquals( 3, inc.getLength() );

		NodeList snt = xList( "sNs", "//cmmn:sentry" );
		assertEquals( 5, snt.getLength() );

		String idA = ( String ) attr( xNode( "sNs", "//cmmn:task[@name='A']" ), "id" );
		String idB = ( String ) attr( xNode( "sNs", "//cmmn:task[@name='B']" ), "id" );
		String idC = ( String ) attr( xNode( "sNs", "//cmmn:task[@name='C']" ), "id" );
		String idD = ( String ) attr( xNode( "sNs", "//cmmn:task[@name='D']" ), "id" );

		Node itemA = xNode( "sNs", "//cmmn:planItem[@definitionRef='" + idA + "']" );
		Node itemB = xNode( "sNs", "//cmmn:planItem[@definitionRef='" + idB + "']" );
		Node itemC = xNode( "sNs", "//cmmn:planItem[@definitionRef='" + idC + "']" );
		Node itemD = xNode( "sNs", "//cmmn:planItem[@definitionRef='" + idD + "']" );

		String itemAid = ( String ) attr( itemA, "id" );
		String itemBid = ( String ) attr( itemB, "id" );
		String itemCid = ( String ) attr( itemC, "id" );
		String itemDid = ( String ) attr( itemD, "id" );

		NodeList critA = xList( "sNs", "//cmmn:planItem[@id='" + itemAid + "']/cmmn:exitCriterion" );
		NodeList critB = xList( "sNs", "//cmmn:planItem[@id='" + itemBid + "']/cmmn:exitCriterion" );
		NodeList critC = xList( "sNs", "//cmmn:planItem[@id='" + itemCid + "']/cmmn:entryCriterion" );
		NodeList critD = xList( "sNs", "//cmmn:planItem[@id='" + itemDid + "']/cmmn:entryCriterion" );

		assertEquals( 1, critA.getLength() );
		assertEquals( 1, critB.getLength() );
		assertEquals( 1, critC.getLength() );
		assertEquals( 2, critD.getLength() );

		String sentryRefA = ( String ) attr( critA.item( 0 ), "sentryRef" );
		String sentryRefB = ( String ) attr( critB.item( 0 ), "sentryRef" );
		String sentryRefC = ( String ) attr( critC.item( 0 ), "sentryRef" );
		String sentryRefD1 = ( String ) attr( critD.item( 0 ), "sentryRef" );
		String sentryRefD2 = ( String ) attr( critD.item( 1 ), "sentryRef" );

		Node sentry1 = xNode( "sNs", "//cmmn:sentry[@id='" + sentryRefA + "']" );
		Node sentry2 = xNode( "sNs", "//cmmn:sentry[@id='" + sentryRefB + "']" );
		Node sentry3 = xNode( "sNs", "//cmmn:sentry[@id='" + sentryRefC + "']" );
		Node sentry41 = xNode( "sNs", "//cmmn:sentry[@id='" + sentryRefD1 + "']" );
		Node sentry42 = xNode( "sNs", "//cmmn:sentry[@id='" + sentryRefD2 + "']" );

		assertEquals( 1, children( sentry1, "cmmn:ifPart" ).size() );
		assertEquals( 0, children( sentry1, "cmmn:planItemOnPart" ).size() );
		assertEquals( 1, children( sentry2, "cmmn:ifPart" ).size() );
		assertEquals( 0, children( sentry2, "cmmn:planItemOnPart" ).size() );

		assertEquals( 1, children( sentry3, "cmmn:ifPart" ).size() );
		assertEquals( 2, children( sentry3, "cmmn:planItemOnPart" ).size() );
		assertEquals( 1, children( sentry41, "cmmn:ifPart" ).size() );
		assertEquals( 1, children( sentry41, "cmmn:planItemOnPart" ).size() );
		assertEquals( 1, children( sentry42, "cmmn:ifPart" ).size() );
		assertEquals( 1, children( sentry42, "cmmn:planItemOnPart" ).size() );

		Node cOn1 = ((List<Node> ) children( sentry3, "cmmn:planItemOnPart" )).get( 0 );
		Node cOn2 = ((List<Node> ) children( sentry3, "cmmn:planItemOnPart" )).get( 1 );
		Node dOn1 = ((List<Node> ) children( sentry41, "cmmn:planItemOnPart" )).get( 0 );
		Node dOn2 = ((List<Node> ) children( sentry42, "cmmn:planItemOnPart" )).get( 0 );

		assertEquals( attr( cOn1, "exitCriterionRef" ), attr( critA.item( 0 ), "id" ) );
		assertEquals( attr( cOn2, "exitCriterionRef" ), attr( critB.item( 0 ), "id" ) );
		assertEquals( attr( dOn1, "exitCriterionRef" ), attr( critA.item( 0 ), "id" ) );
		assertEquals( attr( dOn2, "exitCriterionRef" ), attr( critB.item( 0 ), "id" ) );

	}



	@Test
	public void testMilestoneLinks() throws IOException, JSONException {
		Node ms = xNode( "ml", "//cmmn:milestone" );
		Node pt = xNode( "ml", "//cmmn:processTask" );
		Node el = xNode( "ml", "//cmmn:eventListener" );

		assertNotNull( ms );
		assertEquals( "Mile", attr( ms, "name" ) );
		assertNotNull( pt );
		assertEquals( "A", attr( pt, "name" ) );
		assertNotNull( el );

		Node mItem = xNode( "ml", "//cmmn:planItem[@definitionRef='" + attr( ms, "id" ) + "']" );
		assertNotNull( mItem );
		assertEquals( 2, children( mItem, "cmmn:entryCriterion" ).size() );
		assertEquals( 0, children( mItem, "cmmn:exitCriterion" ).size() );

		Node pItem = xNode( "ml", "//cmmn:planItem[@definitionRef='" + attr( pt, "id" ) + "']" );
		assertNotNull( pItem );
		assertEquals( 0, children( pItem, "cmmn:entryCriterion" ).size() );
		assertEquals( 0, children( pItem, "cmmn:exitCriterion" ).size() );

		Node eItem = xNode( "ml", "//cmmn:planItem[@definitionRef='" + attr( el, "id" ) + "']" );
		assertNotNull( eItem );
		assertEquals( 0, children( eItem, "cmmn:entryCriterion" ).size() );
		assertEquals( 0, children( eItem, "cmmn:exitCriterion" ).size() );

		NodeList ss = xList( "ml", "//cmmn:sentry" );
		assertEquals( 2, ss.getLength() );

		Node s1 = xNode( "ml", "//cmmn:sentry/cmmn:planItemOnPart[@sourceRef='def_sid-evn']" );
		Node s2 = xNode( "ml", "//cmmn:sentry/cmmn:planItemOnPart[@sourceRef='def_sid-ptask']" );

		assertNotNull( s1 );
		assertNotNull( s2 );

	}

}
