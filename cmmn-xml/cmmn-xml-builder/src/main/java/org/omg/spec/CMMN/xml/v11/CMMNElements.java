package org.omg.spec.CMMN.xml.v11;


import org.omg.spec.cmmn._20151109.model.TCase;
import org.omg.spec.cmmn._20151109.model.TCaseFileItem;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemDefinition;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;
import org.omg.spec.cmmn._20151109.model.TCaseTask;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDecisionTask;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.TEntryCriterion;
import org.omg.spec.cmmn._20151109.model.TEventListener;
import org.omg.spec.cmmn._20151109.model.TExitCriterion;
import org.omg.spec.cmmn._20151109.model.THumanTask;
import org.omg.spec.cmmn._20151109.model.TIfPart;
import org.omg.spec.cmmn._20151109.model.TManualActivationRule;
import org.omg.spec.cmmn._20151109.model.TMilestone;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TPlanItem;
import org.omg.spec.cmmn._20151109.model.TPlanItemControl;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;
import org.omg.spec.cmmn._20151109.model.TPlanningTable;
import org.omg.spec.cmmn._20151109.model.TProcessTask;
import org.omg.spec.cmmn._20151109.model.TRepetitionRule;
import org.omg.spec.cmmn._20151109.model.TRequiredRule;
import org.omg.spec.cmmn._20151109.model.TSentry;
import org.omg.spec.cmmn._20151109.model.TStage;
import org.omg.spec.cmmn._20151109.model.TTask;
import org.omg.spec.cmmn._20151109.model.TTextAnnotation;
import org.omg.spec.cmmn._20151109.model.TTimerEventListener;
import org.omg.spec.cmmn._20151109.model.TUserEventListener;

import static java.util.Arrays.stream;

public enum CMMNElements {

	CASE_PLAN( "CasePlanModel", TCase.class ),
	CASE( "Case", TCase.class ),
	PLAN_ITEM( "PlanItem", TPlanItem.class ),
	PLAN_ITEM_CONTROL( "PlanItemControl", TPlanItemControl.class ),
	PLANNING_TABLE( "PlanningTable", TPlanningTable.class ),
	DISCRETIONARY_ITEM( "DiscretionaryItem", TDiscretionaryItem.class ),

	STAGE( "Stage", TStage.class ),
	STAGE_EX( "StageExpanded", TStage.class ),
	STAGE_COLL( "StageCollapsed", TStage.class ),
	PLAN_FRAGMENT_EXP( "PlanFragmentExpanded", TPlanFragment.class ),
	PLAN_FRAGMENT_COLL( "PlanFragmentCollapsed", TPlanFragment.class ),

	MANUAL_RULE( "RequiredRule", TManualActivationRule.class ),
	REPETITION_RULE( "RepetitionRule", TRepetitionRule.class ),
	REQUIRED_RULE( "RequiredRule", TRequiredRule.class ),

	TASK( "Task", TTask.class ),
	CASE_TASK( "CaseTask", TCaseTask.class ),
	DECISION_TASK( "DecisionTask", TDecisionTask.class ),
	PROCESS_TASK( "ProcessTask", TProcessTask.class ),
	B_HUMAN_TASK( "BHumanTask", THumanTask.class ),
	NB_HUMAN_TASK( "NBHumanTask", THumanTask.class ),

	SENTRY( "Sentry", TSentry.class ),
	IN_SENTRY( "EntryCriterion", TEntryCriterion.class ),
	EXIT_SENTRY( "ExitCriterion", TExitCriterion.class ),
	IF_PART( "IfPart", TIfPart.class ),
	ON_PART( "OnPart", TPlanItemOnPart.class ),
	ON_FILE_PART( "OnCaseFileItemPart", TCaseFileItemOnPart.class ),

	EVENT_LISTENER( "EventListener", TEventListener.class ),
	USER_EVENT_LISTENER( "UserEventListener", TUserEventListener.class ),
	TIMER_EVENT_LISTENER( "TimerEventListener", TTimerEventListener.class ),

	MILESTONE( "Milestone", TMilestone.class ),

	CASE_FILE_ITEM( "CaseFileItem", TCaseFileItem.class ),
	CASE_FILE_ITEM_DEF( "CaseFileItemDefinition", TCaseFileItemDefinition.class ),

	CONNECTOR( "Connector", TCmmnElement.class ),
	DISCRETIONARY_ASSOCIATION( "DiscretionaryAssociation", TCmmnElement.class ),

	ENTRY_CRITERION( "EntryCriterion", TEntryCriterion.class ),

	TEXT( "TextAnnotation", TTextAnnotation.class )
	;

	private String name;
	private Class<? extends TCmmnElement> klass;

	CMMNElements( String name, Class<? extends TCmmnElement> klass ) {
		this.name = name.toLowerCase();
		this.klass = klass;
	}

	public String getName() {
		return name;
	}

	public Class<? extends TCmmnElement> getModelClass() {
		return klass;
	}


	public static CMMNElements parse( final String s ) {
		return stream( CMMNElements.values() )
		             .filter( (p) -> p.getName().equalsIgnoreCase( s ) )
		             .findFirst()
		             .orElseThrow( () -> new UnsupportedOperationException( "Element Type not recognized: " + s ) );
	}

	public static CMMNElements forClass( final Class<? extends TCmmnElement> klass ) {
		return stream( CMMNElements.values() )
		             .filter( (p) -> p.getModelClass().equals( klass ) )
		             .findFirst()
		             .orElseThrow( () -> new UnsupportedOperationException( "Element Type not recognized: " + klass.getName() ) );
	}



}
