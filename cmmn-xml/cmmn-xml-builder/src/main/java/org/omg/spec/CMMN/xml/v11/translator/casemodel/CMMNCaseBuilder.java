package org.omg.spec.CMMN.xml.v11.translator.casemodel;

import org.omg.spec.CMMN.xml.v11.CMMNComponents;
import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.translator.CMMNSourceVisitorImpl;
import org.omg.spec.CMMN.xml.v11.translator.SourceBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.BlockingHumanTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.CaseElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.CaseFileItemDefinitionElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.CaseFileItemElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.CasePlanModelElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.CaseTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.ConnectorCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.DecisionTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.DefinitionsElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.DiscrAssociationCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.DiscretionaryItemElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.DocumentationComponentBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.ElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.EventListenerElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.ExtensionsComponentBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.GenericTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.IfPartElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.ManualRuleElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.MilestoneElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.NonBlockingHumanTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.NopElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.OnFilePartElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.OnPartElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.PlanFragmentElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.PlanItemControlElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.PlanItemElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.PlanningTableElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.ProcessTaskElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.RepetitionRuleElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.RequiredRuleElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.SentryElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.StageElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.TimerEventListenerElementBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.builders.UserEventListenerElementBuilder;
import org.omg.spec.cmmn._20151109.model.TCase;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDefinitions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class CMMNCaseBuilder<D,S> extends CMMNSourceVisitorImpl<D,S,TCmmnElement,TDefinitions> {

	private TDefinitions root;

	protected CMMNCasePropertyDecorator<S> decorator;

	private CMMNObjectFactory f;

	private HashMap<String,List<Consumer<TCmmnElement>>> callbacks;

	private final Map<CMMNElements,Supplier<ElementBuilder<S,? extends TCmmnElement>>> cmmnElementBuilders = new HashMap<>();
	private final Map<CMMNComponents,Supplier<ElementBuilder<S,?>>> cmmnComponentBuilders = new HashMap<>();


	public CMMNCaseBuilder( final CMMNObjectFactory factory ) {
		this.f = factory;
		this.callbacks = new HashMap<>();
		initDefaultBuilders();
	}

	protected void initDefaultBuilders() {
		registerElementBuilder( CMMNElements.B_HUMAN_TASK, BlockingHumanTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.CASE, CaseElementBuilder::new );
		registerElementBuilder( CMMNElements.CASE_FILE_ITEM, CaseFileItemElementBuilder::new );
		registerElementBuilder( CMMNElements.CASE_FILE_ITEM_DEF, CaseFileItemDefinitionElementBuilder::new );
		registerElementBuilder( CMMNElements.CASE_PLAN, CasePlanModelElementBuilder::new );
		registerElementBuilder( CMMNElements.CASE_TASK, CaseTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.CONNECTOR, ConnectorCaseBuilder::new );
		registerElementBuilder( CMMNElements.DECISION_TASK, DecisionTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.DISCRETIONARY_ASSOCIATION, DiscrAssociationCaseBuilder::new );
		registerElementBuilder( CMMNElements.DISCRETIONARY_ITEM, DiscretionaryItemElementBuilder::new );
		registerElementBuilder( CMMNElements.EVENT_LISTENER, EventListenerElementBuilder::new );
		registerElementBuilder( CMMNElements.EXIT_SENTRY, SentryElementBuilder::new );
		registerElementBuilder( CMMNElements.IF_PART, IfPartElementBuilder::new );
		registerElementBuilder( CMMNElements.IN_SENTRY, SentryElementBuilder::new );
		registerElementBuilder( CMMNElements.MANUAL_RULE, ManualRuleElementBuilder::new );
		registerElementBuilder( CMMNElements.MILESTONE, MilestoneElementBuilder::new );
		registerElementBuilder( CMMNElements.NB_HUMAN_TASK, NonBlockingHumanTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.ON_PART, OnPartElementBuilder::new );
		registerElementBuilder( CMMNElements.ON_FILE_PART, OnFilePartElementBuilder::new );
		registerElementBuilder( CMMNElements.PLAN_FRAGMENT_COLL, PlanFragmentElementBuilder::new );
		registerElementBuilder( CMMNElements.PLAN_FRAGMENT_EXP, PlanFragmentElementBuilder::new );
		registerElementBuilder( CMMNElements.PLAN_ITEM, PlanItemElementBuilder::new );
		registerElementBuilder( CMMNElements.PLAN_ITEM_CONTROL, PlanItemControlElementBuilder::new );
		registerElementBuilder( CMMNElements.PLANNING_TABLE, PlanningTableElementBuilder::new );
		registerElementBuilder( CMMNElements.PROCESS_TASK, ProcessTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.REPETITION_RULE, RepetitionRuleElementBuilder::new );
		registerElementBuilder( CMMNElements.REQUIRED_RULE, RequiredRuleElementBuilder::new );
		registerElementBuilder( CMMNElements.SENTRY, SentryElementBuilder::new );
		registerElementBuilder( CMMNElements.STAGE, StageElementBuilder::new );
		registerElementBuilder( CMMNElements.STAGE_COLL, StageElementBuilder::new );
		registerElementBuilder( CMMNElements.STAGE_EX, StageElementBuilder::new );
		registerElementBuilder( CMMNElements.TASK, GenericTaskElementBuilder::new );
		registerElementBuilder( CMMNElements.TIMER_EVENT_LISTENER, TimerEventListenerElementBuilder::new );
		registerElementBuilder( CMMNElements.USER_EVENT_LISTENER, UserEventListenerElementBuilder::new );


		registerElementBuilder( CMMNElements.TEXT, NopElementBuilder::new );
		registerComponentBuilder( CMMNComponents.DOCUMENTATION, DocumentationComponentBuilder::new );
		registerComponentBuilder( CMMNComponents.DEFINITIONS, DefinitionsElementBuilder::new );
		registerComponentBuilder( CMMNComponents.EXTENSION, ExtensionsComponentBuilder::new );
	}

	public TDefinitions getRoot() {
		return root;
	}

	public CMMNCasePropertyDecorator<S> getDecorator() {
		return decorator;
	}

	public CMMNObjectFactory getFactory() {
		return f;
	}

	public TCmmnElement addElement( TCmmnElement el ) {
		if ( callbacks.containsKey( el.getId() ) ) {

			List<Consumer<TCmmnElement>> callees = callbacks.remove( el.getId() );
			callees.forEach( (x) -> x.accept( el ) );
		}

		this.elements.put( el.getId(), el );
		return el;
	}

	public void registerElementCallback( String id, Consumer<TCmmnElement> callback ) {
		if ( elements.containsKey( id ) ) {
			return;
		}
		if (! callbacks.containsKey( id )) {
			callbacks.put( id, new LinkedList<>() );
		}
		callbacks.get( id ).add( callback );
	}


	@Override
	protected TDefinitions visit( final S o ) {
		root = buildComponent( CMMNComponents.DEFINITIONS, o, TDefinitions.class )
				.orElseGet( f::createTDefinitions );

		Optional<? extends TCmmnElement> el = visitSource( o );

		el.ifPresent( tCmmnElement -> root.withCase( TCase.class.isInstance( tCmmnElement )
				                                                      ? TCase.class.cast( tCmmnElement )
				                                                      : f.createTCase() ) );
		return root;
	}




	protected void registerElementBuilder( final CMMNElements elem,
	                                       final Supplier<ElementBuilder<S,? extends TCmmnElement>> builder ) {
		this.cmmnElementBuilders.put( elem, builder );

	}

	@Override
	public Optional<SourceBuilder<S, ? extends TCmmnElement>> resolveElementBuilder( final S o ) {
		CMMNElements element = CMMNElements.parse( getSourceType( o ) );
		return getElementBuilder( element );
	}


	public Optional<SourceBuilder<S,? extends TCmmnElement>> getElementBuilder( final CMMNElements el ) {
		return cmmnElementBuilders.containsKey( el ) ?
            Optional.of ( cmmnElementBuilders.get( el ).get().withCaseBuilder( this ) ) :
			Optional.empty();
	}


	protected void registerComponentBuilder( final CMMNComponents comp,
	                                         final Supplier<ElementBuilder<S,?>> builder ) {
		this.cmmnComponentBuilders.put( comp, builder );
	}

	@Override
	public Optional<SourceBuilder<S, ?>> resolveComponentBuilder( final S o ) {
		CMMNComponents element = CMMNComponents.parse( getSourceType( o ) );
		return getComponentBuilder( element );
	}


	public Optional<SourceBuilder<S,?>> getComponentBuilder( final CMMNComponents comp ) {
		return cmmnComponentBuilders.containsKey( comp ) ?
				Optional.of ( cmmnComponentBuilders.get( comp ).get().withCaseBuilder( this ) ) :
				Optional.empty();
	}



	public <X extends TCmmnElement> Optional<X> buildElement( final CMMNElements elem,
	                                                          final Class<X> buildAs ) {
		return buildElement( elem, getNullSource(), buildAs );
	}

	public <X extends TCmmnElement> Optional<X> buildElement( final CMMNElements elem,
	                                                          final S o,
	                                                          Class<X> buildAs ) {
		return getElementBuilder( elem )
				.map( (t) -> t.apply( o ) )
				.filter( Optional::isPresent )
				.map( Optional::get )
				.map( (x) -> x.withId( extractOrGenerateId( o ) ) )
				.filter( buildAs::isInstance )
				.map( buildAs::cast );
	}



	public <X> Optional<X> buildComponent( final CMMNComponents comp,
	                                       final S o,
	                                       final Class<X> buildAs ) {
		return getComponentBuilder( comp )
				.map( t -> t.apply( o ) )
				.map( Optional::get )
				.filter( buildAs::isInstance )
				.map( buildAs::cast );

	}

	public abstract boolean isEntrySentry( String id );
}
