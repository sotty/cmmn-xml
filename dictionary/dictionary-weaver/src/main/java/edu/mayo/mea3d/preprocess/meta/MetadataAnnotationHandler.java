package edu.mayo.mea3d.preprocess.meta;


import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;

import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.DCT_PATTERN;

/**
 * Rewrites dictionary explicitly
 */
public class MetadataAnnotationHandler extends BaseAnnotationHandler {

	public MetadataAnnotationHandler( DictionaryConfig config ) {
	}

	@Override
	public List<String> getDictionaryIDs( Element el ) {
		List<String> dictReferences = new LinkedList<>();

		Matcher m = DCT_PATTERN.matcher( el.getAttribute( "value" ) );
		while ( m.find() ) {
			dictReferences.add( m.group( 2 ) );
		}
		return dictReferences;
	}

	@Override
	public void replaceProprietaryElement( Element oldEl, Element newEl ) {
		Node parent = oldEl.getParentNode();
		parent.replaceChild( newEl, oldEl );
	}

	@Override
	public Element wrap( Element element ) {
		return element;
	}
}
