package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TPlanFragment;

import java.util.function.BiFunction;

public class PlanFragmentElementBuilder<S> extends PlanItemDefinitionElementBuilder<S,TPlanFragment> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTPlanFragment();
		return s;
	}

	@Override
	protected BiFunction<S, TPlanFragment, TPlanFragment> getDecoratorFunction() {
		return getDecorator()::decoratePlanFragment;
	}


	@Override
	public S pre( final S s ) {
		getBuildStack().push( element );
		return super.pre(s);
	}

	@Override
	public S post( final S s ) {
		assert element == getBuildStack().pop();
		// TODO Check the Spec to confirm that Plan Fragments can not be nested
		connectParent( element, true, getBuildStack().peek() );
		// plan fragments are necessarily discretionary
		addDiscretionary( s );
		return super.post( s );
	}


}
