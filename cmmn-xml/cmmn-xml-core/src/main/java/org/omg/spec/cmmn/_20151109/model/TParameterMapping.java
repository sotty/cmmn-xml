
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tParameterMapping complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tParameterMapping"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transformation" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tExpression" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sourceRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;attribute name="targetRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tParameterMapping", propOrder = {
    "transformation"
})
public class TParameterMapping
    extends TCmmnElement
{

    protected TExpression transformation;
    @XmlAttribute(name = "sourceRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sourceRef;
    @XmlAttribute(name = "targetRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object targetRef;

    /**
     * Gets the value of the transformation property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getTransformation() {
        return transformation;
    }

    /**
     * Sets the value of the transformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setTransformation(TExpression value) {
        this.transformation = value;
    }

    public boolean isSetTransformation() {
        return (this.transformation!= null);
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
     * Gets the value of the targetRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getTargetRef() {
        return targetRef;
    }

    /**
     * Sets the value of the targetRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setTargetRef(Object value) {
        this.targetRef = value;
    }

    public boolean isSetTargetRef() {
        return (this.targetRef!= null);
    }

    public TParameterMapping withTransformation(TExpression value) {
        setTransformation(value);
        return this;
    }

    public TParameterMapping withSourceRef(Object value) {
        setSourceRef(value);
        return this;
    }

    public TParameterMapping withTargetRef(Object value) {
        setTargetRef(value);
        return this;
    }

    @Override
    public TParameterMapping withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TParameterMapping withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TParameterMapping withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TParameterMapping withId(String value) {
        setId(value);
        return this;
    }

}
