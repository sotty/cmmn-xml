package com.signavio.cmmn.xml.v11;


import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.OMGConstants;
import org.oryxeditor.server.diagram.exception.DiagramSystemIdNotSetException;

import javax.xml.namespace.QName;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDUtils extends org.omg.spec.CMMN.xml.v11.Utils {

	static Pattern MODEL = Pattern.compile( ".*(\"model\":\")([\\w\\d-\\/]+)" );
	static Pattern SHAPE = Pattern.compile( ".*(\"shape\":\")([\\w\\d-]+)" );


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
				id = "id-" + shape.getGloballyUniqueResourceId();
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

	public static String getNamespace( final String artifactId ) {
		return Constants.NS_CMMN_DIAGRAM_SIGNAVIO + '/' + artifactId + ".xml";
	}


	public static String asReference( String value ) {
		Matcher sm = SHAPE.matcher( value );
		Matcher mm = MODEL.matcher( value );

		sm.find();
		mm.find();

		return mm.group( 2 ) + "#" + sm.group( 2 );
	}

	public static boolean isReference( String value ) {
		return SHAPE.matcher( value ).find() && MODEL.matcher( value ).find();
	}

	public static QName constructQName( String s, String pre ) {
		// adapt the NS to actually use the Signavio space
		switch ( pre ) {
			case OMGConstants.NS_OMG_DMN_v11 :
				pre = Constants.NS_DMN_DIAGRAM_SIGNAVIO;
				break;
			case OMGConstants.NS_OMG_BPMN_v20:
				pre = Constants.NS_BPMN_DIAGRAM_SIGNAVIO;
				break;
			case OMGConstants.NS_OMG_CMMN_v11:
			default:
				pre = Constants.NS_CMMN_DIAGRAM_SIGNAVIO;
		}

		if ( s.contains( "#" ) ) {
			return new QName( pre + s.substring( s.lastIndexOf( '/' ), s.indexOf( '#' ) ) + ".xml",
			                  s.substring( s.indexOf( '#' ) +1 )  );
		} else {
			return new QName( pre + '/' + s.substring( s.lastIndexOf( '/' ) + 1 ) + ".xml", "_" );
		}
	}
}
