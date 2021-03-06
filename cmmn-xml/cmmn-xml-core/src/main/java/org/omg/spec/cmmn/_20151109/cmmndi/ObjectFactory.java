
package org.omg.spec.cmmn._20151109.cmmndi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import org.omg.spec.cmmn._20151109.di.DiagramElement;


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
    private final static QName _CMMNDiagram_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNDiagram");
    private final static QName _CMMNDiagramElement_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNDiagramElement");
    private final static QName _CMMNShape_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNShape");
    private final static QName _CMMNEdge_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNEdge");
    private final static QName _CMMNStyle_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNStyle");
    private final static QName _CMMNLabel_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/CMMNDI", "CMMNLabel");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.omg.spec.cmmn._20151109.cmmndi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CMMNDI }
     * 
     */
    public CMMNDI createCMMNDI() {
        return new CMMNDI();
    }

    /**
     * Create an instance of {@link CMMNDiagram }
     * 
     */
    public CMMNDiagram createCMMNDiagram() {
        return new CMMNDiagram();
    }

    /**
     * Create an instance of {@link CMMNShape }
     * 
     */
    public CMMNShape createCMMNShape() {
        return new CMMNShape();
    }

    /**
     * Create an instance of {@link CMMNEdge }
     * 
     */
    public CMMNEdge createCMMNEdge() {
        return new CMMNEdge();
    }

    /**
     * Create an instance of {@link CMMNStyle }
     * 
     */
    public CMMNStyle createCMMNStyle() {
        return new CMMNStyle();
    }

    /**
     * Create an instance of {@link CMMNLabel }
     * 
     */
    public CMMNLabel createCMMNLabel() {
        return new CMMNLabel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNDI }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNDI")
    public JAXBElement<CMMNDI> createCMMNDI(CMMNDI value) {
        return new JAXBElement<CMMNDI>(_CMMNDI_QNAME, CMMNDI.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNDiagram }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNDiagram")
    public JAXBElement<CMMNDiagram> createCMMNDiagram(CMMNDiagram value) {
        return new JAXBElement<CMMNDiagram>(_CMMNDiagram_QNAME, CMMNDiagram.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DiagramElement }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNDiagramElement")
    public JAXBElement<DiagramElement> createCMMNDiagramElement(DiagramElement value) {
        return new JAXBElement<DiagramElement>(_CMMNDiagramElement_QNAME, DiagramElement.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNShape }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNShape", substitutionHeadNamespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", substitutionHeadName = "CMMNDiagramElement")
    public JAXBElement<CMMNShape> createCMMNShape(CMMNShape value) {
        return new JAXBElement<CMMNShape>(_CMMNShape_QNAME, CMMNShape.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNEdge }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNEdge", substitutionHeadNamespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", substitutionHeadName = "CMMNDiagramElement")
    public JAXBElement<CMMNEdge> createCMMNEdge(CMMNEdge value) {
        return new JAXBElement<CMMNEdge>(_CMMNEdge_QNAME, CMMNEdge.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNStyle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNStyle", substitutionHeadNamespace = "http://www.omg.org/spec/CMMN/20151109/DI", substitutionHeadName = "Style")
    public JAXBElement<CMMNStyle> createCMMNStyle(CMMNStyle value) {
        return new JAXBElement<CMMNStyle>(_CMMNStyle_QNAME, CMMNStyle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CMMNLabel }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI", name = "CMMNLabel")
    public JAXBElement<CMMNLabel> createCMMNLabel(CMMNLabel value) {
        return new JAXBElement<CMMNLabel>(_CMMNLabel_QNAME, CMMNLabel.class, null, value);
    }

}
