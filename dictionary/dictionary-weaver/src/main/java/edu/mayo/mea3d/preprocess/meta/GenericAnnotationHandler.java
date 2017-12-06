package edu.mayo.mea3d.preprocess.meta;

import org.w3c.dom.Element;

import java.util.List;

public class GenericAnnotationHandler extends BaseAnnotationHandler {

	@Override
	public List<String> getDictionaryIDs( Element el ) {
		throw new UnsupportedOperationException( "Defensive programming: a new type of decorated attribute has been found" );
	}

	@Override
	public void replaceProprietaryElement( Element original, Element replace ) {
		throw new UnsupportedOperationException( "Defensive programming: a new type of decorated attribute has been found" );
	}

	@Override
	public Element wrap( Element element ) {
		throw new UnsupportedOperationException( "Defensive programming: a new type of decorated attribute has been found" );
	}
}
