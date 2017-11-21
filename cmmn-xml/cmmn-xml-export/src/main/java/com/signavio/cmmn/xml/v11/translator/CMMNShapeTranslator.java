package com.signavio.cmmn.xml.v11.translator;

import com.signavio.cmmn.xml.v11.Constants;
import com.signavio.cmmn.xml.v11.CustomObjectFactory;
import com.signavio.cmmn.xml.v11.translator.casemodel.CMMNShapeCaseBuilder;
import com.signavio.cmmn.xml.v11.translator.diagram.CMMNDiagramBuilder;
import com.signavio.diagram.model.Diagram;
import com.signavio.diagram.model.Shape;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.CMMNProperties;
import org.omg.spec.CMMN.xml.v11.translator.BaseCMMNTranslator;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNDI;
import org.omg.spec.cmmn._20151109.model.TDefinitions;

/**
 * Creates CMMN (AST) Object models from a Diagram model
 *
 * The transformation is the implementation of an idempotent, functional translation
 */
public class CMMNShapeTranslator extends BaseCMMNTranslator<Diagram> {

	/**
	 * Creates a default CMMN translator
	 */
	public CMMNShapeTranslator() {
		super( new CustomObjectFactory() );
	}

	/**
	 * Creates a CMMN translator with a given Object factory
	 */
	public CMMNShapeTranslator( final CMMNObjectFactory factory ) {
		super( factory );
	}

	/**
	 * The core translation method, that takes a Diagram as input, and generates a root CMMN TDefinitions object
	 * @param diagram   The input {@link Diagram}
	 * @return          A {@link TDefinitions} object
	 */
	@Override
	public TDefinitions apply( final Diagram diagram ) {
		diagram.setProperty( CMMNProperties.EXPORTER.getName(), Constants.DEFAULT_EXPORTER );
		diagram.setProperty( CMMNProperties.EXPORTER_VERSION.getName(), Constants.DEFAULT_EXPORTER_VERSION );

		CMMNCaseBuilder<Diagram,Shape> builder = new CMMNShapeCaseBuilder( diagram, factory );

		TDefinitions def = builder.apply( diagram );

		def.withCMMNDI( new CMMNDI().withCMMNDiagrams( new CMMNDiagramBuilder().apply( diagram ) ) );

		return def;
	}



}
