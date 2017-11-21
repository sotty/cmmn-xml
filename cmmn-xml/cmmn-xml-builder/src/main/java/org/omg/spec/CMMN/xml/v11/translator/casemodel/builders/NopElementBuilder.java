package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TCmmnElement;

import java.util.Optional;

public class NopElementBuilder<S> extends AbstractBuilder<S,TCmmnElement> {

	@Override
	public S init( S s ) {
		return b.getNullSource();
	}

	@Override
	public Optional<TCmmnElement> ret( final S s ) {
		return Optional.empty();
	}
}
