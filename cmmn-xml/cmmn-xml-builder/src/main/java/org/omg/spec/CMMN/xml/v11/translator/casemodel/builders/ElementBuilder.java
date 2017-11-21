package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.CMMN.xml.v11.translator.SourceBuilder;
import org.omg.spec.CMMN.xml.v11.translator.casemodel.CMMNCaseBuilder;

public interface ElementBuilder<S,T> extends SourceBuilder<S,T> {

	ElementBuilder<S,T> withCaseBuilder( CMMNCaseBuilder<?,S> cb );

}
