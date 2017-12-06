package org.omg.spec.CMMN.xml.v11;

import com.sun.xml.bind.marshaller.NamespacePrefixMapper;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import static org.omg.spec.CMMN.xml.v11.OMGConstants.NAME_OMG_CMMN_CMMNDI_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NAME_OMG_CMMN_DC_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NAME_OMG_CMMN_DI_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NAME_OMG_CMMN_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NS_OMG_CMMN_CMMNDI_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NS_OMG_CMMN_DC_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NS_OMG_CMMN_DI_v11;
import static org.omg.spec.CMMN.xml.v11.OMGConstants.NS_OMG_CMMN_v11;

/**
 * Implementation of {@link NamespacePrefixMapper} that maps the schema
 * namespaces more to readable names. Used by the jaxb marshaller. Requires
 * setting the property "com.sun.xml.bind.namespacePrefixMapper" to an instance
 * of this class.
 * <p>
 * Requires dependency on JAXB implementation jars
 * </p>
 */
public class NameSpaceMapper extends NamespacePrefixMapper {
 
	private final Map<String, String> namespaceMap = new HashMap<>();
 
	/**
	 * Create mappings.
	 */
	public NameSpaceMapper() {
		namespaceMap.put( NS_OMG_CMMN_DI_v11, NAME_OMG_CMMN_DI_v11 );
		namespaceMap.put( NS_OMG_CMMN_DC_v11, NAME_OMG_CMMN_DC_v11 );
		namespaceMap.put( NS_OMG_CMMN_v11, NAME_OMG_CMMN_v11 );
		namespaceMap.put( NS_OMG_CMMN_CMMNDI_v11, NAME_OMG_CMMN_CMMNDI_v11 );
		namespaceMap.put( XMLConstants.XML_NS_URI, XMLConstants.XMLNS_ATTRIBUTE );
		namespaceMap.put( "http://www.signavio.com/schema/cmmn/1.1/", "sigExt" );
	}


	@Override
	public String[] getPreDeclaredNamespaceUris() {
		return namespaceMap.keySet().toArray(new String[0]);
	}
	
	/* (non-Javadoc)
	 * Returning null when not found based on spec.
	 * @see com.sun.xml.bind.marshaller.NamespacePrefixMapper#getPreferredPrefix(java.lang.String, java.lang.String, boolean)
	 */
	@Override
	public String getPreferredPrefix( final String namespaceUri, final String suggestion, final boolean requirePrefix) {
		return namespaceMap.getOrDefault(namespaceUri, suggestion);
	}
	
	public void putNewNamespaceMapping(final String prefix, final String namespace) {
		namespaceMap.put(namespace, prefix);
	}

	public NamespaceContext getNamespaceContext() {
		return new NamespaceContext() {
			@Override
			public String getNamespaceURI( final String prefix ) {
				Optional<Map.Entry<String, String>> entry = namespaceMap.entrySet().stream()
				                                                        .filter(e -> e.getValue().equals(prefix)).findFirst();
				return entry.map( Map.Entry::getKey ).orElse( "" );
			}

			@Override
			public String getPrefix( final String namespaceURI ) {
				return namespaceMap.get( namespaceURI );
			}

			@Override
			public Iterator getPrefixes( final String namespaceURI ) {
				return namespaceMap.values().iterator();
			}
		};

	}
}