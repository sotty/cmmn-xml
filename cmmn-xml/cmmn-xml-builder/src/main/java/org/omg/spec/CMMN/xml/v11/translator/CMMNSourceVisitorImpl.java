package org.omg.spec.CMMN.xml.v11.translator;


import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public abstract class CMMNSourceVisitorImpl<D,S,N,T> implements CMMNSourceVisitor<D, S, N, T> {

	protected Deque<N> buildStack;

	protected Map<String,N> elements;

	public CMMNSourceVisitorImpl() {
		this.buildStack = new LinkedList<>();
		this.elements = new HashMap<>();
	}

	@Override
	public T apply( final D o ) {
		return visit( getRoot( o ) );
	}

	protected abstract S getRoot( D o );

	protected abstract T visit( S o );

	public Optional<? extends N> visitSource( final S o ) throws UnsupportedOperationException {
		Optional<SourceBuilder<S,? extends N>> builder = resolveElementBuilder( o );
		if ( builder.isPresent() ) {
			Optional<? extends N> result = builder.get().apply( o );
			return result.map( this::addElement );
		} else {
			throw  new UnsupportedOperationException( "Source not supported : " + getSourceType( o ) + " by visitor " + this.getClass().getSimpleName() );
		}
	}

	@Override
	public abstract Stream<S> getChildren( final S o );

	public abstract String getSourceType( final S o );

	public Deque<N> getBuildStack() {
		return buildStack;
	}

	public abstract N addElement( final N element );

	public Optional<N> getElementByID( final String id ) {
		return Optional.ofNullable( elements.get( id ) );
	}

	public boolean hasElement( final String id ) {
		return elements.containsKey( id );
	}

	public abstract String extractOrGenerateId( final Object s );

	public abstract Collection<S> getInboundLinks( S s );

	public abstract Collection<S> getOutboundLinks( S s );

	public abstract S getNullSource();

	public abstract QName toQName( String s );
}
