package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TTask;

import java.util.function.BiFunction;

public class GenericTaskElementBuilder<S> extends AbstractTaskElementBuilder<S,TTask> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTTask()
		                      .withIsBlocking( true );
		return s;
	}

	@Override
	protected BiFunction<S, TTask, TTask> getDecoratorFunction() {
		return getDecorator()::decorateTask;
	}
}
