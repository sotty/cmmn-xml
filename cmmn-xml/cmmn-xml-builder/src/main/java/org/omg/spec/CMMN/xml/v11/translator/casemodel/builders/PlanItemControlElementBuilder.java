package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TPlanItemControl;

import java.util.function.BiFunction;

public class PlanItemControlElementBuilder<S> extends AbstractElementBuilder<S,TPlanItemControl> {

	@Override
	protected BiFunction<S, TPlanItemControl, TPlanItemControl> getDecoratorFunction() {
		return getDecorator()::decoratePlanItemControl;
	}

	@Override
	public S init( S s ) {
		element = getFactory().createTPlanItemControl();
		return s;
	}
}