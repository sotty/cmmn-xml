
package org.omg.spec.cmmn._20151109.di;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNStyle;
import org.w3c.dom.Element;


/**
 * DiagramElement is the abstract super type of all elements in diagrams, including diagrams themselves. When contained in a diagram, diagram elements are laid out relative to the diagram's origin.
 * 
 * <p>Java class for DiagramElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DiagramElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="extension" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/DI}Style" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sharedStyle" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DiagramElement", propOrder = {
    "extension",
    "style"
})
@XmlSeeAlso({
    Edge.class,
    Diagram.class,
    Shape.class
})
public abstract class DiagramElement {

    protected DiagramElement.Extension extension;
    @XmlElementRef(name = "Style", namespace = "http://www.omg.org/spec/CMMN/20151109/DI", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends Style> style;
    @XmlAttribute(name = "sharedStyle")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sharedStyle;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the extension property.
     * 
     * @return
     *     possible object is
     *     {@link DiagramElement.Extension }
     *     
     */
    public DiagramElement.Extension getExtension() {
        return extension;
    }

    /**
     * Sets the value of the extension property.
     * 
     * @param value
     *     allowed object is
     *     {@link DiagramElement.Extension }
     *     
     */
    public void setExtension(DiagramElement.Extension value) {
        this.extension = value;
    }

    public boolean isSetExtension() {
        return (this.extension!= null);
    }

    /**
     * an optional locally-owned style for this diagram element.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CMMNStyle }{@code >}
     *     {@link JAXBElement }{@code <}{@link Style }{@code >}
     *     
     */
    public JAXBElement<? extends Style> getStyle() {
        return style;
    }

    /**
     * Sets the value of the style property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CMMNStyle }{@code >}
     *     {@link JAXBElement }{@code <}{@link Style }{@code >}
     *     
     */
    public void setStyle(JAXBElement<? extends Style> value) {
        this.style = value;
    }

    public boolean isSetStyle() {
        return (this.style!= null);
    }

    /**
     * Gets the value of the sharedStyle property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSharedStyle() {
        return sharedStyle;
    }

    /**
     * Sets the value of the sharedStyle property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSharedStyle(Object value) {
        this.sharedStyle = value;
    }

    public boolean isSetSharedStyle() {
        return (this.sharedStyle!= null);
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    public boolean isSetId() {
        return (this.id!= null);
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public DiagramElement withExtension(DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    public DiagramElement withStyle(JAXBElement<? extends Style> value) {
        setStyle(value);
        return this;
    }

    public DiagramElement withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    public DiagramElement withId(String value) {
        setId(value);
        return this;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class Extension {

        @XmlAnyElement(lax = true)
        protected List<Object> any;

        /**
         * Gets the value of the any property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the any property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAny().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Object }
         * {@link Element }
         * 
         * 
         */
        public List<Object> getAny() {
            if (any == null) {
                any = new ArrayList<Object>();
            }
            return this.any;
        }

        public boolean isSetAny() {
            return ((this.any!= null)&&(!this.any.isEmpty()));
        }

        public void unsetAny() {
            this.any = null;
        }

        public DiagramElement.Extension withAny(Object... values) {
            if (values!= null) {
                for (Object value: values) {
                    getAny().add(value);
                }
            }
            return this;
        }

        public DiagramElement.Extension withAny(Collection<Object> values) {
            if (values!= null) {
                getAny().addAll(values);
            }
            return this;
        }

    }

}
