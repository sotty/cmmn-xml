package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TIfPart;

import java.util.function.BiFunction;

public class IfPartElementBuilder<S> extends AbstractLinkingElementBuilder<S,TIfPart> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTIfPart();
		return s;
	}

	@Override
	protected BiFunction<S, TIfPart, TIfPart> getDecoratorFunction() {
		return getDecorator()::decorateIf;
	}
}

