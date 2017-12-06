package org.omg.spec.cmmn._20151109;


import org.omg.spec.cmmn._20151109.cmmndi.CMMNDI;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNDiagram;
import org.omg.spec.cmmn._20151109.model.ObjectFactory;
import org.omg.spec.cmmn._20151109.model.TDefinitions;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

public class ModelGenerationTest {

	@Test
	public void testModelGeneration() {
		ObjectFactory f = new ObjectFactory();
		org.omg.spec.cmmn._20151109.cmmndi.ObjectFactory d = new org.omg.spec.cmmn._20151109.cmmndi.ObjectFactory();

		TDefinitions defs = f.createTDefinitions();

		defs.withAuthor( "self" )
		    .withCase( f.createTCase().withId( "1" ), f.createTCase().withId( "2" ) )
	        .withCMMNDI( new CMMNDI().withCMMNDiagram( (CMMNDiagram) new CMMNDiagram().withId( "D" ) ) );

		assertEquals( "self", defs.getAuthor() );

		assertEquals( 2, defs.getCase().size() );
		assertEquals( "1", defs.getCase().get( 0 ).getId() );

		assertEquals( 1, defs.getCMMNDI().getCMMNDiagram().size() );
		assertEquals( "D", defs.getCMMNDI().getCMMNDiagram().get( 0 ).getId() );
		assertFalse( defs.getCMMNDI().getCMMNDiagram().get( 0 ).isSetSize() );
	}
}
