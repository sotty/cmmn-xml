package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TUserEventListener;

import java.util.function.BiFunction;

public class UserEventListenerElementBuilder<S> extends AbstractEventListenerElementBuilder<S,TUserEventListener> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTUserEventListener();
		return s;
	}

	@Override
	protected BiFunction<S, TUserEventListener, TUserEventListener> getDecoratorFunction() {
		return getDecorator()::decorateUserEventListener;
	}

}
