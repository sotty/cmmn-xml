package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TTimerEventListener;

import java.util.function.BiFunction;

public class TimerEventListenerElementBuilder<S> extends AbstractEventListenerElementBuilder<S,TTimerEventListener> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTTimerEventListener();
		return s;
	}

	@Override
	protected BiFunction<S, TTimerEventListener, TTimerEventListener> getDecoratorFunction() {
		return getDecorator()::decorateTimerEventListener;
	}
}
