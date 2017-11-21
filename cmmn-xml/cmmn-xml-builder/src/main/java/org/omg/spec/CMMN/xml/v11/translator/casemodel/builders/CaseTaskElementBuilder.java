package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TCaseTask;

import java.util.function.BiFunction;

public class CaseTaskElementBuilder<S> extends AbstractTaskElementBuilder<S,TCaseTask> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTCaseTask()
		                      .withIsBlocking( true );
		return s;
	}

	@Override
	protected BiFunction<S, TCaseTask, TCaseTask> getDecoratorFunction() {
		return getDecorator()::decorateCaseTask;
	}

}
