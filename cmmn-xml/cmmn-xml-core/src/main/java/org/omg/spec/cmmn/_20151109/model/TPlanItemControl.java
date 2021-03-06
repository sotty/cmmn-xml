
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tPlanItemcontrol defines the type of element "planItemControl".
 *       
 * 
 * <p>Java class for tPlanItemControl complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanItemControl"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}repetitionRule" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}requiredRule" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}manualActivationRule" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPlanItemControl", propOrder = {
    "repetitionRule",
    "requiredRule",
    "manualActivationRule"
})
public class TPlanItemControl
    extends TCmmnElement
{

    protected TRepetitionRule repetitionRule;
    protected TRequiredRule requiredRule;
    protected TManualActivationRule manualActivationRule;

    /**
     * Gets the value of the repetitionRule property.
     * 
     * @return
     *     possible object is
     *     {@link TRepetitionRule }
     *     
     */
    public TRepetitionRule getRepetitionRule() {
        return repetitionRule;
    }

    /**
     * Sets the value of the repetitionRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRepetitionRule }
     *     
     */
    public void setRepetitionRule(TRepetitionRule value) {
        this.repetitionRule = value;
    }

    public boolean isSetRepetitionRule() {
        return (this.repetitionRule!= null);
    }

    /**
     * Gets the value of the requiredRule property.
     * 
     * @return
     *     possible object is
     *     {@link TRequiredRule }
     *     
     */
    public TRequiredRule getRequiredRule() {
        return requiredRule;
    }

    /**
     * Sets the value of the requiredRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link TRequiredRule }
     *     
     */
    public void setRequiredRule(TRequiredRule value) {
        this.requiredRule = value;
    }

    public boolean isSetRequiredRule() {
        return (this.requiredRule!= null);
    }

    /**
     * Gets the value of the manualActivationRule property.
     * 
     * @return
     *     possible object is
     *     {@link TManualActivationRule }
     *     
     */
    public TManualActivationRule getManualActivationRule() {
        return manualActivationRule;
    }

    /**
     * Sets the value of the manualActivationRule property.
     * 
     * @param value
     *     allowed object is
     *     {@link TManualActivationRule }
     *     
     */
    public void setManualActivationRule(TManualActivationRule value) {
        this.manualActivationRule = value;
    }

    public boolean isSetManualActivationRule() {
        return (this.manualActivationRule!= null);
    }

    public TPlanItemControl withRepetitionRule(TRepetitionRule value) {
        setRepetitionRule(value);
        return this;
    }

    public TPlanItemControl withRequiredRule(TRequiredRule value) {
        setRequiredRule(value);
        return this;
    }

    public TPlanItemControl withManualActivationRule(TManualActivationRule value) {
        setManualActivationRule(value);
        return this;
    }

    @Override
    public TPlanItemControl withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanItemControl withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanItemControl withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanItemControl withId(String value) {
        setId(value);
        return this;
    }

}
