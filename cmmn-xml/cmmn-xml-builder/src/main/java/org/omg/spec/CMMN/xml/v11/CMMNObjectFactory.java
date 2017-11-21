package org.omg.spec.CMMN.xml.v11;

import org.omg.spec.cmmn._20151109.model.ObjectFactory;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemDefinition;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;
import org.omg.spec.cmmn._20151109.model.TCaseTask;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDecisionTask;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.TEventListener;
import org.omg.spec.cmmn._20151109.model.THumanTask;
import org.omg.spec.cmmn._20151109.model.TMilestone;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;
import org.omg.spec.cmmn._20151109.model.TProcessTask;
import org.omg.spec.cmmn._20151109.model.TStage;
import org.omg.spec.cmmn._20151109.model.TTask;
import org.omg.spec.cmmn._20151109.model.TTimerEventListener;
import org.omg.spec.cmmn._20151109.model.TUserEventListener;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class CMMNObjectFactory extends ObjectFactory {

	public static final String	DEFAULT_NAMESPACE_NAME			= "";
	public static final String	DEFAULT_NAMESPACE				= "http://www.omg.org/spec/CMMN/20151109/MODEL";

	public static final String	SCHEMA_LOCATION				    = "http://www.omg.org/spec/CMMN/20151109/CMMN11.xsd";


	public <X extends TCmmnElement> JAXBElement<X> wrap( X elem ) {

		if ( elem.getClass().equals( TStage.class ) ) {
			return ( JAXBElement<X> ) createStage( ( TStage ) elem );
		}
		if ( elem.getClass().equals( TTask.class ) ) {
			return ( JAXBElement<X> ) createTask( ( TTask ) elem );
		}
		if ( elem.getClass().equals( TProcessTask.class ) ) {
			return ( JAXBElement<X> ) createProcessTask( ( TProcessTask ) elem );
		}
		if ( elem.getClass().equals( THumanTask.class ) ) {
			return ( JAXBElement<X> ) createHumanTask( ( THumanTask ) elem );
		}
		if ( elem.getClass().equals( TCaseTask.class ) ) {
			return ( JAXBElement<X> ) createCaseTask( ( TCaseTask ) elem );
		}
		if ( elem.getClass().equals( TDecisionTask.class ) ) {
			return ( JAXBElement<X> ) createDecisionTask( ( TDecisionTask ) elem );
		}
		if ( elem.getClass().equals( TEventListener.class ) ) {
			return ( JAXBElement<X> ) createEventListener( ( TEventListener ) elem );
		}
		if ( elem.getClass().equals( TTimerEventListener.class ) ) {
			return ( JAXBElement<X> ) createTimerEventListener( ( TTimerEventListener ) elem );
		}
		if ( elem.getClass().equals( TUserEventListener.class ) ) {
			return ( JAXBElement<X> ) createUserEventListener( ( TUserEventListener ) elem );
		}
		if ( elem.getClass().equals( TMilestone.class ) ) {
			return ( JAXBElement<X> ) createMilestone( ( TMilestone ) elem );
		}
		if ( elem.getClass().equals( TPlanItemOnPart.class ) ) {
			return ( JAXBElement<X> ) createPlanItemOnPart( ( TPlanItemOnPart ) elem );
		}
		if ( elem.getClass().equals( TCaseFileItemOnPart.class ) ) {
			return ( JAXBElement<X> ) createCaseFileItemOnPart( ( TCaseFileItemOnPart ) elem );
		}
		if ( elem.getClass().equals( TDiscretionaryItem.class ) ) {
			return ( JAXBElement<X> ) createDiscretionaryItem( ( TDiscretionaryItem ) elem );
		}
		if ( elem.getClass().equals( TPlanFragment.class ) ) {
			return ( JAXBElement<X> ) createPlanFragment( ( TPlanFragment ) elem );
		}
		if ( elem.getClass().equals( TCaseFileItemDefinition.class ) ) {
			return ( JAXBElement<X> ) createCaseFileItemDefinition( ( TCaseFileItemDefinition ) elem );
		}

		throw new UnsupportedOperationException( "TODO: provide wrapper for " + elem.getClass() );

	}
}

