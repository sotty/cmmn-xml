package com.signavio.cmmn.xml.v11.translator.casemodel;

import com.signavio.cmmn.xml.v11.IDUtils;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Node;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;

import javax.xml.namespace.QName;
import java.util.Collection;
import java.util.stream.Stream;

public class CMMNShapeCaseBuilder extends CMMNCaseBuilder<Diagram,Shape> {

	public static Shape NO_SHAPE = new Node( null );

	private Diagram diag;

	public CMMNShapeCaseBuilder( Diagram diag, CMMNObjectFactory factory ) {
		super( factory );
		this.diag = diag;
		this.decorator = new CMMNShapeCasePropertyDecorator( this );
	}


	@Override
	public String getSourceType( Shape o ) {
		return o.getStencilId();
	}

	@Override
	protected Shape getRoot( Diagram o ) {
		return o;
	}

	@Override
	public Stream<Shape> getChildren( Shape o ) {
		return o.getChildShapesReadOnly().stream();
	}

	public Collection<Shape> getInboundLinks( Shape s ) {
		return s.getIncomingsReadOnly();
	}

	public Collection<Shape> getOutboundLinks( Shape s ) {
		return s.getOutgoingsReadOnly();
	}

	@Override
	public Shape getNullSource() {
		return NO_SHAPE;
	}

	@Override
	public QName toQName( String s, String pre ) {
		return IDUtils.constructQName( s, pre );
	}

	/**
	 * Extracts the unique ID of the diagram, to assign it to the model.
	 * If no ID is set, a random UUID is generated to play that role
	 * For compatibility with NCNames, a "_" is then prefixed to the UUID
	 * @param shape   The source {@link Diagram}
	 * @return          A unique ID for the CMMN model instance
	 */
	@Override
	public String extractOrGenerateId( final Object shape ) {
		if ( shape instanceof Shape ) {
			return IDUtils.extractOrGenerateId( ( Shape ) shape );
		} else {
			return IDUtils.randomID();
		}

	}


	@Override
	public boolean isEntrySentry( String id ) {
		String sourceType = getSourceType( diag.getShapeById( id ) );
		return CMMNElements.IN_SENTRY == CMMNElements.parse( sourceType );
	}

}
