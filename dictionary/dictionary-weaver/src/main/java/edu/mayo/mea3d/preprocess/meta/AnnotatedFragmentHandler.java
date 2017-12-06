package edu.mayo.mea3d.preprocess.meta;

import org.w3c.dom.Element;

import java.util.Collections;
import java.util.List;

import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_ATTR_GX;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_EL_MODEL_EXT;
import static edu.mayo.mea3d.preprocess.meta.DictionaryConfig.p_METADATA_NS;

public class AnnotatedFragmentHandler extends BaseAnnotationHandler {

	private final String NS;
	private final String ATTR;
	private DictionaryConfig config;

	public AnnotatedFragmentHandler( DictionaryConfig config ) {
		this.NS = config.get( p_METADATA_NS );
		this.ATTR = config.get( p_ATTR_GX );
		this.config = config;
	}

	@Override
	public List<String> getDictionaryIDs( Element el ) {
		return el.hasAttributeNS( NS, ATTR )
				? Collections.singletonList( el.getAttributeNS( NS, ATTR ) )
				: Collections.emptyList();
	}

	@Override
	public void replaceProprietaryElement( Element oldEl, Element newEl ) {
		oldEl.removeAttributeNS( NS, ATTR );
		oldEl.insertBefore( newEl, oldEl.getFirstChild() );
	}

	@Override
	public Element wrap( Element element ) {
		Element ext = config.modelExt( element.getOwnerDocument(), config.get( p_EL_MODEL_EXT ) );
		ext.appendChild( element );
		return ext;
	}

	@Override
	public String getAnnotationName( Element el ) {
		return MetadataAttributeNameMapper.PROP_CONCEPT;
	}
}
