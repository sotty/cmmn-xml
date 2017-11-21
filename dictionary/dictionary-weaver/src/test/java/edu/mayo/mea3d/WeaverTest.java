package edu.mayo.mea3d;

import edu.mayo.mea3d.preprocess.meta.DictionaryWeaver;
import edu.mayo.mea3d.util.Util;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;

import static edu.mayo.mea3d.util.Util.loadXMLDocument;
import static edu.mayo.mea3d.util.Util.resolveResource;
import static org.junit.jupiter.api.Assertions.fail;

class WeaverTest {

	@Test
	void testInit() {
		try {
			new DictionaryWeaver();
		} catch ( Exception e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
	}

	@Test
	void testWeave() {
		String path = "/Diabetic.dmn";
		Document dox = loadXMLDocument( resolveResource( path ) ).orElseGet( () -> fail( "Unable to load document " + path ) );
		XSSFWorkbook dict = DictionaryWeaver.getDefaultDictionary().orElseGet( () -> fail( "Unable to load Dictionary " ) );

		try {
			new DictionaryWeaver( dict, true ).weave( dox );

			Util.streamXMLDocument( dox, System.out );
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
			new DictionaryWeaver( true ).weave( dox );
		} catch ( IllegalStateException ie ) {
			ie.printStackTrace();
			fail( ie.getMessage() );
		}
	}
}
