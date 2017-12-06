package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TExtensionElements;

import java.util.function.BiFunction;

public class ExtensionsComponentBuilder<S> extends AbstractComponentBuilder<S,TExtensionElements> {

	@Override
	public S init( S s ) {
		element = getFactory().createTExtensionElements();
		return s;
	}

	@Override
	protected BiFunction<S, TExtensionElements, TExtensionElements> getDecoratorFunction() {
		return getDecorator()::decorateExtensions;
	}

}
