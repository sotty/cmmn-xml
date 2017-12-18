package edu.mayo.mea3d.preprocess.meta;

import edu.mayo.kmdp.metadata.Association;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.w3c.dom.Document;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static edu.mayo.kmdp.MetadataHelper.assoc;
import static edu.mayo.kmdp.registry.Registry.OMG_API4KP_REL;
import static edu.mayo.kmdp.registry.Registry.PFX_OMG_API4KP_REL;
import static edu.mayo.kmdp.util.Util.isEmpty;
import static edu.mayo.kmdp.util.XMLUtil.loadXMLDocument;

public class IdentityMapper {

	private ExtractionStrategy strategy;

	private Map<String,String> innerToPublicIDMap = new HashMap<>();

	private Model graph;


	public IdentityMapper( ExtractionStrategy strategy ) {
		this.strategy = strategy;

		this.graph = ModelFactory.createDefaultModel();
		this.graph.setNsPrefix( PFX_OMG_API4KP_REL, OMG_API4KP_REL );
	}

	public void scan( InputStream resource ) {
		Optional<Document> dox = loadXMLDocument( resource );
		if ( dox.isPresent() ) {
			Optional<String> docId = strategy.getArtifactID( dox.get() );
			Optional<String> resId = strategy.getResourceID( dox.get() );

			if ( docId.isPresent() && resId.isPresent() && ! isEmpty( docId.get() ) && ! isEmpty( resId.get() ) ) {
				innerToPublicIDMap.put( docId.get(), resId.get() );
			}
		}
	}

	public Optional<String> getResourceId( String artifactId ) {
		return Optional.ofNullable( innerToPublicIDMap.get( artifactId ) );
	}

	public boolean hasIdMapped( String artifactId ) {
		return innerToPublicIDMap.containsKey( artifactId );
	}

	public boolean hasMappedId( String resourceId ) {
		return innerToPublicIDMap.containsValue( resourceId );
	}

	public int numMappedIds() {
		return innerToPublicIDMap.size();
	}


	public Association associate( String srcId, String tgtId, String rel ) {
		Resource tgt = graph.createResource( tgtId );
		graph.createResource( srcId ).addProperty( graph.createProperty( rel ), tgt );
		return assoc( tgtId, rel );
	}

	public ByteArrayOutputStream serializeModel() {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		graph.write( baos );
		return baos;
	}

	public void serializeModel( OutputStream os ) {
		graph.write( os );
	}

}
