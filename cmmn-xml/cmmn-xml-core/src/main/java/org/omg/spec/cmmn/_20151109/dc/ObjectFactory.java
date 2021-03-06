
package org.omg.spec.cmmn._20151109.dc;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.omg.spec.cmmn._20151109.dc package. 
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

    private final static QName _Color_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/DC", "Color");
    private final static QName _Point_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/DC", "Point");
    private final static QName _Bounds_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/DC", "Bounds");
    private final static QName _Dimension_QNAME = new QName("http://www.omg.org/spec/CMMN/20151109/DC", "Dimension");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.omg.spec.cmmn._20151109.dc
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Color }
     * 
     */
    public Color createColor() {
        return new Color();
    }

    /**
     * Create an instance of {@link Point }
     * 
     */
    public Point createPoint() {
        return new Point();
    }

    /**
     * Create an instance of {@link Bounds }
     * 
     */
    public Bounds createBounds() {
        return new Bounds();
    }

    /**
     * Create an instance of {@link Dimension }
     * 
     */
    public Dimension createDimension() {
        return new Dimension();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Color }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/DC", name = "Color")
    public JAXBElement<Color> createColor(Color value) {
        return new JAXBElement<Color>(_Color_QNAME, Color.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Point }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/DC", name = "Point")
    public JAXBElement<Point> createPoint(Point value) {
        return new JAXBElement<Point>(_Point_QNAME, Point.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Bounds }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/DC", name = "Bounds")
    public JAXBElement<Bounds> createBounds(Bounds value) {
        return new JAXBElement<Bounds>(_Bounds_QNAME, Bounds.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Dimension }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.omg.org/spec/CMMN/20151109/DC", name = "Dimension")
    public JAXBElement<Dimension> createDimension(Dimension value) {
        return new JAXBElement<Dimension>(_Dimension_QNAME, Dimension.class, null, value);
    }

}
