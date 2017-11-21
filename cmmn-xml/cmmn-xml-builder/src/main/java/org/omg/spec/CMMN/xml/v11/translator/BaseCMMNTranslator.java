package org.omg.spec.CMMN.xml.v11.translator;

import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;

/**
 * Creates CMMN (AST) Object models from a Source model
 *
 * The transformation is the implementation of an idempotent, functional translation
 */
public abstract class BaseCMMNTranslator<S> implements CMMNTranslator<S> {

	protected final CMMNObjectFactory factory;

	/**
	 * Creates a default CMMN translator
	 */
	public BaseCMMNTranslator() {
		this( new CMMNObjectFactory() );
	}

	/**
	 * Creates a translator using a customizable object factory
	 * @param factory   The CMMN AST object factory
	 */
	public BaseCMMNTranslator( final CMMNObjectFactory factory ) {
		this.factory = factory;
	}


}
