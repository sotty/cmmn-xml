package com.signavio.cmmn.xml.v11.translator;

import com.signavio.cmmn.xml.v11.translator.casemodel.CMMNRdfCaseBuilder;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Resource;
import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;
import org.omg.spec.CMMN.xml.v11.translator.BaseCMMNTranslator;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;
import org.omg.spec.cmmn._20151109.model.TDefinitions;


public class CMMNRdfTranslator extends BaseCMMNTranslator<Model> {

	/**
	 * Creates a CMMN translator with a given Object factory
	 */
	public CMMNRdfTranslator( final CMMNObjectFactory factory ) {
		super( factory );
	}


	@Override
	public TDefinitions apply( Model source, String id ) {

		CMMNCaseBuilder<Model,Resource> builder = new CMMNRdfCaseBuilder( source, factory );

		TDefinitions def = builder.apply( source );
		def.withTargetNamespace( id );

		return def;
	}
}
