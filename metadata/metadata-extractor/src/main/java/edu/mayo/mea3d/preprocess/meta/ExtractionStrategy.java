package edu.mayo.mea3d.preprocess.meta;

import com.fasterxml.jackson.databind.JsonNode;
import edu.mayo.kmdp.metadata.AssetSurrogate;
import edu.mayo.kmdp.metadata.FormalNotation;
import edu.mayo.kmdp.metadata.KnowledgeInfo;
import org.w3c.dom.Document;

import java.io.File;
import java.util.Optional;

public interface ExtractionStrategy {

	IdentityMapper getMapper();

	void setMapper( IdentityMapper mapper );

	AssetSurrogate extractXML( Document dox, JsonNode meta );

	Optional<String> getResourceID( Document dox );

	Optional<String> getArtifactID( Document dox );

	Optional<FormalNotation> getRepLanguage( Document dox, boolean concrete );

	String getMetadataEntryNameForID( String id );

	default AssetSurrogate newSurrogate() {
		AssetSurrogate surr = new AssetSurrogate();
		KnowledgeInfo know = new KnowledgeInfo();
		surr.withKnowledge( know );
		return surr;
	}

}
