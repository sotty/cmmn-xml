package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TDecisionTask;

import java.util.function.BiFunction;

public class DecisionTaskElementBuilder<S> extends AbstractTaskElementBuilder<S,TDecisionTask> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTDecisionTask()
		                      .withIsBlocking( true );
		return s;
	}


	@Override
	protected BiFunction<S, TDecisionTask, TDecisionTask> getDecoratorFunction() {
		return getDecorator()::decorateDecisionTask;
	}

	@Override
	public S link( final S s ) {
		if ( element.getDecisionRef() != null ) {
			getRoot().withDecision(
					getFactory().createTDecision()
					            .withExternalRef( element.getDecisionRef() ) );
		}

		return super.link( s );
	}

}
