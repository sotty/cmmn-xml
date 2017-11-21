package org.omg.spec.CMMN.xml.v11.translator;

import org.omg.spec.cmmn._20151109.model.TDefinitions;

import java.util.function.Function;


public interface CMMNTranslator<S> extends Function<S,TDefinitions> {

	/**
	 * The core translation method, that takes a Source Object as input, and generates a root CMMN TDefinitions object
	 * @param source    The input
	 * @return          A {@link TDefinitions} object
	 */
	@Override
	TDefinitions apply( S source );
}
