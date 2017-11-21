package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TRequiredRule;

import java.util.function.BiFunction;

public class RequiredRuleElementBuilder<S> extends AbstractElementBuilder<S,TRequiredRule> {

	@Override
	protected BiFunction<S, TRequiredRule, TRequiredRule> getDecoratorFunction() {
		return getDecorator()::decorateRequiredRule;
	}

	@Override
	public S init( S s ) {
		element = getFactory().createTRequiredRule();
		return s;
	}
}