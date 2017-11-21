
package org.omg.spec.cmmn._20151109.cmmndi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.omg.spec.cmmn._20151109.cmmndi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CMMNDI_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNDI");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.omg.spec.cmmn._20151109.cmmndi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNDI")
    public JAXBElement<CMMNDI> createCMMNDI(CMMNDI value) {
        return new JAXBElement<CMMNDI>(_CMMNDI_QNAME, CMMNDI.class, null, value);
    }

}
