
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 *         tDecisionTask defines the type of element "decision"
 *       
 * 
 * <p>Java class for tDecisionTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecisionTask"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tTask"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}parameterMapping" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="decisionRefExpression" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tExpression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="decisionRef" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDecisionTask", propOrder = {
    "parameterMapping",
    "decisionRefExpression"
})
public class TDecisionTask
    extends TTask
{

    protected List<TParameterMapping> parameterMapping;
    protected TExpression decisionRefExpression;
    @XmlAttribute(name = "decisionRef")
    protected QName decisionRef;

    /**
     * Gets the value of the parameterMapping property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the parameterMapping property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParameterMapping().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TParameterMapping }
     * 
     * 
     */
    public List<TParameterMapping> getParameterMapping() {
        if (parameterMapping == null) {
            parameterMapping = new ArrayList<TParameterMapping>();
        }
        return this.parameterMapping;
    }

    public boolean isSetParameterMapping() {
        return ((this.parameterMapping!= null)&&(!this.parameterMapping.isEmpty()));
    }

    public void unsetParameterMapping() {
        this.parameterMapping = null;
    }

    /**
     * Gets the value of the decisionRefExpression property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getDecisionRefExpression() {
        return decisionRefExpression;
    }

    /**
     * Sets the value of the decisionRefExpression property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setDecisionRefExpression(TExpression value) {
        this.decisionRefExpression = value;
    }

    public boolean isSetDecisionRefExpression() {
        return (this.decisionRefExpression!= null);
    }

    /**
     * Gets the value of the decisionRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getDecisionRef() {
        return decisionRef;
    }

    /**
     * Sets the value of the decisionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setDecisionRef(QName value) {
        this.decisionRef = value;
    }

    public boolean isSetDecisionRef() {
        return (this.decisionRef!= null);
    }

    public TDecisionTask withParameterMapping(TParameterMapping... values) {
        if (values!= null) {
            for (TParameterMapping value: values) {
                getParameterMapping().add(value);
            }
        }
        return this;
    }

    public TDecisionTask withParameterMapping(Collection<TParameterMapping> values) {
        if (values!= null) {
            getParameterMapping().addAll(values);
        }
        return this;
    }

    public TDecisionTask withDecisionRefExpression(TExpression value) {
        setDecisionRefExpression(value);
        return this;
    }

    public TDecisionTask withDecisionRef(QName value) {
        setDecisionRef(value);
        return this;
    }

    @Override
    public TDecisionTask withInput(TCaseParameter... values) {
        if (values!= null) {
            for (TCaseParameter value: values) {
                getInput().add(value);
            }
        }
        return this;
    }

    @Override
    public TDecisionTask withInput(Collection<TCaseParameter> values) {
        if (values!= null) {
            getInput().addAll(values);
        }
        return this;
    }

    @Override
    public TDecisionTask withOutput(TCaseParameter... values) {
        if (values!= null) {
            for (TCaseParameter value: values) {
                getOutput().add(value);
            }
        }
        return this;
    }

    @Override
    public TDecisionTask withOutput(Collection<TCaseParameter> values) {
        if (values!= null) {
            getOutput().addAll(values);
        }
        return this;
    }

    @Override
    public TDecisionTask withIsBlocking(boolean value) {
        setIsBlocking(value);
        return this;
    }

    @Override
    public TDecisionTask withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public TDecisionTask withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TDecisionTask withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TDecisionTask withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TDecisionTask withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TDecisionTask withId(String value) {
        setId(value);
        return this;
    }

}
