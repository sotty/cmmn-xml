
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 *         tCaseFileItem defines the type of element "caseFileItem".
 *       
 * 
 * <p>Java class for tCaseFileItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCaseFileItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement">
 *       &lt;sequence>
 *         &lt;element name="children" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tChildren" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="multiplicity" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}MultiplicityEnum" default="Unspecified" />
 *       &lt;attribute name="definitionRef" type="{http://www.w3.org/2001/XMLSchema}QName" />
 *       &lt;attribute name="sourceRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;attribute name="targetRefs" type="{http://www.w3.org/2001/XMLSchema}IDREFS" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCaseFileItem", propOrder = {
    "children"
})
public class TCaseFileItem
    extends TCmmnElement
{

    protected TChildren children;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "multiplicity")
    protected MultiplicityEnum multiplicity;
    @XmlAttribute(name = "definitionRef")
    protected QName definitionRef;
    @XmlAttribute(name = "sourceRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sourceRef;
    @XmlAttribute(name = "targetRefs")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> targetRefs;

    /**
     * Gets the value of the children property.
     * 
     * @return
     *     possible object is
     *     {@link TChildren }
     *     
     */
    public TChildren getChildren() {
        return children;
    }

    /**
     * Sets the value of the children property.
     * 
     * @param value
     *     allowed object is
     *     {@link TChildren }
     *     
     */
    public void setChildren(TChildren value) {
        this.children = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the multiplicity property.
     * 
     * @return
     *     possible object is
     *     {@link MultiplicityEnum }
     *     
     */
    public MultiplicityEnum getMultiplicity() {
        if (multiplicity == null) {
            return MultiplicityEnum.UNSPECIFIED;
        } else {
            return multiplicity;
        }
    }

    /**
     * Sets the value of the multiplicity property.
     * 
     * @param value
     *     allowed object is
     *     {@link MultiplicityEnum }
     *     
     */
    public void setMultiplicity(MultiplicityEnum value) {
        this.multiplicity = value;
    }

    /**
     * Gets the value of the definitionRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getDefinitionRef() {
        return definitionRef;
    }

    /**
     * Sets the value of the definitionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setDefinitionRef(QName value) {
        this.definitionRef = value;
    }

    /**
     * Gets the value of the sourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSourceRef() {
        return sourceRef;
    }

    /**
     * Sets the value of the sourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSourceRef(Object value) {
        this.sourceRef = value;
    }

    /**
     * Gets the value of the targetRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the targetRefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTargetRefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getTargetRefs() {
        if (targetRefs == null) {
            targetRefs = new ArrayList<Object>();
        }
        return this.targetRefs;
    }

    public TCaseFileItem withChildren(TChildren value) {
        setChildren(value);
        return this;
    }

    public TCaseFileItem withName(String value) {
        setName(value);
        return this;
    }

    public TCaseFileItem withMultiplicity(MultiplicityEnum value) {
        setMultiplicity(value);
        return this;
    }

    public TCaseFileItem withDefinitionRef(QName value) {
        setDefinitionRef(value);
        return this;
    }

    public TCaseFileItem withSourceRef(Object value) {
        setSourceRef(value);
        return this;
    }

    public TCaseFileItem withTargetRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getTargetRefs().add(value);
            }
        }
        return this;
    }

    public TCaseFileItem withTargetRefs(Collection<Object> values) {
        if (values!= null) {
            getTargetRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseFileItem withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TCaseFileItem withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseFileItem withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TCaseFileItem withId(String value) {
        setId(value);
        return this;
    }

}
