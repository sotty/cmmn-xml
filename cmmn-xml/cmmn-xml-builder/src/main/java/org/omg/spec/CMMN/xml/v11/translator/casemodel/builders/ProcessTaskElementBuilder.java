package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TProcessTask;

import java.util.function.BiFunction;

public class ProcessTaskElementBuilder<S> extends AbstractTaskElementBuilder<S,TProcessTask> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTProcessTask()
		                      .withIsBlocking( true );
		return s;
	}

	@Override
	protected BiFunction<S, TProcessTask, TProcessTask> getDecoratorFunction() {
		return getDecorator()::decorateProcessTask;
	}

	@Override
	public S link( final S s ) {
		if ( element.getProcessRef() != null ) {
			getRoot().withProcess(
					getFactory().createTProcess()
					            .withExternalRef( element.getProcessRef() ) );
		}

		return super.link( s );
	}


}
