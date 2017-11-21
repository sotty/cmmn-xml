
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
 *         tHumanTask defines the type of element "humanTask"
 *       
 * 
 * <p>Java class for tHumanTask complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tHumanTask">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tTask">
 *       &lt;sequence>
 *         &lt;element name="planningTable" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanningTable" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="performerRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tHumanTask", propOrder = {
    "planningTable"
})
public class THumanTask
    extends TTask
{

    protected TPlanningTable planningTable;
    @XmlAttribute(name = "performerRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object performerRef;

    /**
     * Gets the value of the planningTable property.
     * 
     * @return
     *     possible object is
     *     {@link TPlanningTable }
     *     
     */
    public TPlanningTable getPlanningTable() {
        return planningTable;
    }

    /**
     * Sets the value of the planningTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPlanningTable }
     *     
     */
    public void setPlanningTable(TPlanningTable value) {
        this.planningTable = value;
    }

    /**
     * Gets the value of the performerRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getPerformerRef() {
        return performerRef;
    }

    /**
     * Sets the value of the performerRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setPerformerRef(Object value) {
        this.performerRef = value;
    }

    public THumanTask withPlanningTable(TPlanningTable value) {
        setPlanningTable(value);
        return this;
    }

    public THumanTask withPerformerRef(Object value) {
        setPerformerRef(value);
        return this;
    }

    @Override
    public THumanTask withInput(TCaseParameter... values) {
        if (values!= null) {
            for (TCaseParameter value: values) {
                getInput().add(value);
            }
        }
        return this;
    }

    @Override
    public THumanTask withInput(Collection<TCaseParameter> values) {
        if (values!= null) {
            getInput().addAll(values);
        }
        return this;
    }

    @Override
    public THumanTask withOutput(TCaseParameter... values) {
        if (values!= null) {
            for (TCaseParameter value: values) {
                getOutput().add(value);
            }
        }
        return this;
    }

    @Override
    public THumanTask withOutput(Collection<TCaseParameter> values) {
        if (values!= null) {
            getOutput().addAll(values);
        }
        return this;
    }

    @Override
    public THumanTask withIsBlocking(Boolean value) {
        setIsBlocking(value);
        return this;
    }

    @Override
    public THumanTask withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public THumanTask withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public THumanTask withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public THumanTask withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public THumanTask withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public THumanTask withId(String value) {
        setId(value);
        return this;
    }

}
