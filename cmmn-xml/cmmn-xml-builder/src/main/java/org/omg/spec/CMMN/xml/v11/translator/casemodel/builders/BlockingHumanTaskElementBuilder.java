package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

public class BlockingHumanTaskElementBuilder<S> extends HumanTaskElementBuilder<S> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTHumanTask()
		                      .withIsBlocking( true );
		return s;
	}


}
