package com.signavio.cmmn.xml.v11;


import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Shape;
import org.oryxeditor.server.diagram.exception.DiagramSystemIdNotSetException;

import java.util.UUID;

public class IDUtils extends org.omg.spec.CMMN.xml.v11.Utils {

	/**
	 * Extracts the unique ID of the diagram, to assign it to the model.
	 * If no ID is set, a random UUID is generated to play that role
	 * For compatibility with NCNames, a "_" is then prefixed to the UUID
	 * @param shape   The source {@link Diagram}
	 * @return          A unique ID for the CMMN model instance
	 */
	public static String extractOrGenerateId( final Shape shape ) {
		String id;
		if ( shape instanceof Diagram ) {
			try {
				id = "_" + shape.getGloballyUniqueResourceId();
			} catch ( DiagramSystemIdNotSetException e ) {
				id = null;
			}
		} else {
			id = shape.getResourceId();
		}
		if ( id == null ) {
			id = "_" + UUID.randomUUID().toString();
		}
		return id;
	}

}
