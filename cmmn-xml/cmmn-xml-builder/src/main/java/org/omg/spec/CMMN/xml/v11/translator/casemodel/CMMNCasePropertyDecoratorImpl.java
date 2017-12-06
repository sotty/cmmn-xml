package org.omg.spec.CMMN.xml.v11.translator.casemodel;


import com.signavio.schema.cmmn._1.DiagramMetaData;
import org.omg.spec.CMMN.xml.v11.CMMNComponents;
import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.CMMN.xml.v11.OMGConstants;
import org.omg.spec.CMMN.xml.v11.Utils;
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

import java.util.Map;
import java.util.stream.Stream;

public abstract class CMMNCasePropertyDecoratorImpl<D,S> implements CMMNCasePropertyDecorator<S> {


	private CMMNCaseBuilder<D,S> f;

	protected CMMNCasePropertyDecoratorImpl( CMMNCaseBuilder<D,S> factory ) {
		this.f = factory;
	}

	protected abstract Stream<CMMNProperties> propertiesOf( final S o, final CMMNProperties.Category cat );

	protected abstract Map<String,String> annotationsOf( final S o );

	protected abstract boolean hasMetadata( final S o );

	public abstract String valueOf( final S o, final CMMNProperties prop );

	public TCmmnElement decorateCmmnElement( final S o, final TCmmnElement tCmmnElement ) {
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case ID: tCmmnElement.withId( valueOf( o, prop ) );
					break;
				case DESCRIPTION:
				case DOCUMENTATION: f.buildComponent( CMMNComponents.DOCUMENTATION,
				                                      o,
				                                      TDocumentation.class ).ifPresent( tCmmnElement::withDocumentation );
					break;
			}
		} );

		if ( hasMetadata( o ) ) {
			f.buildComponent( CMMNComponents.EXTENSION,
			                  o,
			                  TExtensionElements.class ).ifPresent( tCmmnElement::withExtensionElements );
		}

		if ( tCmmnElement.getId() == null || tCmmnElement.getId().isEmpty() || ! tCmmnElement.getId().equalsIgnoreCase( f.extractOrGenerateId( o ) ) ) {
			tCmmnElement.setId( f.extractOrGenerateId( o ) );
		}
		return tCmmnElement;
	}

	public TPlanItemDefinition decoratePlanItemDefinition( final S o, final TPlanItemDefinition tPlanItemDefinition ) {
		decorateCmmnElement( o, tPlanItemDefinition );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case NAME: tPlanItemDefinition.withName( valueOf( o, prop ) );
					break;
				case REQUIRED:
					if ( Boolean.valueOf( valueOf( o, prop ) ) ) {
						getDefaultControl( tPlanItemDefinition ).withRequiredRule(
								f.buildElement( CMMNElements.REQUIRED_RULE, TRequiredRule.class )
								 .orElseThrow( UnsupportedOperationException::new ) );
					}
					break;
				case REPETITION:
					if ( Boolean.valueOf( valueOf( o, prop ) ) ) {
						getDefaultControl( tPlanItemDefinition ).withRepetitionRule(
								f.buildElement( CMMNElements.REPETITION_RULE, TRepetitionRule.class )
								 .orElseThrow( UnsupportedOperationException::new ));
					}
					break;
				case MANUAL_ACTIVATION:
					if ( Boolean.valueOf( valueOf( o, prop ) ) ) {
						getDefaultControl( tPlanItemDefinition ).withManualActivationRule(
								f.buildElement( CMMNElements.MANUAL_RULE, TManualActivationRule.class )
								 .orElseThrow( UnsupportedOperationException::new ));
					}
					break;
			}
		} );
		return tPlanItemDefinition;
	}

	private TPlanItemControl getDefaultControl( TPlanItemDefinition tPlanItemDefinition ) {
		if ( tPlanItemDefinition.getDefaultControl() == null ) {
			tPlanItemDefinition.withDefaultControl(
					f.buildElement( CMMNElements.PLAN_ITEM_CONTROL, TPlanItemControl.class )
					 .orElseThrow( UnsupportedOperationException::new ) );
		}
		return tPlanItemDefinition.getDefaultControl();
	}

	public TCase decorateCase( final S o, final TCase tCase ) {
		decorateCmmnElement( o, tCase );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case NAME: tCase.withName( valueOf( o, prop ) );
					break;
			}
		} );
		return tCase;
	}

	public TTask decorateTask( final S o, final TTask tTask ) {
		decoratePlanItemDefinition( o, tTask );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case IS_BLOCKING: tTask.withIsBlocking( Boolean.valueOf( valueOf( o, prop ) ) );
			}
		} );
		return tTask;
	}

	public TProcessTask decorateProcessTask( final S o, final TProcessTask tProcessTask ) {
		decorateTask( o, tProcessTask );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case ENTRY:
					tProcessTask.withProcessRef( f.toQName( valueOf( o, prop ), OMGConstants.NS_OMG_BPMN_v20 ) );
					break;
			}

		} );
		return tProcessTask;
	}


	public TCaseTask decorateCaseTask( final S o, final TCaseTask tCaseTask ) {
		decorateTask( o, tCaseTask );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case ENTRY:
					tCaseTask.withCaseRef( f.toQName( valueOf( o, prop ), OMGConstants.NS_OMG_CMMN_v11 ) );
					break;
			}

		} );
		return tCaseTask;
	}

	public TDecisionTask decorateDecisionTask( final S o, final TDecisionTask tDecisionTask ) {
		decorateTask( o, tDecisionTask );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case ENTRY:
					tDecisionTask.withDecisionRef( f.toQName( valueOf( o, prop ), OMGConstants.NS_OMG_DMN_v11 ) );
					break;
			}
		} );
		return tDecisionTask;
	}

	public TStage decorateStage( final S o, final TStage tStage ) {
		decoratePlanFragment( o, tStage );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case AUTO_COMPLETE: tStage.withAutoComplete( Boolean.valueOf( valueOf( o, prop ) ) );
			}
		} );
		return tStage;
	}

	public TMilestone decorateMilestone( final S o, final TMilestone tMilestone ) {
		decoratePlanItemDefinition( o, tMilestone );
		return tMilestone;
	}

	public TPlanFragment decoratePlanFragment( final S o, final TPlanFragment tPlanFragment ) {
		decoratePlanItemDefinition( o, tPlanFragment );
		return tPlanFragment;
	}


	public TSentry decorateSentry( final S o, final TSentry tSentry ) {
		decorateCmmnElement( o, tSentry);
		return tSentry;
	}

	public TIfPart decorateIf( final S o, final TIfPart tIfPart ) {
		decorateCmmnElement( o, tIfPart);
		return tIfPart;
	}

	public TPlanItemOnPart decorateOn( final S o, final TPlanItemOnPart tPlanItemOnPart ) {
		decorateCmmnElement( o, tPlanItemOnPart);
		return tPlanItemOnPart;
	}

	public TCaseFileItemOnPart decorateOnCaseFile( final S o, final TCaseFileItemOnPart tCaseFileItemOnPart ) {
		decorateCmmnElement( o, tCaseFileItemOnPart);
		return tCaseFileItemOnPart;
	}

	public TEventListener decorateEventListener( final S o, final TEventListener tEventListener ) {
		decoratePlanItemDefinition( o, tEventListener );
		return tEventListener;
	}

	public TUserEventListener decorateUserEventListener( final S o, final TUserEventListener tUserEventListener ) {
		decorateEventListener( o, tUserEventListener );
		return tUserEventListener;
	}

	public TTimerEventListener decorateTimerEventListener( final S o, final TTimerEventListener tTimerEventListener ) {
		decorateEventListener( o, tTimerEventListener );
		return tTimerEventListener;
	}

	@Override
	public TPlanItem decoratePlanItem( S s, TPlanItem tPlanItem ) {
		decorateCmmnElement( s, tPlanItem );
		return tPlanItem;
	}

	public TDocumentation decorateDocumentation( final S o, final TDocumentation tDocumentation ) {
		tDocumentation.setId( Utils.randomID() );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case ID: tDocumentation.withId( valueOf( o, prop ) );
				break;
				case TEXT_FORMAT: tDocumentation.withTextFormat( valueOf( o, prop ) );
				break;
				case DESCRIPTION:
				case DOCUMENTATION: tDocumentation.withContent( valueOf( o, prop ) );
			}
		} );
		return tDocumentation;
	}

	public TDefinitions decorateDefinitions( final S o, final TDefinitions tDefinitions ) {
		tDefinitions.setId( Utils.randomID() );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case EXPORTER: tDefinitions.withExporter( valueOf( o, prop ) );
				break;
				case EXPORTER_VERSION: tDefinitions.withExporterVersion( valueOf( o, prop ) );
				break;
			}
		} );

		if ( hasMetadata( o ) ) {
			f.buildComponent( CMMNComponents.EXTENSION,
			                  o,
			                  TExtensionElements.class ).ifPresent( tDefinitions::withExtensionElements );
		}
		return tDefinitions;
	}

	public TExtensionElements decorateExtensions( final S o, final TExtensionElements tExtensionElements ) {
		annotationsOf( o )
				.forEach( (k,v) -> tExtensionElements.withAny( new DiagramMetaData( )
						                                               .withName( k.substring( "meta-".length() ) )
						                                               .withValue( v ) ) );
		return tExtensionElements;
	}

	@Override
	public THumanTask decorateHumanTask( S o, THumanTask tHumanTask ) {
		decorateTask( o, tHumanTask );
		return tHumanTask;
	}

	@Override
	public TManualActivationRule decorateManualActivationRule( S o, TManualActivationRule tManualActivationRule ) {
		decorateCmmnElement( o, tManualActivationRule );
		return tManualActivationRule;
	}

	@Override
	public TRepetitionRule decorateRepetitionRule( S o, TRepetitionRule tRepetitionRule ) {
		decorateCmmnElement( o, tRepetitionRule );
		return tRepetitionRule;
	}

	@Override
	public TRequiredRule decorateRequiredRule( S o, TRequiredRule tRequiredRule ) {
		decorateCmmnElement( o, tRequiredRule );
		return tRequiredRule;
	}

	@Override
	public TPlanItemControl decoratePlanItemControl( S o, TPlanItemControl tPlanItemControl ) {
		decorateCmmnElement( o, tPlanItemControl );
		return tPlanItemControl;
	}

	@Override
	public TPlanningTable decoratePlanningTable( S o, TPlanningTable tPlanningTable ) {
		decorateCmmnElement( o, tPlanningTable );
		return tPlanningTable;
	}

	@Override
	public TDiscretionaryItem decorateDiscretionaryItem( S o, TDiscretionaryItem tDiscretionaryItem ) {
		decorateCmmnElement( o, tDiscretionaryItem );
		return tDiscretionaryItem;
	}

	@Override
	public TCaseFileItem decorateCaseFileItem( S o, TCaseFileItem tCaseFileItem ) {
		decorateCmmnElement( o, tCaseFileItem );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case NAME: tCaseFileItem.withName( valueOf( o, prop ) );
					break;
			}
		} );
		return tCaseFileItem;
	}

	@Override
	public TCaseFileItemDefinition decorateCaseFileItemDefinition( S o, TCaseFileItemDefinition tCaseFileItemDefinition ) {
		decorateCmmnElement( o, tCaseFileItemDefinition );
		propertiesOf( o, CMMNProperties.Category.MODEL ).forEach( ( prop ) -> {
			switch ( prop ) {
				case NAME: tCaseFileItemDefinition.withName( valueOf( o, prop ) );
					break;
			}
		} );
		return tCaseFileItemDefinition;
	}
}
