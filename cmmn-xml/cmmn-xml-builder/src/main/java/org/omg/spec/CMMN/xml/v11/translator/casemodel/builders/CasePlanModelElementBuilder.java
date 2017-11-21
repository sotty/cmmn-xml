package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.cmmn._20151109.model.TCase;

import java.util.function.BiFunction;

public class CasePlanModelElementBuilder<S> extends AbstractLinkingElementBuilder<S,TCase> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTCase()
					.withCasePlanModel( getFactory().createTStage().withId( Utils.randomID() ) );
		return s;
	}

	@Override
	protected TCase decorate( S o, TCase element, BiFunction<S, TCase, TCase> method ) {
		getDecorator().decorateStage( o, element.getCasePlanModel() );
		return element;
	}

	@Override
	protected BiFunction<S, TCase, TCase> getDecoratorFunction() {
		return getDecorator()::decorateCase;
	}

	@Override
	public S pre( final S s ) {
		getBuildStack().push( element );
		return super.pre(s);
	}

	@Override
	public S post( final S s ) {
		getRoot().withCase( element );
		getBuildStack().pop();
		connectParent();
		return super.post( s );
	}


}
