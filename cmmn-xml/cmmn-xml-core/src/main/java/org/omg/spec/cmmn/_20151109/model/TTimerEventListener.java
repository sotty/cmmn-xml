
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tTimerEventListener complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tTimerEventListener"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tEventListener"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="timerExpression" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tExpression" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}timerStart" minOccurs="0"/&gt;
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
@XmlType(name = "tTimerEventListener", propOrder = {
    "timerExpression",
    "timerStart"
})
public class TTimerEventListener
    extends TEventListener
{

    protected TExpression timerExpression;
    @XmlElementRef(name = "timerStart", namespace = "http://www.omg.org/spec/CMMN/20151109/MODEL", type = JAXBElement.class, required = false)
    protected JAXBElement<? extends TStartTrigger> timerStart;

    /**
     * Gets the value of the timerExpression property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getTimerExpression() {
        return timerExpression;
    }

    /**
     * Sets the value of the timerExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setTimerExpression(TExpression value) {
        this.timerExpression = value;
    }

    public boolean isSetTimerExpression() {
        return (this.timerExpression!= null);
    }

    /**
     * 
     *                 timerStart can be used to trigger the timer after a PlanItem or CaseFileItem 
     *                 lifecycle state transition has occurred.
     *               
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link TStartTrigger }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPlanItemStartTrigger }{@code >}
     *     {@link JAXBElement }{@code <}{@link TCaseFileItemStartTrigger }{@code >}
     *     
     */
    public JAXBElement<? extends TStartTrigger> getTimerStart() {
        return timerStart;
    }

    /**
     * Sets the value of the timerStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link TStartTrigger }{@code >}
     *     {@link JAXBElement }{@code <}{@link TPlanItemStartTrigger }{@code >}
     *     {@link JAXBElement }{@code <}{@link TCaseFileItemStartTrigger }{@code >}
     *     
     */
    public void setTimerStart(JAXBElement<? extends TStartTrigger> value) {
        this.timerStart = value;
    }

    public boolean isSetTimerStart() {
        return (this.timerStart!= null);
    }

    public TTimerEventListener withTimerExpression(TExpression value) {
        setTimerExpression(value);
        return this;
    }

    public TTimerEventListener withTimerStart(JAXBElement<? extends TStartTrigger> value) {
        setTimerStart(value);
        return this;
    }

    @Override
    public TTimerEventListener withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public TTimerEventListener withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TTimerEventListener withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TTimerEventListener withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TTimerEventListener withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TTimerEventListener withId(String value) {
        setId(value);
        return this;
    }

}
