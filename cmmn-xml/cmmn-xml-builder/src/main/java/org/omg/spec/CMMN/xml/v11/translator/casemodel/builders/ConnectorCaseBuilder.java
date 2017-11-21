package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.translator.SourceBuilder;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;

import java.util.Collection;
import java.util.Optional;

public class ConnectorCaseBuilder<S> extends AbstractBuilder<S,TCmmnElement> {

	private String src;
	private String tgt;

	@Override
	public S init( S s ) {
		Collection<S> in = b.getInboundLinks( s );
		Collection<S> out = b.getOutboundLinks( s );

		assert in.size() == 1;
		assert out.size() == 1;

		src = getId( in.iterator().next() );
		tgt = getId( out.iterator().next() );

		return s;
	}

	@Override
	public Optional<TCmmnElement> ret( S s ) {
		return Optional.empty();
	}

	@Override

	public S link( S s ) {
		connectWhenPresent( src, tgt );
		return super.link( s );
	}

	private void connectWhenPresent( String src, String tgt ) {
		if ( b.hasElement( src ) && b.hasElement( tgt ) ) {
			TCmmnElement source = b.getElementByID( src ).get();
			TCmmnElement target = b.getElementByID( tgt ).get();

			connectElements( source, target );
		} else if ( b.hasElement( src ) ) {
			element = b.getElementByID( src ).get();
			b.registerElementCallback( tgt, this::onTargetAdded);
		} else if ( b.hasElement( tgt ) ) {
			element = b.getElementByID( tgt ).get();
			b.registerElementCallback( src, this::onSourceAdded );
		} else {
			b.registerElementCallback( src, this::onSourceAdded );
			b.registerElementCallback( tgt, this::onTargetAdded );
		}

	}

	protected void connectElements( TCmmnElement source, TCmmnElement target ) {
		SourceBuilder<S, ? extends TCmmnElement> srcBuilder = b.getElementBuilder( CMMNElements.forClass( source.getClass() ) ).get();
		SourceBuilder<S, ? extends TCmmnElement> tgtBuilder = b.getElementBuilder( CMMNElements.forClass( target.getClass() ) ).get();

		if ( srcBuilder instanceof AbstractLinkingElementBuilder ) {
			AbstractLinkingElementBuilder<S,TCmmnElement> alk = ( AbstractLinkingElementBuilder<S, TCmmnElement> ) srcBuilder;
			alk.linkOutbound( source, target );
		}
		if ( tgtBuilder instanceof AbstractLinkingElementBuilder ) {
			AbstractLinkingElementBuilder<S,TCmmnElement> alk = ( AbstractLinkingElementBuilder<S,TCmmnElement> ) tgtBuilder;
			alk.linkInbound( target, source );
		}
	}

	protected void onSourceAdded( TCmmnElement source ) {
		if ( element != null ) {
			connectElements( source, element );
		} else {
			element = source;
		}
	}

	protected void onTargetAdded( TCmmnElement target ) {
		if ( element != null ) {
			connectElements( element, target );
		} else {
			element = target;
		}
	}


}
