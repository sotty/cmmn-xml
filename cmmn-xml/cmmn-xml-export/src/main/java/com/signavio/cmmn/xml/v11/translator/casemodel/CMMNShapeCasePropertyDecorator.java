package com.signavio.cmmn.xml.v11.translator.casemodel;


import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCasePropertyDecoratorImpl;

import java.util.Optional;
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

	public Optional<String> getProperty( final Shape o, final CMMNProperties prop ) {
		return Optional.ofNullable( o.getProperty( prop.getName() ) );
	}

	public String valueOf( final Shape o, final CMMNProperties prop ) {
		return o.getProperty( prop.getName() );
	}

}
