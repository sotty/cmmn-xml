package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TDefinitions;

import java.util.function.BiFunction;

public class DefinitionsElementBuilder<S> extends AbstractComponentBuilder<S,TDefinitions> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTDefinitions()
		                      .withTargetNamespace( getId( s ) );
		return s;
	}

	@Override
	protected BiFunction<S, TDefinitions, TDefinitions> getDecoratorFunction() {
		return getDecorator()::decorateDefinitions;
	}
}