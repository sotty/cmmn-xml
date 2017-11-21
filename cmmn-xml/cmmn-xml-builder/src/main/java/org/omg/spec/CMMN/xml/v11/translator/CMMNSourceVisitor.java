package org.omg.spec.CMMN.xml.v11.translator;

import org.omg.spec.CMMN.xml.v11.CMMNComponents;
import org.omg.spec.CMMN.xml.v11.CMMNElements;

import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

public interface CMMNSourceVisitor<D, S, N, T> extends Function<D, T> {

	@Override
	T apply( final D o );

	Optional<SourceBuilder<S, ? extends N>> resolveElementBuilder( final S o );

	Optional<SourceBuilder<S, ? extends N>> getElementBuilder( final CMMNElements elem );

	Optional<SourceBuilder<S,?>> resolveComponentBuilder( final S o );

	Optional<SourceBuilder<S,?>> getComponentBuilder( final CMMNComponents comp );

	Stream<S> getChildren( S o );

	String getSourceType( S o );
}
