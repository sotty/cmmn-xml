
package org.omg.spec.cmmn._20151109.di;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.omg.spec.cmmn._20151109.di package. 
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

    private final static QName _Style_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/DI", "Style");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.omg.spec.cmmn._20151109.di
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link org.omg.spec.cmmn._20151109.di.DiagramElement.Extension }
     * 
     */
    public org.omg.spec.cmmn._20151109.di.DiagramElement.Extension createDiagramElementExtension() {
        return new org.omg.spec.cmmn._20151109.di.DiagramElement.Extension();
    }

    /**
     * Create an instance of {@link Style.Extension }
     * 
     */
    public Style.Extension createStyleExtension() {
        return new Style.Extension();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Style }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/DI", name = "Style")
    public JAXBElement<Style> createStyle(Style value) {
        return new JAXBElement<Style>(_Style_QNAME, Style.class, null, value);
    }

}
