package com.signavio.cmmn.xml.v11.translator.casemodel;

import com.signavio.cmmn.xml.v11.Constants;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.rdf.model.impl.ResourceImpl;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class CMMNRdfCaseBuilder extends CMMNCaseBuilder<Model,Resource> {

	public static Resource ANON = new ResourceImpl();

	private Model model;

	private Resource root;
	private Map<Resource,Set<Resource>> chldLinks = new HashMap<>();
	private Set<Resource> individuals = new HashSet<>();

	private Property TYPE;
	private Property PARENT;

	public CMMNRdfCaseBuilder( Model model, CMMNObjectFactory factory ) {
		super( factory );
		this.model = model;
		this.decorator = new CMMNRdfCasePropertyDecorator( this );
		populate( model );
	}

	private void populate( Model model ) {
		TYPE = model.createProperty( Constants.ORYX, "type" );
		PARENT = model.createProperty( Constants.RAZIEL, "parent" );


		StmtIterator it = model.listStatements();
		while (it.hasNext()) {
			Statement stmt = it.next();
			Resource ind = model.createResource( stmt.asTriple().getSubject().getURI() );
			if ( ind.hasProperty( TYPE ) ) {
				individuals.add( ind );
				chldLinks.put( ind, new HashSet<>(  ) );
			}
		}

		for ( Resource ind : individuals ) {
			if ( ! ind.hasProperty( PARENT ) ) {
				if ( root == null ) {
					root = ind;
				} else {
					throw new IllegalStateException( "Multiple candidate roots found" );
				}
			} else {
				Resource parent = model.createResource( model.getProperty( ind, PARENT ).asTriple().getObject().getURI() );
				chldLinks.get( parent ).add( ind );
			}

		}


	}


	@Override
	public String getSourceType( Resource o ) {
		return model.getProperty( o, TYPE ).getString();
	}

	@Override
	protected Resource getRoot( Model o ) {
		return root;
	}

	@Override
	public Stream<Resource> getChildren( Resource o ) {
		if ( ! chldLinks.containsKey( o ) ) {
			return Stream.empty();
		}
		return chldLinks.get( o ).stream();
	}

	public Collection<Resource> getInboundLinks( Resource s ) {
		return Collections.emptyList();
	}

	public Collection<Resource> getOutboundLinks( Resource s ) {
		return Collections.emptyList();
	}

	@Override
	public Resource getNullSource() {
		return ANON;
	}

	@Override
	public QName toQName( String s ) {
		return new QName( Constants.NS_DIAGRAM_SIGNAVIO, "_" + s.substring( s.lastIndexOf( '/' ) + 1 ) );
	}


	public String extractOrGenerateId( final Object r ) {
		if ( r instanceof Resource ) {
			return  ((Resource) r).getLocalName();
		} else {
			return Utils.randomID();
		}

	}

	@Override
	public boolean isEntrySentry( String id ) {
		throw new UnsupportedOperationException( "TODO" );
	}

}
