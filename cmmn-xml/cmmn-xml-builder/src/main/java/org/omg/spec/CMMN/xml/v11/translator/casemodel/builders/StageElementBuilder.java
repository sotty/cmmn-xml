package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TStage;

import java.util.function.BiFunction;

public class StageElementBuilder<S> extends PlanItemDefinitionElementBuilder<S,TStage> {

	private boolean discretionary;

	@Override
	public S init( final S s ) {
		element = getFactory().createTStage();
		discretionary = isDiscretionary( s );
		return s;
	}

	@Override
	protected BiFunction<S, TStage, TStage> getDecoratorFunction() {
		return getDecorator()::decorateStage;
	}

	@Override
	protected TStage connectParent() {
		connectParent( element, discretionary, getBuildStack().getFirst() );
		return super.connectParent();
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
