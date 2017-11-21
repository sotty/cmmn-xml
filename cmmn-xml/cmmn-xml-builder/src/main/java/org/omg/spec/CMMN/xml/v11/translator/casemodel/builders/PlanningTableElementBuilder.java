package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TPlanningTable;
import org.omg.spec.cmmn._20151109.model.TStage;

import java.util.function.BiFunction;

public class PlanningTableElementBuilder<S> extends AbstractLinkingElementBuilder<S,TPlanningTable> {

	@Override
	public S init( final S s ) {
		element = getOrBuildPlanningTable();
		return s;
	}

	@Override
	protected BiFunction<S, TPlanningTable, TPlanningTable> getDecoratorFunction() {
		return getDecorator()::decoratePlanningTable;
	}

	private TPlanningTable getOrBuildPlanningTable() {
		TStage parentStage = findParentStage();

		if ( parentStage.getPlanningTable() == null ) {
			parentStage.withPlanningTable( getFactory().createTPlanningTable() );
		}
		return parentStage.getPlanningTable();
	}

}
