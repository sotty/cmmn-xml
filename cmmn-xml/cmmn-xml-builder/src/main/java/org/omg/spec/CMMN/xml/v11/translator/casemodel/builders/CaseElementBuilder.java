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
	public S pre( final S s ) {
		getBuildStack().push( element );
		return super.pre(s);
	}

	@Override
	public Optional<TCase> ret( S s ) {
		if ( element.getCasePlanModel() != null ) {
			return super.ret( s );
		} else {
			// this builder is constructing the fictious
			// Case element that results from the mis-labelling of
			// the top level Shape element.
			// some metadata may need to be moved
			b.getRoot().withExtensionElements( element.getExtensionElements() );
			b.getRoot().getCase().iterator().next().withId( element.getId() );
			b.getRoot().getCase().iterator().next().withDocumentation( element.getDocumentation() );
			return Optional.empty();
		}
	}

	@Override
	public S post( final S s ) {
		assert element == getBuildStack().pop();
		connectParent();
		return super.post( s );
	}

}
