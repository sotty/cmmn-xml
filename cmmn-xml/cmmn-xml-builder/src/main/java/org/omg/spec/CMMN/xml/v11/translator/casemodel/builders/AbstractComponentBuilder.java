package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import java.util.function.BiFunction;

public abstract class AbstractComponentBuilder<S,T> extends AbstractBuilder<S,T> {

	@Override
	public S process( final S s ) {
		decorate( s, element, getDecoratorFunction() );
		return s;
	}

	protected abstract BiFunction<S,T,T> getDecoratorFunction();
}
