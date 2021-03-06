
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 *         tDecision defines the type of element "decision"
 *       
 * 
 * <p>Java class for tDecision complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDecision"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="input" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tDecisionParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="output" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tDecisionParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="externalRef" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="implementationType" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://www.omg.org/spec/CMMN/DecisionType/Unspecified" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDecision", propOrder = {
    "input",
    "output"
})
public class TDecision
    extends TCmmnElement
{

    protected List<TDecisionParameter> input;
    protected List<TDecisionParameter> output;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "externalRef")
    protected QName externalRef;
    @XmlAttribute(name = "implementationType")
    @XmlSchemaType(name = "anyURI")
    protected String implementationType;

    /**
     * Gets the value of the input property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the input property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDecisionParameter }
     * 
     * 
     */
    public List<TDecisionParameter> getInput() {
        if (input == null) {
            input = new ArrayList<TDecisionParameter>();
        }
        return this.input;
    }

    public boolean isSetInput() {
        return ((this.input!= null)&&(!this.input.isEmpty()));
    }

    public void unsetInput() {
        this.input = null;
    }

    /**
     * Gets the value of the output property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the output property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDecisionParameter }
     * 
     * 
     */
    public List<TDecisionParameter> getOutput() {
        if (output == null) {
            output = new ArrayList<TDecisionParameter>();
        }
        return this.output;
    }

    public boolean isSetOutput() {
        return ((this.output!= null)&&(!this.output.isEmpty()));
    }

    public void unsetOutput() {
        this.output = null;
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
     * Gets the value of the externalRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getExternalRef() {
        return externalRef;
    }

    /**
     * Sets the value of the externalRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setExternalRef(QName value) {
        this.externalRef = value;
    }

    public boolean isSetExternalRef() {
        return (this.externalRef!= null);
    }

    /**
     * Gets the value of the implementationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImplementationType() {
        if (implementationType == null) {
            return "http://www.omg.org/spec/CMMN/DecisionType/Unspecified";
        } else {
            return implementationType;
        }
    }

    /**
     * Sets the value of the implementationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImplementationType(String value) {
        this.implementationType = value;
    }

    public boolean isSetImplementationType() {
        return (this.implementationType!= null);
    }

    public TDecision withInput(TDecisionParameter... values) {
        if (values!= null) {
            for (TDecisionParameter value: values) {
                getInput().add(value);
            }
        }
        return this;
    }

    public TDecision withInput(Collection<TDecisionParameter> values) {
        if (values!= null) {
            getInput().addAll(values);
        }
        return this;
    }

    public TDecision withOutput(TDecisionParameter... values) {
        if (values!= null) {
            for (TDecisionParameter value: values) {
                getOutput().add(value);
            }
        }
        return this;
    }

    public TDecision withOutput(Collection<TDecisionParameter> values) {
        if (values!= null) {
            getOutput().addAll(values);
        }
        return this;
    }

    public TDecision withName(String value) {
        setName(value);
        return this;
    }

    public TDecision withExternalRef(QName value) {
        setExternalRef(value);
        return this;
    }

    public TDecision withImplementationType(String value) {
        setImplementationType(value);
        return this;
    }

    @Override
    public TDecision withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TDecision withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TDecision withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TDecision withId(String value) {
        setId(value);
        return this;
    }

}
