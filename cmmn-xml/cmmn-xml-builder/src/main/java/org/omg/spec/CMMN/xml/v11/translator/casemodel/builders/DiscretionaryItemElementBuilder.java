package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;

import java.util.function.BiFunction;

public class DiscretionaryItemElementBuilder<S> extends AbstractElementBuilder<S,TDiscretionaryItem> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTDiscretionaryItem();
		return s;
	}

	@Override
	protected BiFunction<S, TDiscretionaryItem, TDiscretionaryItem> getDecoratorFunction() {
		return getDecorator()::decorateDiscretionaryItem;
	}
}
