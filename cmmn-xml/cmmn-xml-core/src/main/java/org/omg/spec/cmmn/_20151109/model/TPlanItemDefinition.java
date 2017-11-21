
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPlanItemDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanItemDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement">
 *       &lt;sequence>
 *         &lt;element name="defaultControl" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanItemControl" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tPlanItemDefinition", propOrder = {
    "defaultControl"
})
@XmlSeeAlso({
    TTask.class,
    TEventListener.class,
    TMilestone.class,
    TPlanFragment.class
})
public abstract class TPlanItemDefinition
    extends TCmmnElement
{

    protected TPlanItemControl defaultControl;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the defaultControl property.
     * 
     * @return
     *     possible object is
     *     {@link TPlanItemControl }
     *     
     */
    public TPlanItemControl getDefaultControl() {
        return defaultControl;
    }

    /**
     * Sets the value of the defaultControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPlanItemControl }
     *     
     */
    public void setDefaultControl(TPlanItemControl value) {
        this.defaultControl = value;
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

    public TPlanItemDefinition withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    public TPlanItemDefinition withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TPlanItemDefinition withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanItemDefinition withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanItemDefinition withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanItemDefinition withId(String value) {
        setId(value);
        return this;
    }

}
