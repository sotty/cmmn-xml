package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TCmmnElement;

import java.util.Optional;
import java.util.function.BiFunction;

public abstract class AbstractElementBuilder<S,T extends TCmmnElement> extends AbstractBuilder<S,T> {

	protected Optional<TCmmnElement> getElement( String id ) {
		return b.getElementByID( id );
	}

	@Override
	public S process( final S s ) {
		decorate( s, element, getDecoratorFunction() );
		return s;
	}

	@Override
	public S traverse( final S s ) {
		getChildren( s ).forEach( this::visit );
		return s;
	}

	protected abstract BiFunction<S,T,T> getDecoratorFunction();
}