
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tRequiredRule defines the type of element "requiredRule".
 *       
 * 
 * <p>Java class for tRequiredRule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tRequiredRule"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="condition" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tExpression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="contextRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tRequiredRule", propOrder = {
    "condition"
})
public class TRequiredRule
    extends TCmmnElement
{

    protected TExpression condition;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "contextRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object contextRef;

    /**
     * Gets the value of the condition property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getCondition() {
        return condition;
    }

    /**
     * Sets the value of the condition property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setCondition(TExpression value) {
        this.condition = value;
    }

    public boolean isSetCondition() {
        return (this.condition!= null);
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
     * Gets the value of the contextRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getContextRef() {
        return contextRef;
    }

    /**
     * Sets the value of the contextRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setContextRef(Object value) {
        this.contextRef = value;
    }

    public boolean isSetContextRef() {
        return (this.contextRef!= null);
    }

    public TRequiredRule withCondition(TExpression value) {
        setCondition(value);
        return this;
    }

    public TRequiredRule withName(String value) {
        setName(value);
        return this;
    }

    public TRequiredRule withContextRef(Object value) {
        setContextRef(value);
        return this;
    }

    @Override
    public TRequiredRule withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TRequiredRule withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TRequiredRule withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TRequiredRule withId(String value) {
        setId(value);
        return this;
    }

}
