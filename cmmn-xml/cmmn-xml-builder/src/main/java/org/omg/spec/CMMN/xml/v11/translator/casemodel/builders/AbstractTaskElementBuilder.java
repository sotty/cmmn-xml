package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.cmmn._20151109.model.TTask;

public abstract class AbstractTaskElementBuilder<S,T extends TTask> extends PlanItemDefinitionElementBuilder<S,T> {

	@Override
	public S link( final S s ) {
		connectParent( element, isDiscretionary( s ), getBuildStack().peek() );
		return super.link( s );
	}

}
