package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TMilestone;

import java.util.function.BiFunction;

public class MilestoneElementBuilder<S> extends PlanItemDefinitionElementBuilder<S,TMilestone> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTMilestone();
		return s;
	}

	@Override
	protected BiFunction<S, TMilestone, TMilestone> getDecoratorFunction() {
		return getDecorator()::decorateMilestone;
	}

	@Override
	public S link( final S s ) {
		connectParent( element, isDiscretionary( s ), getBuildStack().peek() );
		return super.link( s );
	}


}
