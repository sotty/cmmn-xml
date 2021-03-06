
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;


/**
 * 
 *         tCmmnElement is the base type for ALL CMMN complex types except tExpression.
 *       
 * 
 * <p>Java class for tCmmnElement complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCmmnElement"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}documentation" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}extensionElements" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
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
@XmlType(name = "tCmmnElement", propOrder = {
    "documentation",
    "extensionElements"
})
@XmlSeeAlso({
    TRelationship.class,
    TArtifact.class,
    TCase.class,
    TRole.class,
    TPlanItemControl.class,
    TRepetitionRule.class,
    TRequiredRule.class,
    TManualActivationRule.class,
    TCaseFile.class,
    TCaseFileItem.class,
    TCaseFileItemDefinition.class,
    TProperty.class,
    TParameter.class,
    TProcess.class,
    TDecision.class,
    TParameterMapping.class,
    TStartTrigger.class,
    TSentry.class,
    TOnPart.class,
    TIfPart.class,
    TPlanItemDefinition.class,
    TPlanItem.class,
    TTableItem.class,
    TApplicabilityRule.class,
    TCaseRoles.class,
    TChildren.class,
    TCriterion.class
})
public abstract class TCmmnElement {

    protected List<TDocumentation> documentation;
    protected TExtensionElements extensionElements;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the documentation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the documentation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocumentation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDocumentation }
     * 
     * 
     */
    public List<TDocumentation> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<TDocumentation>();
        }
        return this.documentation;
    }

    public boolean isSetDocumentation() {
        return ((this.documentation!= null)&&(!this.documentation.isEmpty()));
    }

    public void unsetDocumentation() {
        this.documentation = null;
    }

    /**
     * Gets the value of the extensionElements property.
     * 
     * @return
     *     possible object is
     *     {@link TExtensionElements }
     *     
     */
    public TExtensionElements getExtensionElements() {
        return extensionElements;
    }

    /**
     * Sets the value of the extensionElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtensionElements }
     *     
     */
    public void setExtensionElements(TExtensionElements value) {
        this.extensionElements = value;
    }

    public boolean isSetExtensionElements() {
        return (this.extensionElements!= null);
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

    public TCmmnElement withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    public TCmmnElement withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    public TCmmnElement withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    public TCmmnElement withId(String value) {
        setId(value);
        return this;
    }

}
