
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCaseParameter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCaseParameter">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tParameter">
 *       &lt;sequence>
 *         &lt;element name="bindingRefinement" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tExpression" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="bindingRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCaseParameter", propOrder = {
    "bindingRefinement"
})
public class TCaseParameter
    extends TParameter
{

    protected TExpression bindingRefinement;
    @XmlAttribute(name = "bindingRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object bindingRef;

    /**
     * Gets the value of the bindingRefinement property.
     * 
     * @return
     *     possible object is
     *     {@link TExpression }
     *     
     */
    public TExpression getBindingRefinement() {
        return bindingRefinement;
    }

    /**
     * Sets the value of the bindingRefinement property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExpression }
     *     
     */
    public void setBindingRefinement(TExpression value) {
        this.bindingRefinement = value;
    }

    /**
     * Gets the value of the bindingRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getBindingRef() {
        return bindingRef;
    }

    /**
     * Sets the value of the bindingRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setBindingRef(Object value) {
        this.bindingRef = value;
    }

    public TCaseParameter withBindingRefinement(TExpression value) {
        setBindingRefinement(value);
        return this;
    }

    public TCaseParameter withBindingRef(Object value) {
        setBindingRef(value);
        return this;
    }

    @Override
    public TCaseParameter withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TCaseParameter withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TCaseParameter withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseParameter withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TCaseParameter withId(String value) {
        setId(value);
        return this;
    }

}
