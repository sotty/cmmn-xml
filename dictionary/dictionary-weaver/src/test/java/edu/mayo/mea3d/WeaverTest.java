package edu.mayo.mea3d;

import edu.mayo.mea3d.preprocess.meta.DictionaryEntryWeaver;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static edu.mayo.mea3d.util.PropertiesUtil.props;
import static edu.mayo.mea3d.util.Util.resolveResource;
import static edu.mayo.mea3d.util.XMLUtil.loadXMLDocument;
import static edu.mayo.mea3d.util.XMLUtil.streamXMLDocument;
import static edu.mayo.mea3d.util.XMLUtil.validate;
import static edu.mayo.mea3d.util.XPathUtil.attr;
import static edu.mayo.mea3d.util.XPathUtil.xNode;
import static edu.mayo.mea3d.util.XPathUtil.xString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class WeaverTest {

	@Test
	void testInit() {
		try {
			new DictionaryEntryWeaver();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
	}

	@Test
	void testWeave() {
		String path = "/Diabetic.dmn";
		Document dox = loadXMLDocument( resolveResource( path ) ).orElseGet( () -> fail( "Unable to load document " + path ) );

		try {
			new DictionaryEntryWeaver( true ).weave( dox );


			streamXMLDocument( dox, System.out );
			assertTrue( validate( dox ) );
		} catch ( IllegalStateException ie ) {
			ie.printStackTrace();
			fail( ie.getMessage() );
		}
	}

	@Test
	void testWeaveDefault() {
		String path = "/Diabetic.dmn";
		Document dox = loadXMLDocument( resolveResource( path ) ).orElseGet( () -> fail( "Unable to load document " + path ) );

		try {
			new DictionaryEntryWeaver( true ).weave( dox );

			assertTrue( validate( dox ) );

			streamXMLDocument( dox, System.out );
		} catch ( IllegalStateException ie ) {
			ie.printStackTrace();
			fail( ie.getMessage() );
		}
	}


	@Test
	void testVariousMetadata() {
		String path = "/mock.dmn";
		Document dox = loadXMLDocument( resolveResource( path ) ).orElseGet( () -> fail( "Unable to load document " + path ) );

		try {
			new DictionaryEntryWeaver( true ).weave( dox );

			streamXMLDocument( dox, System.out );

			assertNotNull( dox );

			assertEquals( "http://my.test.com/123456",
			              attr( xNode( dox, "//surr:Annotation[@label='knowledgeResourceId']" ), "value" ) );

			assertEquals( "Semantic decision model",
			              xString( dox, "//surr:Annotation[@label='knowledgeResourceType']/surr:conceptRef/@label" ) );

			assertEquals( "Value of : Current | Blood Pressure",
			              xString( dox, "//dmn:itemDefinition/dmn:extensionElements/surr:Annotation[@label='propositionalConcept']/surr:conceptRef/@label" ) );

			assertEquals( "Diabetes Mellitus",
			              xString( dox, "//dmn:decision//surr:Annotation[@label='focalConcept']/surr:conceptRef/@label" ) );

			assertEquals( "http://terms.mayo.edu/0215e32f-cced-4388-b0e0-ec8114e632d2",
			              xString( dox, "//dmn:decision//surr:Annotation[@label='focalConcept']/surr:conceptRef/@uri" ) );

			assertEquals( "http://www.foo.bar",
			              xString( dox, "//dmn:knowledgeSource[@name='all']/@locationURI" ) );


		} catch ( IllegalStateException ie ) {
			ie.printStackTrace();
			fail( ie.getMessage() );
		}
	}


	@Test
	void testVariousMetadataOnCMMN() {
		String path = "/mock.cmmn";
		Document dox = loadXMLDocument( resolveResource( path ) ).orElseGet( () -> fail( "Unable to load document " + path ) );

		try {
			new DictionaryEntryWeaver( true,
			                           props() .set( "METADATA_NS",
					                                 "http://www.signavio.com/schema/cmmn/1.1/").get() )
					.weave( dox );

			streamXMLDocument( dox, System.out );

			assertEquals( "http://assets.ckm.mayo.edu/190a29b8-9bbd-4759-9046-6837196da93a",
			              attr( xNode( dox, "//surr:meta[@name='knowledgeResourceId']" ), "value" ) );

			assertNotNull( xNode( dox, "//cmmn:documentation" ) );
		} catch ( IllegalStateException ie ) {
			ie.printStackTrace();
			fail( ie.getMessage() );
		}
	}


}
