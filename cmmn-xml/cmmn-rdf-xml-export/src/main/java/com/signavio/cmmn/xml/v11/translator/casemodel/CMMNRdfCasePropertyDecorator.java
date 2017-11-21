package com.signavio.cmmn.xml.v11.translator.casemodel;


import com.signavio.cmmn.xml.v11.Constants;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Selector;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCasePropertyDecoratorImpl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class CMMNRdfCasePropertyDecorator extends CMMNCasePropertyDecoratorImpl<Model,Resource> {


	CMMNRdfCasePropertyDecorator( final CMMNCaseBuilder<Model,Resource> factory ) {
		super( factory );
	}

	public Stream<CMMNProperties> propertiesOf( final Resource o, final CMMNProperties.Category cat ) {
		if ( o.getModel() == null ) {
			return Stream.empty();
		}
		StmtIterator iter = o.getModel().listStatements( new SubjectSelector( o ) );
		Set<CMMNProperties> props = new HashSet<>();
		while ( iter.hasNext() ) {
			try {
				CMMNProperties p = CMMNProperties.parse( iter.next().asTriple().getPredicate().getLocalName() );
				props.add( p );
			} catch ( Exception e ) {
			}
		}
		return props.stream();
	}

	public Optional<String> getProperty( final Resource o, final CMMNProperties prop ) {
		return Optional.ofNullable(
				o.getModel().getProperty( o, o.getModel().createProperty( Constants.ORYX, prop.getName() ) ).getString() );
	}

	public String valueOf( final Resource o, final CMMNProperties prop ) {
		return getProperty( o, prop ).get();
	}

	private class SubjectSelector implements Selector {
		private Resource o;
		public SubjectSelector( Resource o ) {
			this.o = o;
		}
		public boolean isSimple() {
			return false;
		}

		@Override
		public Resource getSubject() {
			return o;
		}

		@Override
		public Property getPredicate() {
			return null;
		}

		@Override
		public RDFNode getObject() {
			return null;
		}

		@Override
		public boolean test( Statement statement ) {
			return statement.asTriple().getSubject().getURI().equals( o.getURI() );
		}
	}
}
