package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TPlanItem;
import org.omg.spec.cmmn._20151109.model.TPlanItemDefinition;
import org.omg.spec.cmmn._20151109.model.TPlanningTable;
import org.omg.spec.cmmn._20151109.model.TStage;

import java.util.function.BiFunction;

public abstract class PlanItemDefinitionElementBuilder<S,T extends TPlanItemDefinition> extends AbstractLinkingElementBuilder<S,T> {

	protected <PID extends TPlanItemDefinition> void connectParent( final PID itemDef,
	                                                                boolean isDiscretionary,
	                                                                final TCmmnElement parent ) {
		if ( isStageable( parent ) || TPlanFragment.class.isInstance( parent ) ) {
			addPlanItemDefinitionToFragment( itemDef, isDiscretionary, toPlanFragment( parent )
					.orElseThrow( IllegalStateException::new ) );
		} else {
			throw new UnsupportedOperationException( "Unable to link Plan Item Definition " + itemDef + " to Parent " + parent );
		}
	}


	private <PID extends TPlanItemDefinition> void addPlanItemDefinitionToFragment( final PID itemDef,
	                                                                                boolean isDiscretionary,
	                                                                                final TPlanFragment fragment ) {
		findParentStage( fragment ).getPlanItemDefinition().add( getFactory().wrap( itemDef ) );

		// PlanFragments are just groupers, and as such are not represented
		// by 'items' within their parent (even if they usually have children items)
		if ( isItemWithLifeCycle( itemDef ) && ! isDiscretionary ) {
			//TODO check the spec to make sure that discretionary Items are NOT also represented by a PlanItem
			addPlanItemToParent( itemDef, fragment );
		}
	}

	private <PID extends TPlanItemDefinition> void addPlanItemToParent( PID itemDef, TPlanFragment frag ) {
		frag.withPlanItem( buildElement( CMMNElements.PLAN_ITEM, TPlanItem.class )
				                         .orElse( getFactory().createTPlanItem() )
				                         .withDefinitionRef( itemDef )
				                         .withId( "def_" + itemDef.getId() ) );
	}

	private <PID extends TPlanItemDefinition> boolean isItemWithLifeCycle( PID itemDef ) {
		return ! TPlanFragment.class.isInstance( itemDef ) || TStage.class.isInstance( itemDef );
	}


	@Override
	protected T decorate( S o, T element, BiFunction<S, T, T> method ) {
		return super.decorate( o, element, method );
	}



	protected boolean isDiscretionary( S o ) {
		return ( getDecorator().getProperty( o, CMMNProperties.DISCRETIONARY )
		                       .map( Boolean::valueOf )
		                       .orElse( false ) );
	}


	protected void addDiscretionary( S o ) {
			buildElement( CMMNElements.PLANNING_TABLE, TPlanningTable.class )
					.map( (t) -> t.withTableItem(
							getFactory().wrap(
									buildElement( CMMNElements.DISCRETIONARY_ITEM, TDiscretionaryItem.class )
											.get().withDefinitionRef( element ) ) ) );
	}

	@Override
	public S post( S s ) {
		S x = super.post( s );
		if ( isDiscretionary( s ) ) {
			addDiscretionary( s );
		};
		return s;
	}
}