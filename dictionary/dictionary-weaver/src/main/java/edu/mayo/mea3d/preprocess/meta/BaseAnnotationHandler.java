package edu.mayo.mea3d.preprocess.meta;

import org.w3c.dom.Element;

import java.util.List;

public abstract class BaseAnnotationHandler {

	public abstract List<String> getDictionaryIDs( Element el );

	public abstract void replaceProprietaryElement( Element original, Element replace );

	public abstract Element wrap( Element element );

	public String getAnnotationName( Element el ) {
		return MetadataAttributeNameMapper.map( el.getAttribute( "name" ) );
	}
}
