package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TDocumentation;

import java.util.function.BiFunction;

public class DocumentationComponentBuilder<S> extends AbstractComponentBuilder<S,TDocumentation> {

	@Override
	public S init( S s ) {
		element = getFactory().createTDocumentation()
		                      .withTextFormat( "text/plain" );
		return s;
	}

	@Override
	protected BiFunction<S, TDocumentation, TDocumentation> getDecoratorFunction() {
		return getDecorator()::decorateDocumentation;
	}

}
