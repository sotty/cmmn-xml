package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.CaseFileItemTransition;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;

import java.util.function.BiFunction;

public class OnFilePartElementBuilder<S> extends AbstractLinkingElementBuilder<S,TCaseFileItemOnPart> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTCaseFileItemOnPart()
		                      .withStandardEvent( CaseFileItemTransition.UPDATE );
		return s;
	}

	@Override
	protected BiFunction<S, TCaseFileItemOnPart, TCaseFileItemOnPart> getDecoratorFunction() {
		return getDecorator()::decorateOnCaseFile;
	}
}

