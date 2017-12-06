package org.omg.spec.CMMN.xml.v11.translator.casemodel;


import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.cmmn._20151109.model.TCase;
import org.omg.spec.cmmn._20151109.model.TCaseFileItem;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemDefinition;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;
import org.omg.spec.cmmn._20151109.model.TCaseTask;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDecisionTask;
import org.omg.spec.cmmn._20151109.model.TDefinitions;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.TDocumentation;
import org.omg.spec.cmmn._20151109.model.TEventListener;
import org.omg.spec.cmmn._20151109.model.TExtensionElements;
import org.omg.spec.cmmn._20151109.model.THumanTask;
import org.omg.spec.cmmn._20151109.model.TIfPart;
import org.omg.spec.cmmn._20151109.model.TManualActivationRule;
import org.omg.spec.cmmn._20151109.model.TMilestone;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TPlanItem;
import org.omg.spec.cmmn._20151109.model.TPlanItemControl;
import org.omg.spec.cmmn._20151109.model.TPlanItemDefinition;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;
import org.omg.spec.cmmn._20151109.model.TPlanningTable;
import org.omg.spec.cmmn._20151109.model.TProcessTask;
import org.omg.spec.cmmn._20151109.model.TRepetitionRule;
import org.omg.spec.cmmn._20151109.model.TRequiredRule;
import org.omg.spec.cmmn._20151109.model.TSentry;
import org.omg.spec.cmmn._20151109.model.TStage;
import org.omg.spec.cmmn._20151109.model.TTask;
import org.omg.spec.cmmn._20151109.model.TTimerEventListener;
import org.omg.spec.cmmn._20151109.model.TUserEventListener;

import java.util.Optional;

public interface CMMNCasePropertyDecorator<S> {

	String valueOf( final S o, final CMMNProperties prop );

	Optional<String> getProperty( final S o, final CMMNProperties prop );


	TCmmnElement decorateCmmnElement( final S o, final TCmmnElement tCmmnElement );

	TPlanItemDefinition decoratePlanItemDefinition( final S o, final TPlanItemDefinition tPlanItemDefinition );

	TCase decorateCase( final S o, final TCase tCase );

	TTask decorateTask( final S o, final TTask tTask );

	TCaseTask decorateCaseTask( final S o, final TCaseTask tCaseTask );

	TDecisionTask decorateDecisionTask( final S o, final TDecisionTask tDecisionTask );

	THumanTask decorateHumanTask( final S o, final THumanTask tHumanTask );

	TProcessTask decorateProcessTask( final S o, final TProcessTask tProcessTask );

	TMilestone decorateMilestone( final S o, final TMilestone tMilestone );

	TStage decorateStage( final S o, final TStage tStage );

	TPlanFragment decoratePlanFragment( final S o, final TPlanFragment tPlanFragment );

	TSentry decorateSentry( final S o, final TSentry tSentry );

	TIfPart decorateIf( S s, TIfPart tIfPart );

	TPlanItemOnPart decorateOn( S s, TPlanItemOnPart tOnPart );

	TCaseFileItemOnPart decorateOnCaseFile( S s, TCaseFileItemOnPart tCaseFileItemOnPart );

	TEventListener decorateEventListener( S s, TEventListener tEventListener );

	TUserEventListener decorateUserEventListener( S s, TUserEventListener tEventListener );

	TTimerEventListener decorateTimerEventListener( S s, TTimerEventListener tEventListener );

	TPlanItem decoratePlanItem( S s, TPlanItem tPlanItem );
	
	TManualActivationRule decorateManualActivationRule( S s, TManualActivationRule tManualActivationRule );
	
	TRepetitionRule decorateRepetitionRule( S s, TRepetitionRule tRepetitionRule );

	TRequiredRule decorateRequiredRule( S s, TRequiredRule tRequiredRule );

	TPlanItemControl decoratePlanItemControl( S s, TPlanItemControl tPlanItemControl );

	TPlanningTable decoratePlanningTable( S s, TPlanningTable tPlanningTable );

	TDiscretionaryItem decorateDiscretionaryItem( S s, TDiscretionaryItem tDiscretionaryItem );

	TCaseFileItem decorateCaseFileItem( S s, TCaseFileItem tCaseFileItem );

	TCaseFileItemDefinition decorateCaseFileItemDefinition( S s, TCaseFileItemDefinition tCaseFileItemDefinition );


	TDocumentation decorateDocumentation( final S o, final TDocumentation tDocumentation );
	
	TDefinitions decorateDefinitions( final S o, final TDefinitions tDefinitions );

	TExtensionElements decorateExtensions( final S o, final TExtensionElements tDefinitions );

}
