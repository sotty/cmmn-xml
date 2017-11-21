package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.THumanTask;

import java.util.function.BiFunction;

public abstract class HumanTaskElementBuilder<S> extends AbstractTaskElementBuilder<S,THumanTask> {

	@Override
	protected BiFunction<S, THumanTask, THumanTask> getDecoratorFunction() {
		return getDecorator()::decorateHumanTask;
	}

}
