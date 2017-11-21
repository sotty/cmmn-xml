package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TCaseFileItemDefinition;

import java.util.function.BiFunction;

public class CaseFileItemDefinitionElementBuilder<S> extends AbstractLinkingElementBuilder<S,TCaseFileItemDefinition> {

	@Override
	public S init( S s ) {
		element = getFactory().createTCaseFileItemDefinition();
		return s;
	}

	@Override
	protected BiFunction<S, TCaseFileItemDefinition, TCaseFileItemDefinition> getDecoratorFunction() {
		return getDecorator()::decorateCaseFileItemDefinition;
	}

	@Override
	public S link( S s ) {
		connectCaseFileItemDefinition();
		return super.link( s );
	}

	private void connectCaseFileItemDefinition() {
		getRoot().getCaseFileItemDefinition().add( element );
	}
}
