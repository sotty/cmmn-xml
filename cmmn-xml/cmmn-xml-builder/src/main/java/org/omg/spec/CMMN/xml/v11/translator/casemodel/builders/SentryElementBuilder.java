package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.cmmn._20151109.model.TCaseFileItem;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TCriterion;
import org.omg.spec.cmmn._20151109.model.TDiscretionaryItem;
import org.omg.spec.cmmn._20151109.model.TExitCriterion;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TPlanItem;
import org.omg.spec.cmmn._20151109.model.TPlanItemDefinition;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;
import org.omg.spec.cmmn._20151109.model.TSentry;
import org.omg.spec.cmmn._20151109.model.TStage;

import javax.xml.bind.JAXBElement;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;


public class SentryElementBuilder<S> extends AbstractLinkingElementBuilder<S,TSentry> {


	public SentryElementBuilder() {}

	@Override
	public S init( final S s ) {
		element = getFactory().createTSentry()
					.withIfPart( getFactory().createTIfPart() );
		return s;
	}

	@Override
	protected BiFunction<S, TSentry, TSentry> getDecoratorFunction() {
		return getDecorator()::decorateSentry;
	}

	@Override
	public S link( S s ) {
		connectSentryToParent( element, getCurrentStage() );
		return super.link( s );
	}

	protected TSentry linkInbound( final TCmmnElement link ) {
		boolean isEntry = isEntrySentry( element.getId() );
			attachSentry( element, link, getCurrentStage(), isEntry );
		return element;
	}

	protected TSentry linkOutbound( final TCmmnElement link ) {
		boolean isEntry = isEntrySentry( element.getId() );
			attachSentry( element, link, getCurrentStage(), isEntry );
		return element;
	}

	protected TSentry linkInbound( final TSentry src, final TCmmnElement inbound ) {
		boolean isEntry = isEntrySentry( src.getId() );
			connectSentry( src, inbound, getParentStage( src ), isEntry );
		return src;
	}

	protected TSentry linkOutbound( final TSentry src, final TCmmnElement outbound ) {
		boolean isEntry = isEntrySentry( src.getId() );
			connectSentry( src, outbound, getParentStage( src ), isEntry );
		return src;
	}



	private TStage getCurrentStage() {
		return toStage( getBuildStack().peek() )
				.orElseThrow( () -> new IllegalStateException( "(Sentry-scoping) Stage was expected on the build stack" ) );
	}

	private TStage getParentStage( final TSentry sentry ) {
		Optional<TStage> s = findSentryParentStage( getBuildStack().peek(), sentry  );
		return s
				.orElseThrow( () -> new UnsupportedOperationException( "Unable to find parent stage for sentry " + sentry.getId() ) );
	}

	private Optional<TStage> findSentryParentStage( final TCmmnElement el, final TSentry sentry ) {
		// The actual sentry immediate parent may have already been pulled off the stack
		if ( isStageable( el ) ) {
			TStage stage = toStage( el ).orElseThrow( IllegalStateException::new );
			if ( stage.getSentry().contains( sentry ) ) {
				// sentry may be on the stage itself
				return Optional.of( stage );
			} else if ( getSentryReferencingPlanItem( stage, sentry ).isPresent() ) {
				// or one of the plan items (e.g. task) in the stage
				return Optional.of( stage );
			} else {
				// or nested deeper, so recur
				return stage.getPlanItem().stream()
				            .map( TPlanItem::getDefinitionRef )
				            .filter( TPlanFragment.class::isInstance )
				            .map( TPlanFragment.class::cast )
				            .map( (itemDef) -> findSentryParentStage( itemDef, sentry ) )
				            .filter( Optional::isPresent )
				            .map( Optional::get )
				            .findAny();
			}
		}
		return Optional.empty();
	}

	private Optional<TPlanItem> getSentryReferencingPlanItem( final TPlanFragment fragment, final TSentry ref ) {
		if ( ! fragment.getSentry().contains( ref ) ) {
			return Optional.empty();
		}
		Optional<TPlanItem> item = fragment.getPlanItem().stream()
		                                   .filter( (pi) -> isSentryReference( pi, ref ) )
		                                   .findAny();
		if ( ! item.isPresent() ) {
			// the item may reference a stage that has nested references
			item = fragment.getPlanItem().stream()
			               .map( TPlanItem::getDefinitionRef )
			               .filter( TStage.class::isInstance )
			               .map( TStage.class::cast )
			               .map( (stage) -> getSentryReferencingPlanItem( stage, ref ) )
			               .findAny()
			               .map( Optional::get );
		}
		return item;
	}

	private Optional<TDiscretionaryItem> getSentryReferencingDiscretionaryItem( final TPlanFragment fragment, final TSentry ref ) {
		if ( ! fragment.getSentry().contains( ref ) ) {
			return Optional.empty();
		}
		if ( isStageable( fragment ) ) {
			TStage stage = toStage( fragment ).orElseThrow( IllegalStateException::new );
			return stage.getPlanningTable().getTableItem().stream()
			            .map( JAXBElement::getValue )
			            .filter( TDiscretionaryItem.class::isInstance )
			            .map( TDiscretionaryItem.class::cast )
			            .filter( (di) -> isSentryReferenceDiscr( di, ref ) )
			            .findAny();
		}
		return Optional.empty();
	}


	private boolean isSentryReference( TPlanItem pi, TSentry ref ) {
		return Stream.concat( pi.getEntryCriterion().stream(), pi.getExitCriterion().stream() )
		             .map( TCriterion::getSentryRef )
		             .anyMatch( ref::equals );
	}

	private boolean isSentryReferenceDiscr( TDiscretionaryItem pi, TSentry ref ) {
		return Stream.concat( pi.getEntryCriterion().stream(), pi.getExitCriterion().stream() )
		             .map( TCriterion::getSentryRef )
		             .anyMatch( ref::equals );
	}

	protected <F extends TSentry> void connectSentryToParent( final F itemDef,
	                                                          final TStage parentStage ) {
		parentStage.getSentry().add( itemDef );
	}

	protected <F extends TSentry> void attachSentry( final F element,
	                                                 TCmmnElement target,
	                                                 TStage parent,
	                                                 boolean entry ) {
		if ( target instanceof TPlanItemDefinition ) {
			attachSentryToPlanItemDefinition( element,
			                                  (TPlanItemDefinition) target,
			                                  parent,
			                                  entry );
		} else {
			throw new UnsupportedOperationException( "Unable to attachSentry Sentry to Element " );
		}
	}


	protected void attachSentryToPlanItemDefinition( final TSentry element,
	                                                 final TPlanItemDefinition target,
	                                                 final TStage parentStage,
	                                                 final boolean entry ) {
		parentStage.getPlanItem().stream()
		           .filter( (x) -> x.getDefinitionRef().equals( target ) )
		           .findAny()
		           .map( (def) -> entry
				           ? def.withEntryCriterion( getFactory().createTEntryCriterion()
				                                                 .withSentryRef( element )
				                                                 .withId( Utils.randomID() ) )
				           : def.withExitCriterion( getFactory().createTExitCriterion()
				                                                .withSentryRef( element )
				                                                .withId( Utils.randomID() ) ) );

		if ( parentStage.getPlanningTable() != null ) {
			parentStage.getPlanningTable().getTableItem().stream()
			           .map( JAXBElement::getValue )
			           .filter( TDiscretionaryItem.class::isInstance )
			           .map( TDiscretionaryItem.class::cast )
			           .filter( ( x ) -> x.getDefinitionRef().equals( target ) )
			           .findAny()
			           .map( ( def ) -> entry
					           ? def.withEntryCriterion( getFactory().createTEntryCriterion()
					                                                 .withSentryRef( element )
					                                                 .withId( Utils.randomID() ) )
					           : def.withExitCriterion( getFactory().createTExitCriterion()
					                                                .withSentryRef( element )
					                                                .withId( Utils.randomID() ) ) );
		}
	}


	protected <F extends TSentry> void connectSentry( final F sentry,
	                                                  TCmmnElement target,
	                                                  TStage parentStage,
	                                                  boolean entry ) {
		if ( target instanceof TPlanItemDefinition ) {
			parentStage.getPlanItem().stream()
			           .filter( (x) -> x.getDefinitionRef().equals( target ) )
			           .findAny()
			           .map( (def) ->
					                 sentry.withOnPart( getFactory().wrap(
							                 buildElement( CMMNElements.ON_PART, TPlanItemOnPart.class ).get()
							                                                                            .withSourceRef( def ) ) ) );
		} else if ( target instanceof TSentry ) {
			if ( entry ) {
				connectSentryToSentry( sentry, ( TSentry ) target, parentStage );
			}
		} else if ( target instanceof TCaseFileItem ) {
			TCaseFileItem cfi = (TCaseFileItem) target;
			findParentCase().getCaseFileModel().getCaseFileItem().stream()
			           .filter( (x) -> x.getDefinitionRef().equals( cfi.getDefinitionRef() ) )
			           .findAny()
			           .map( (def) ->
					                 sentry.withOnPart( getFactory().wrap(
							                 buildElement( CMMNElements.ON_FILE_PART, TCaseFileItemOnPart.class ).get()
							                                                                                     .withSourceRef( def ) ) ) );

		} else {
			throw new UnsupportedOperationException( "Unable to connectParent Element to Sentry" );
		}
	}


	protected void connectSentryToSentry( TSentry src, TSentry tgt, TStage parentStage ) {
		final Object source;
		final TExitCriterion exitRef;

		Optional<TPlanItem> item = getSentryReferencingPlanItem( parentStage, tgt );
		if ( item.isPresent() ) {
			source = item.get();
			exitRef = item.get().getExitCriterion().stream()
			              .filter( (ex) -> ex.getSentryRef().equals( tgt ) )
			              .findAny()
			              .orElseThrow( IllegalStateException::new );
		} else {
			// may be a discretionary item
			TDiscretionaryItem discr = getSentryReferencingDiscretionaryItem( parentStage, tgt )
					.orElseThrow( IllegalStateException::new );
			source = discr;
			exitRef = discr.getExitCriterion().stream()
			               .filter( (ex) -> ex.getSentryRef().equals( tgt ) )
			               .findAny()
			               .orElseThrow( IllegalStateException::new );
		}

		src.withOnPart(
				getFactory().wrap( getFactory().createTPlanItemOnPart()
				                               .withExitCriterionRef( exitRef )
				                               .withSourceRef( source ) ) );

	}


}

