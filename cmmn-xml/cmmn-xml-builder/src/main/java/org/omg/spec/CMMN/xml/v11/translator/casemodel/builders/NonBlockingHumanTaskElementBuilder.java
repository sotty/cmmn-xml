package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

public class NonBlockingHumanTaskElementBuilder<S> extends HumanTaskElementBuilder<S> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTHumanTask()
		                      .withIsBlocking( false );
		return s;
	}

}
