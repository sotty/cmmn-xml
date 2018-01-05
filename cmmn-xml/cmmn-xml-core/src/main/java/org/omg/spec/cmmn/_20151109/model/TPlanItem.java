
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


/**
 * <p>Java class for tPlanItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanItem"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemControl" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanItemControl" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}entryCriterion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}exitCriterion" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="definitionRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPlanItem", propOrder = {
    "itemControl",
    "entryCriterion",
    "exitCriterion"
})
public class TPlanItem
    extends TCmmnElement
{

    protected TPlanItemControl itemControl;
    protected List<TEntryCriterion> entryCriterion;
    protected List<TExitCriterion> exitCriterion;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "definitionRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object definitionRef;

    /**
     * Gets the value of the itemControl property.
     * 
     * @return
     *     possible object is
     *     {@link TPlanItemControl }
     *     
     */
    public TPlanItemControl getItemControl() {
        return itemControl;
    }

    /**
     * Sets the value of the itemControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPlanItemControl }
     *     
     */
    public void setItemControl(TPlanItemControl value) {
        this.itemControl = value;
    }

    public boolean isSetItemControl() {
        return (this.itemControl!= null);
    }

    /**
     * Gets the value of the entryCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEntryCriterion }
     * 
     * 
     */
    public List<TEntryCriterion> getEntryCriterion() {
        if (entryCriterion == null) {
            entryCriterion = new ArrayList<TEntryCriterion>();
        }
        return this.entryCriterion;
    }

    public boolean isSetEntryCriterion() {
        return ((this.entryCriterion!= null)&&(!this.entryCriterion.isEmpty()));
    }

    public void unsetEntryCriterion() {
        this.entryCriterion = null;
    }

    /**
     * Gets the value of the exitCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exitCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExitCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TExitCriterion }
     * 
     * 
     */
    public List<TExitCriterion> getExitCriterion() {
        if (exitCriterion == null) {
            exitCriterion = new ArrayList<TExitCriterion>();
        }
        return this.exitCriterion;
    }

    public boolean isSetExitCriterion() {
        return ((this.exitCriterion!= null)&&(!this.exitCriterion.isEmpty()));
    }

    public void unsetExitCriterion() {
        this.exitCriterion = null;
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

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the definitionRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDefinitionRef() {
        return definitionRef;
    }

    /**
     * Sets the value of the definitionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDefinitionRef(Object value) {
        this.definitionRef = value;
    }

    public boolean isSetDefinitionRef() {
        return (this.definitionRef!= null);
    }

    public TPlanItem withItemControl(TPlanItemControl value) {
        setItemControl(value);
        return this;
    }

    public TPlanItem withEntryCriterion(TEntryCriterion... values) {
        if (values!= null) {
            for (TEntryCriterion value: values) {
                getEntryCriterion().add(value);
            }
        }
        return this;
    }

    public TPlanItem withEntryCriterion(Collection<TEntryCriterion> values) {
        if (values!= null) {
            getEntryCriterion().addAll(values);
        }
        return this;
    }

    public TPlanItem withExitCriterion(TExitCriterion... values) {
        if (values!= null) {
            for (TExitCriterion value: values) {
                getExitCriterion().add(value);
            }
        }
        return this;
    }

    public TPlanItem withExitCriterion(Collection<TExitCriterion> values) {
        if (values!= null) {
            getExitCriterion().addAll(values);
        }
        return this;
    }

    public TPlanItem withName(String value) {
        setName(value);
        return this;
    }

    public TPlanItem withDefinitionRef(Object value) {
        setDefinitionRef(value);
        return this;
    }

    @Override
    public TPlanItem withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanItem withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanItem withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanItem withId(String value) {
        setId(value);
        return this;
    }

}
