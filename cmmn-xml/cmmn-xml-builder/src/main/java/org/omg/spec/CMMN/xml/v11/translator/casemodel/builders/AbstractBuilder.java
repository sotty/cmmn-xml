package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCasePropertyDecorator;
import org.omg.spec.cmmn._20151109.model.TCase;
import org.omg.spec.cmmn._20151109.model.TCmmnElement;
import org.omg.spec.cmmn._20151109.model.TDefinitions;
import org.omg.spec.cmmn._20151109.model.TPlanFragment;
import org.omg.spec.cmmn._20151109.model.TStage;

import javax.xml.namespace.QName;
import java.util.Deque;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public abstract class AbstractBuilder<S,T> implements ElementBuilder<S,T> {

	protected CMMNCaseBuilder<?,S> b;

	protected T element;

	public AbstractBuilder<S,T> withCaseBuilder( final CMMNCaseBuilder<?,S> cb ) {
		this.b = cb;
		return this;
	}

	protected TDefinitions getRoot() {
		return b.getRoot();
	}

	protected Deque<TCmmnElement> getBuildStack() {
		return b.getBuildStack();
	}

	protected CMMNCasePropertyDecorator<S> getDecorator() {
		return b.getDecorator();
	}

	protected CMMNObjectFactory getFactory() {
		return b.getFactory();
	}

	protected Stream<S> getChildren( final S o ) {
		return b.getChildren( o );
	}

	protected Optional<? extends TCmmnElement> visit( final S o ) {
		return b.visitSource( o );
	}

	protected T decorate( final S o, final T element, final BiFunction<S,T,T> method ) {
		return method.apply( o, element );
	}

	protected String getId( final S o ) {
		return b.extractOrGenerateId( o );
	}

	protected boolean isEntrySentry( String sid ) {
		return b.isEntrySentry( sid );
	}


	protected QName toQName( String s, String pre ) {
		return b.toQName( s, pre );
	}


	protected <X extends TCmmnElement> Optional<X> buildElement( final CMMNElements elem,
	                                                             final Class<X> buildAs ) {
		return b.buildElement( elem, buildAs );
	}

	protected <X extends TCmmnElement> Optional<X> buildElement( final CMMNElements elem,
	                                                             final S o,
	                                                             final Class<X> buildAs ) {
		return b.buildElement( elem, o, buildAs );
	}




	protected TStage findParentStage( final TPlanFragment fragment ) {
		if ( TStage.class.isInstance( fragment ) ) {
			return TStage.class.cast( fragment );
		} else {
			return findParentStage();
		}
	}

	protected TStage findParentStage() {
		return getBuildStack().stream()
		                      .filter( this::isStageable )
		                      .findFirst()
		                      .map( this::toStage ).map( Optional::get )
		                      .orElseThrow( IllegalStateException::new );
	}

	protected TCase findParentCase() {
		return getBuildStack().stream()
		                      .filter( TCase.class::isInstance )
		                      .map( TCase.class::cast )
		                      .findFirst()
		                      .orElseThrow( IllegalStateException::new );
	}

	protected boolean isStageable( final TCmmnElement element ) {
		return element instanceof TCase || element instanceof TStage;
	}

	protected Optional<TStage> toStage( final TCmmnElement element ) {
		if ( element instanceof TStage ) {
			return Optional.of( (TStage) element );
		}
		if ( element instanceof TCase ) {
			return Optional.of( asCaseWithPlanModel( element ).getCasePlanModel() );
		}
		return Optional.empty();
	}

	protected Optional<? extends TPlanFragment> toPlanFragment( final TCmmnElement element ) {
		if ( TPlanFragment.class.isInstance( element ) ) {
			return Optional.of( TPlanFragment.class.cast( element ) );
		} else {
			return toStage( element );
		}
	}

	protected TCase asCaseWithPlanModel( final TCmmnElement target ) {
		TCase aCase = (TCase) target;
		if ( aCase.getCasePlanModel() == null ) {
			TStage anonStage = new TStage();
			aCase.withCasePlanModel( anonStage );
		}
		return aCase;
	}




	@Override
	public S pre( final S s ) {
		return s;
	}

	@Override
	public abstract S init( final S s );

	@Override
	public S process( final S s ) {
		return s;
	}

	@Override
	public S traverse( final S s ) {
		return s;
	}

	@Override
	public S post( final S s ) {
		return s;
	}

	@Override
	public S link( final S s ) {
		return s;
	}

	@Override
	public Optional<T> ret( final S s ) {
		return Optional.of( element );
	}


}