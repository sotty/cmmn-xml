package org.omg.spec.CMMN.xml.v11.translator;


import java.util.Optional;
import java.util.function.Function;

public interface SourceBuilder<S,T> extends Function<S,Optional<T>> {

	S init( final S s );

	S pre( final S s );

	S process( final S s );

	S traverse( final S s );

	S link( final S s );

	S post( final S s );

	Optional<T> ret( final S s );

	@Override
	default Optional<T> apply( final S s ) {
		Function<S,Optional<T>> fun = this::ret;
		return fun
				.compose( this::post )
				.compose( this::link )
				.compose( this::traverse )
				.compose( this::process )
				.compose( this::pre )
				.compose( this::init )
				.apply( s );

	}

}
