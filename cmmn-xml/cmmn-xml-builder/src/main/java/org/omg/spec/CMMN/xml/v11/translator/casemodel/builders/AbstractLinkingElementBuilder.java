package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;

import org.omg.spec.cmmn._20151109.model.TCmmnElement;

import java.util.function.Consumer;

public abstract class AbstractLinkingElementBuilder<S,T extends TCmmnElement> extends AbstractElementBuilder<S,T> {

	@Override
	public S link( final S s ) {

		b.getInboundLinks( s ).stream()
		 .map( this::getId )
		 .forEach( (id) ->
				           getElement( id )
						           .map( this::linkInbound )
						           .orElseGet( () -> postpone( id, this::linkInbound ) )
		         );

		b.getOutboundLinks( s ).stream()
		 .map( this::getId )
		 .forEach( (id) ->
				           getElement( id )
						           .map( this::linkOutbound )
						           .orElseGet( () -> postpone( id, this::linkOutbound ) )
		         );

		return s;
	}

	private T postpone( final String id, final Consumer<TCmmnElement> callback ) {
		b.registerElementCallback( id, callback );
		return element;
	}


	protected T linkInbound( final TCmmnElement inbound ) {
		return linkInbound( element, inbound );
	}

	protected T linkOutbound( final TCmmnElement outbound ) {
		return linkOutbound( element, outbound );
	}

	protected T linkInbound( final T src, final TCmmnElement inbound ) {
		return src;
	}

	protected T linkOutbound( final T src, final TCmmnElement outbound ) {
		return src;
	}

	protected T connectParent() {
		return element;
	}



}