package edu.mayo.mea3d;

import edu.mayo.kmdp.MetadataHelper;
import edu.mayo.kmdp.metadata.AssetSurrogate;
import edu.mayo.kmdp.metadata.Association;
import edu.mayo.mea3d.preprocess.meta.IdentityMapper;
import edu.mayo.mea3d.preprocess.meta.MetadataExtractor;
import edu.mayo.mea3d.util.JSONUtil;
import edu.mayo.mea3d.util.JaxbUtil;
import edu.mayo.mea3d.util.Registry;
import edu.mayo.mea3d.util.Util;
import edu.mayo.mea3d.util.XMLUtil;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.junit.jupiter.api.Test;

import javax.xml.transform.stream.StreamSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Optional;

import static edu.mayo.kmdp.MetadataHelper.DEPENDS;
import static edu.mayo.mea3d.preprocess.meta.MetadataExtractor.Format.JSON;
import static edu.mayo.mea3d.preprocess.meta.MetadataExtractor.Format.XML;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class MetadataTest {


	private static MetadataExtractor extractor = new MetadataExtractor();

	private String dmnPath = "/R2R.dmn";
	private String sgxPath = "/R2R.sgx";

	private String cmnPath = "/CCPM.cmmn";
	private String cgxPath = "/CCPM.sgx";

	private AssetSurrogate getEnsure( String dmnPath, String sgxPath ) {
		InputStream dmn = MetadataTest.class.getResourceAsStream( dmnPath );
		InputStream sgx = MetadataTest.class.getResourceAsStream( sgxPath );

		Optional<AssetSurrogate> res = extractor.extract( dmn, sgx );
		if ( ! res.isPresent() ) {
			fail( "Unable to extract Surrogate" );
			return null;
		} else {
			return res.get();
		}
	}

	@Test
	void testExtraction() {
		try {
			AssetSurrogate surr = getEnsure( dmnPath, sgxPath );

			assertEquals( 1, surr.getKnowledge().size() );

			assertNotNull( surr.getAssetID() );
			assertNotNull( surr.getAssetID().getUri() );
			assertNotNull( surr.getAssetID().getVersionedUri() );
			assertNotNull( surr.getTitle() );

			assertNotNull( surr.getCreationDate() );
			assertNotNull( surr.getLastChangeDate() );

			assertEquals( "draft", surr.getCurrentPublicationStatus().getLabel() );
		} catch ( Exception e ) {
			e.printStackTrace();
			fail( e.getMessage() );
		}
	}



	@Test
	void testXMLValidate() {
		Optional<ByteArrayOutputStream> baos = extractor.doExtract( dmnPath, sgxPath, XML, JaxbUtil.defaultProperties() );
		if ( ! baos.isPresent() ) {
			fail( "Unable to create metadata" );
		} else {
			boolean ans = baos.map( ByteArrayOutputStream::toByteArray )
			    .map( ByteArrayInputStream::new )
			    .map( StreamSource::new )
			    .map( (dox) -> XMLUtil.validate( dox, Registry.Languages.DMN ) )
			                  .orElse( false );
			assertTrue( ans );
		}
	}

	@Test
	void testDependencyResolution() {
		InputStream dmn = MetadataTest.class.getResourceAsStream( dmnPath );
		InputStream cmn = MetadataTest.class.getResourceAsStream( cmnPath );
		IdentityMapper mapper = extractor.getMapper();

		mapper.scan( dmn );
		mapper.scan( cmn  );

		assertEquals( 2, mapper.numMappedIds() );

		AssetSurrogate surr = getEnsure( cmnPath, cgxPath );

		if ( surr != null ) {
			assertEquals( 1, surr.getAssociatedTo().size() );
			Association axx = surr.getAssociatedTo().get( 0 );

			URI tgt = axx.getTarget().getUri();
			assertNotNull( tgt );
			assertTrue( mapper.hasMappedId( tgt.toString() ) );

			assertEquals( DEPENDS, axx.getRelType().getUri().toString() );
		}

		ByteArrayOutputStream baos = mapper.serializeModel();
		Model m = ModelFactory.createDefaultModel().read( new ByteArrayInputStream( baos.toByteArray() ),
		                                                 "" );

		mapper.serializeModel( System.out );

		Resource subj = m.getResource( "http://assets.ckm.mayo.edu/190a29b8-9bbd-4759-9046-6837196da93a" );
		assertNotNull( subj );
		Statement rel = subj.getProperty( m.getProperty( DEPENDS ) );
		assertNotNull( rel );
		assertEquals( "http://assets.ckm.mayo.edu/0df192bc-6b12-4a57-9031-2f8c04476225",
		              rel.getObject().toString() );
	}


	@Test
	void testToXML() {
		assertTrue( extractor.doExtract( dmnPath, sgxPath, XML, JaxbUtil.defaultProperties() )
		         .map( Util::printOut ).isPresent() );
		assertTrue( extractor.doExtract( cmnPath, cgxPath, XML, JaxbUtil.defaultProperties() )
		         .map( Util::printOut ).isPresent() );
	}



	@Test
	void testToJson() {
		assertTrue( extractor.doExtract( dmnPath, sgxPath, JSON, JSONUtil.defaultProperties() )
		                     .map( Util::printOut ).isPresent() );
		assertTrue( extractor.doExtract( cmnPath, cgxPath, JSON, JSONUtil.defaultProperties() )
		                     .map( Util::printOut ).isPresent() );
	}


}
