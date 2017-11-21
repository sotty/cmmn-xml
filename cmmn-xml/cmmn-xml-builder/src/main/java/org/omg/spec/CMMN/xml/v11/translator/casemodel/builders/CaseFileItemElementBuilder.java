package org.omg.spec.CMMN.xml.v11.translator.casemodel.builders;


import org.omg.spec.CMMN.xml.v11.CMMNElements;
import org.omg.spec.cmmn._20151109.model.MultiplicityEnum;
import org.omg.spec.cmmn._20151109.model.TCase;
import org.omg.spec.cmmn._20151109.model.TCaseFileItem;
import org.omg.spec.cmmn._20151109.model.TCaseFileItemDefinition;

import javax.xml.namespace.QName;
import java.util.function.BiFunction;

public class CaseFileItemElementBuilder<S> extends AbstractLinkingElementBuilder<S,TCaseFileItem> {

	@Override
	public S init( final S s ) {
		element = getFactory().createTCaseFileItem()
			.withMultiplicity( MultiplicityEnum.UNSPECIFIED );
		return s;
	}

	@Override
	protected BiFunction<S, TCaseFileItem, TCaseFileItem> getDecoratorFunction() {
		return getDecorator()::decorateCaseFileItem;
	}

	@Override
	public S link( final S s ) {
		connectCaseFileItem( s );
		return super.link( s );
	}

	private void connectCaseFileItem( final S s ) {
		TCaseFileItemDefinition def = buildElement( CMMNElements.CASE_FILE_ITEM_DEF, s, TCaseFileItemDefinition.class )
				.orElseThrow( UnsupportedOperationException::new )
				.withId( "def_" + element.getId() );

		TCase parentCase = findParentCase();
		if ( parentCase.getCaseFileModel() == null ) {
			parentCase.withCaseFileModel( getFactory().createTCaseFile() );
		}
		parentCase.getCaseFileModel().withCaseFileItem(
				element.withDefinitionRef( new QName( def.getId() ) )
		                                              );
	}
}
