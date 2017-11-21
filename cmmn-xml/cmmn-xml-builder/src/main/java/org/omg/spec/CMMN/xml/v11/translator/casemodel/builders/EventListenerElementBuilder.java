package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TEventListener;

import java.util.function.BiFunction;

public class EventListenerElementBuilder<S> extends AbstractEventListenerElementBuilder<S,TEventListener> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTEventListener();
		return s;
	}

	@Override
	protected BiFunction<S, TEventListener, TEventListener> getDecoratorFunction() {
		return getDecorator()::decorateEventListener;
	}

}
