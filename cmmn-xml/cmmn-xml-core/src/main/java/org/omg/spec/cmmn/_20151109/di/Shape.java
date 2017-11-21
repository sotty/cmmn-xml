
package org.omg.spec.cmmn._20151109.di;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.omg.spec.cmmn._20151109.dc.Bounds;


/**
 * <p>Java class for Shape complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Shape">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}DiagramElement">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/DC}Bounds" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Shape", propOrder = {
    "bounds"
})
public abstract class Shape
    extends DiagramElement
{

    @XmlElement(name = "Bounds", namespace = "http://www.omg.org/spec/CMMN/20151109/DC")
    protected Bounds bounds;

    /**
     * the optional bounds of the shape relative to the origin of its nesting plane.
     * 
     * @return
     *     possible object is
     *     {@link Bounds }
     *     
     */
    public Bounds getBounds() {
        return bounds;
    }

    /**
     * Sets the value of the bounds property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bounds }
     *     
     */
    public void setBounds(Bounds value) {
        this.bounds = value;
    }

    public boolean isSetBounds() {
        return (this.bounds!= null);
    }

    public Shape withBounds(Bounds value) {
        setBounds(value);
        return this;
    }

    @Override
    public Shape withExtension(DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    @Override
    public Shape withStyle(Style value) {
        setStyle(value);
        return this;
    }

    @Override
    public Shape withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    @Override
    public Shape withId(String value) {
        setId(value);
        return this;
    }

}
