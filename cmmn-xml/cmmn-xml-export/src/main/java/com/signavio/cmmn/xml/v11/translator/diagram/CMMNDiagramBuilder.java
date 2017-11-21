package com.signavio.cmmn.xml.v11.translator.diagram;

import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Node;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.CMMNComponents;
import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.Utils;
import org.omg.spec.CMMN.xml.v11.translator.CMMNSourceVisitorImpl;
import org.omg.spec.CMMN.xml.v11.translator.SourceBuilder;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNDiagram;
import org.omg.spec.cmmn._20151109.di.DiagramElement;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Stream;

public class CMMNDiagramBuilder extends CMMNSourceVisitorImpl<Diagram,Shape,DiagramElement,CMMNDiagram> {

	public CMMNDiagramBuilder() {
	}

	@Override
	protected Shape getRoot( Diagram o ) {
		return o;
	}

	private Shape NO_SHAPE = new Node( null );

	@Override
	public Optional<SourceBuilder<Shape, ? extends DiagramElement>> resolveElementBuilder( Shape o ) {
		return Optional.of( new SourceBuilder<Shape, DiagramElement>() {


			@Override
			public Shape init( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Shape pre( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Shape process( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Shape traverse( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Shape link( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Shape post( Shape shape ) {
				return NO_SHAPE;
			}

			@Override
			public Optional<DiagramElement> ret( Shape shape ) {
				return Optional.empty();
			}
		} );
	}

	@Override
	public Optional<SourceBuilder<Shape, ? extends DiagramElement>> getElementBuilder( CMMNElements elem ) {
		return Optional.empty();
	}

	@Override
	public Optional<SourceBuilder<Shape, ?>> resolveComponentBuilder( Shape o ) {
		return Optional.empty();
	}

	@Override
	public Optional<SourceBuilder<Shape, ?>> getComponentBuilder( CMMNComponents comp ) {
		return Optional.empty();
	}

	@Override
	public Stream<Shape> getChildren( Shape o ) {
		return Stream.empty();
	}

	@Override
	public String getSourceType( Shape o ) {
		return "";
	}

	@Override
	public DiagramElement addElement( DiagramElement element ) {
		return element;
	}

	@Override
	protected CMMNDiagram visit( Shape o ) {
		return new CMMNDiagram();
	}

	@Override
	public String extractOrGenerateId( Object s ) {
		return Utils.randomID();
	}

	@Override
	public Collection<Shape> getInboundLinks( Shape shape ) {
		return Collections.emptyList();
	}

	@Override
	public Collection<Shape> getOutboundLinks( Shape shape ) {
		return Collections.emptyList();
	}

	@Override
	public Shape getNullSource() {
		return NO_SHAPE;
	}

	@Override
	public QName toQName( String s ) {
		return new QName( s );
	}
}
