package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.cmmn._20151109.model.TCaseFileItem;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemOnPart;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TPlanItem;
import org.omg.spec.cmmn._20151109.model.TPlanItemDefinition;
import org.omg.spec.cmmn._20151109.model.TPlanItemOnPart;
import org.omg.spec.cmmn._20151109.model.TSentry;
import org.omg.spec.cmmn._20151109.model.TStage;

import java.util.function.BiFunction;

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
		connectSentryToParent( element, getBuildStack().getFirst() );
		return super.link( s );
	}

	protected TSentry linkInbound( final TCmmnElement link ) {
		boolean isEntry = isEntrySentry( element.getId() );
			attachSentry( element, link, getBuildStack().getFirst(), isEntry );
		return element;
	}

	protected TSentry linkOutbound( final TCmmnElement link ) {
		boolean isEntry = isEntrySentry( element.getId() );
			attachSentry( element, link, getBuildStack().getFirst(), isEntry );
		return element;
	}

	protected TSentry linkInbound( final TSentry src, final TCmmnElement inbound ) {
		boolean isEntry = isEntrySentry( src.getId() );
			connectSentry( src, inbound, getBuildStack().getFirst(), isEntry );
		return src;
	}

	protected TSentry linkOutbound( final TSentry src, final TCmmnElement outbound ) {
		boolean isEntry = isEntrySentry( src.getId() );
			connectSentry( src, outbound, getBuildStack().getFirst(), isEntry );
		return src;
	}



	protected <F extends TSentry> void connectSentryToParent( final F itemDef,
	                                                          final TCmmnElement parent ) {
		if ( isStageable( parent ) ) {
			toStage( parent ).map( (stage) -> stage.getSentry().add( itemDef ) )
			                 .orElseThrow( IllegalStateException::new );
		} else {
			throw new UnsupportedOperationException( "Unable to connectParent PF" );
		}
	}

	protected <F extends TSentry> void attachSentry( final F element,
	                                                 TCmmnElement target,
	                                                 TCmmnElement parent,
	                                                 boolean entry ) {
		if ( target instanceof TPlanItemDefinition ) {
			attachSentryToPlanItemDefinition( element,
			                                  (TPlanItemDefinition) target,
			                                  toStage( parent ).orElseThrow( IllegalStateException::new ),
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
	}


	protected <F extends TSentry> void connectSentry( final F sentry,
	                                                  TCmmnElement target,
	                                                  TCmmnElement parent,
	                                                  boolean entry ) {
		if ( target instanceof TPlanItemDefinition ) {
			TStage parentStage = toStage( parent ).orElseThrow( IllegalStateException::new );
			parentStage.getPlanItem().stream()
			           .filter( (x) -> x.getDefinitionRef().equals( target ) )
			           .findAny()
			           .map( (def) ->
					                 sentry.withOnPart( getFactory().wrap(
							                 buildElement( CMMNElements.ON_PART, TPlanItemOnPart.class ).get()
							                                                                            .withSourceRef( def ) ) ) );
		} else if ( target instanceof TSentry ) {
			if ( entry ) {
				connectSentryToSentry( sentry, ( TSentry ) target, parent );
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


	protected void connectSentryToSentry( TSentry src, TSentry tgt, TCmmnElement parent ) {
		if ( isStageable( parent ) ) {
			TPlanItem item = toStage( parent ).orElseThrow( IllegalStateException::new )
			                                  .getPlanItem().stream()
			                                  .filter( (pi) -> pi.getExitCriterion().stream()
			                                                     .anyMatch( (ex) -> ex.getSentryRef().equals( tgt ) ) )
			                                  .findFirst()
			                                  .orElseThrow( IllegalStateException::new );

			src.withOnPart(
					getFactory().wrap( getFactory().createTPlanItemOnPart()
					                               .withExitCriterionRef(
							                               item.getExitCriterion().stream()
							                                   .filter( (ex) -> ex.getSentryRef().equals( tgt ) )
							                                   .findAny().orElseThrow( IllegalStateException::new ) )
					                               .withSourceRef( item ) ) );
		} else {
			throw new UnsupportedOperationException( "Unable to connectParent Sentry to Sentry" );
		}
	}


}

