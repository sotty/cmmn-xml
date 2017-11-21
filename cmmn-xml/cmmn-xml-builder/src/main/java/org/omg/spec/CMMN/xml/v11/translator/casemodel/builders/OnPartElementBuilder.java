package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.PlanItemTransition;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;

import java.util.function.BiFunction;

public class OnPartElementBuilder<S> extends AbstractLinkingElementBuilder<S,TPlanItemOnPart> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTPlanItemOnPart()
		                      .withStandardEvent( PlanItemTransition.OCCUR );
		return s;
	}

	@Override
	protected BiFunction<S, TPlanItemOnPart, TPlanItemOnPart> getDecoratorFunction() {
		return getDecorator()::decorateOn;
	}
}

