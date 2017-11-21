package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TCase;

import java.util.Optional;
import java.util.function.BiFunction;

public class CaseElementBuilder<S> extends AbstractLinkingElementBuilder<S,TCase> {

	@Override
	public S init( S s ) {
		element = getFactory().createTCase();
		return s;
	}

	@Override
	protected BiFunction<S, TCase, TCase> getDecoratorFunction() {
		return getDecorator()::decorateCase;
	}

	@Override
	public Optional<TCase> ret( S s ) {
		return element.getCasePlanModel() != null ? Optional.of( element ) : Optional.empty();
	}

	@Override
	public S pre( final S s ) {
		getBuildStack().push( element );
		return super.pre(s);
	}

	@Override
	public S post( final S s ) {
		getBuildStack().pop();
		connectParent();
		return super.post( s );
	}

}
