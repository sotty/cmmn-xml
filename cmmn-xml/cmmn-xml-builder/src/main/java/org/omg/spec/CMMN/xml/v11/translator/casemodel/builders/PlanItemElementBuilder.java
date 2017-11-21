package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TPlanItem;

import java.util.function.BiFunction;

public class PlanItemElementBuilder<S> extends AbstractLinkingElementBuilder<S,TPlanItem> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTPlanItem();
		return s;
	}

	@Override
	protected BiFunction<S, TPlanItem, TPlanItem> getDecoratorFunction() {
		return getDecorator()::decoratePlanItem;
	}


}
