
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPlanItemOnPart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanItemOnPart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tOnPart"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="standardEvent" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}PlanItemTransition" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sourceRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="exitCriterionRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPlanItemOnPart", propOrder = {
    "standardEvent"
})
public class TPlanItemOnPart
    extends TOnPart
{

    @XmlSchemaType(name = "string")
    protected PlanItemTransition standardEvent;
    @XmlAttribute(name = "sourceRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sourceRef;
    @XmlAttribute(name = "exitCriterionRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object exitCriterionRef;

    /**
     * Gets the value of the standardEvent property.
     * 
     * @return
     *     possible object is
     *     {@link PlanItemTransition }
     *     
     */
    public PlanItemTransition getStandardEvent() {
        return standardEvent;
    }

    /**
     * Sets the value of the standardEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlanItemTransition }
     *     
     */
    public void setStandardEvent(PlanItemTransition value) {
        this.standardEvent = value;
    }

    public boolean isSetStandardEvent() {
        return (this.standardEvent!= null);
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

    public boolean isSetSourceRef() {
        return (this.sourceRef!= null);
    }

    /**
     * Gets the value of the exitCriterionRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getExitCriterionRef() {
        return exitCriterionRef;
    }

    /**
     * Sets the value of the exitCriterionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setExitCriterionRef(Object value) {
        this.exitCriterionRef = value;
    }

    public boolean isSetExitCriterionRef() {
        return (this.exitCriterionRef!= null);
    }

    public TPlanItemOnPart withStandardEvent(PlanItemTransition value) {
        setStandardEvent(value);
        return this;
    }

    public TPlanItemOnPart withSourceRef(Object value) {
        setSourceRef(value);
        return this;
    }

    public TPlanItemOnPart withExitCriterionRef(Object value) {
        setExitCriterionRef(value);
        return this;
    }

    @Override
    public TPlanItemOnPart withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TPlanItemOnPart withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanItemOnPart withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanItemOnPart withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanItemOnPart withId(String value) {
        setId(value);
        return this;
    }

}
