package edu.mayo.mea3d.preprocess.meta;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.kmdp.metadata.AssetSurrogate;
import edu.mayo.kmdp.metadata.ObjectFactory;
import edu.mayo.kmdp.util.JSONUtil;
import edu.mayo.kmdp.util.JaxbUtil;
import edu.mayo.kmdp.util.PropertiesUtil;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

import static edu.mayo.kmdp.util.JaxbUtil.marshall;
import static edu.mayo.kmdp.util.XMLUtil.loadXMLDocument;
import static edu.mayo.kmdp.util.ZipUtil.readZipEntry;

public class MetadataExtractor {


	public enum Format {
		JSON( ".json" ),
		XML( ".xml" );

		private String ext;

		Format( String ext ) {
			this.ext = ext;
		}

		public String ext() {
			return ext;
		}
	}


	private ExtractionStrategy strategy;

	private IdentityMapper mapper;

	public MetadataExtractor() {
		strategy = new SigExtractionStrategy();
		mapper = new IdentityMapper( strategy );
		strategy.setMapper( mapper );
	}

	public IdentityMapper getMapper() {
		return mapper;
	}

	public Optional<AssetSurrogate> extract( InputStream resource, InputStream meta ) {
		Optional<Document> dox = loadXMLDocument( resource );
		return dox.map( document -> extract( document,
		                                     loadDescriptor( document, meta ).orElse( null ) ) );
	}


	public Optional<ByteArrayOutputStream> doExtract( String resPath, String metaPath, Format f, Properties p ) {
		InputStream res = MetadataExtractor.class.getResourceAsStream( resPath );
		InputStream met = MetadataExtractor.class.getResourceAsStream( metaPath );

		return doExtract( res, met, f, p );
	}


	public Optional<ByteArrayOutputStream> doExtract( InputStream resource, InputStream meta, Format f, Properties p ) {
		ObjectFactory mdf = new ObjectFactory();
		return extract( resource, meta ).flatMap( (surr) -> {
			switch ( f ) {
				case JSON :
					return JSONUtil.writeJson( surr, p );
				case XML :
				default:
					return marshall( mdf.getClass(),
				                            mdf.createAssetSurrogate( surr ), p );
			}
		} );
	}

	public Optional<Document> doExtract( Document dox, JsonNode meta ) {
		ObjectFactory factory = new ObjectFactory();
		return JaxbUtil.marshallDox( factory.getClass(),
		                             extract( dox, meta ),
		                             factory::createAssetSurrogate,
		                             PropertiesUtil.empty() );
	}

	public AssetSurrogate extract( Document dox, JsonNode meta ) {
		return strategy.extractXML( dox, meta );
	}

	private Optional<JsonNode> loadDescriptor( Document document, InputStream meta ) {
		Optional<String> resId = strategy.getResourceID( document );
		Optional<String> innId = strategy.getArtifactID( document );

		if ( innId.isPresent() ) {
			return readZipEntry( strategy.getMetadataEntryNameForID( innId.get() ), meta )
					.flatMap( JSONUtil::readJson );
		} else {
			return Optional.empty();
		}
	}



}
