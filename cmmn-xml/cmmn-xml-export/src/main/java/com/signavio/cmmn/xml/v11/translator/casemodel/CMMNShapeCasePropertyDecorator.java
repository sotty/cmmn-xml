package com.signavio.cmmn.xml.v11.translator.casemodel;


import com.signavio.cmmn.xml.v11.IDUtils;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCasePropertyDecoratorImpl;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CMMNShapeCasePropertyDecorator extends CMMNCasePropertyDecoratorImpl<Diagram,Shape> {


	CMMNShapeCasePropertyDecorator( final CMMNCaseBuilder<Diagram,Shape> factory ) {
		super( factory );
	}

	public Stream<CMMNProperties> propertiesOf( final Shape o, final CMMNProperties.Category cat ) {
		return o.getPropertyNames().stream()
		        .map( CMMNProperties::parse )
		        .filter( (p) -> p.getCat() == cat )
		        .filter( (p) -> ! o.getProperty( p.getName() ).isEmpty() );
	}

	@Override
	protected boolean hasMetadata( Shape o ) {
		return o.getPropertyNames().stream()
		        .anyMatch( (name) -> name.startsWith( "meta" ) );
	}

	@Override
	protected Map<String, String> annotationsOf( Shape o ) {
		return o.getPropertyNames().stream()
		        .filter( (n) -> n.startsWith( "meta" ) )
				.collect( Collectors.toMap( Function.identity(), o::getProperty ) );
	}

	public Optional<String> getProperty( final Shape o, final CMMNProperties prop ) {
		return Optional.ofNullable( o.getProperty( prop.getName() ) );
	}

	public String valueOf( final Shape o, final CMMNProperties prop ) {
		String value = o.getProperty( prop.getName() );
		return isComplex( value ) ? parseComplex( value, prop ) : value ;
	}

	private String parseComplex( String value, CMMNProperties prop ) {
		if ( prop == CMMNProperties.ENTRY ) {
			return IDUtils.isReference( value ) ? IDUtils.asReference( value ) : value ;
		} else {
			return value;
		}

	}
	private boolean isComplex( String value ) {
		return value.startsWith( "{" ) && value.endsWith( "}" );
	}

}
