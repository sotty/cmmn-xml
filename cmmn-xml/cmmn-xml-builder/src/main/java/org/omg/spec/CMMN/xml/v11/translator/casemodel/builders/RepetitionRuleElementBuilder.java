package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TRepetitionRule;

import java.util.function.BiFunction;

public class RepetitionRuleElementBuilder<S> extends AbstractElementBuilder<S,TRepetitionRule> {

	@Override
	protected BiFunction<S, TRepetitionRule, TRepetitionRule> getDecoratorFunction() {
		return getDecorator()::decorateRepetitionRule;
	}

	@Override
	public S init( S s ) {
		element = getFactory().createTRepetitionRule();
		return s;
	}
}