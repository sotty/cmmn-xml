package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.THumanTask;
import org.omg.spec.cmmn._20151109.model.TPlanningTable;
import org.omg.spec.cmmn._20151109.model.TStage;
import org.omg.spec.cmmn._20151109.model.TTask;

import javax.xml.bind.JAXBElement;

public class DiscrAssociationCaseBuilder<S> extends ConnectorCaseBuilder<S> {

	protected void connectElements( TCmmnElement source, TCmmnElement target ) {
		if ( ! ( source instanceof THumanTask ) ) {
			throw new IllegalStateException( "A discretionary Association must originate in a Human Task" );
		}
		if ( ! ( target instanceof TTask ) ) {
			throw new IllegalStateException( "A discretionary Association must target a Task" );
		}

		TStage parent = findParentStage();

		if ( parent.getPlanningTable() == null ) {
			throw new IllegalStateException( "A discretionary Association must reference a scoped discretionary item" );
		}

		JAXBElement tgt = parent.getPlanningTable().getTableItem().stream()
		                        .filter( (j) -> j.getValue() instanceof TDiscretionaryItem && ((TDiscretionaryItem) j.getValue()).getDefinitionRef().equals( target ) )
		                        .findAny()
		                        .orElseThrow( () -> new IllegalStateException( "A discretionary Association must reference a scoped discretionary item" ) );

		parent.getPlanningTable().getTableItem().remove( tgt );
		if ( isEmpty( parent.getPlanningTable() ) ) {
			parent.setPlanningTable( null );
		}

		THumanTask ht = (THumanTask) source;
		if ( ht.getPlanningTable() == null ) {
			ht.withPlanningTable( getFactory().createTPlanningTable().withId( Utils.randomID() ) );
		}
		ht.getPlanningTable().withTableItem( tgt );
	}

	private boolean isEmpty( TPlanningTable planningTable ) {
		return planningTable.getTableItem().isEmpty()
				&& planningTable.getApplicabilityRule().isEmpty()
				&& planningTable.getApplicabilityRuleRefs().isEmpty()
				&& planningTable.getAuthorizedRoleRefs().isEmpty()
				&& planningTable.getDocumentation().isEmpty();
	}

}