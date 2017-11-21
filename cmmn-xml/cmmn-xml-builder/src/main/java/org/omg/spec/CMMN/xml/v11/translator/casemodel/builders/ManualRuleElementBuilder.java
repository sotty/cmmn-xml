package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TManualActivationRule;

import java.util.function.BiFunction;

public class ManualRuleElementBuilder<S> extends AbstractElementBuilder<S,TManualActivationRule> {

	@Override
	protected BiFunction<S, TManualActivationRule, TManualActivationRule> getDecoratorFunction() {
		return getDecorator()::decorateManualActivationRule;
	}

	@Override
	public S init( S s ) {
		element = getFactory().createTManualActivationRule();
		return s;
	}
}