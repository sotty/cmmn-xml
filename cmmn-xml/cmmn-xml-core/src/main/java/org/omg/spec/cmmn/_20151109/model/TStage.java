
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tStage defines the type for element "stage"
 *       
 * 
 * <p>Java class for tStage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tStage">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanFragment">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}planningTable" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}planItemDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}exitCriterion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="autoComplete" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tStage", propOrder = {
    "planningTable",
    "planItemDefinition",
    "exitCriterion"
})
public class TStage
    extends TPlanFragment
{

    protected TPlanningTable planningTable;
    @XmlElementRef(name = "planItemDefinition", namespace = "http://www.omg.org/spec/CMMN/20151109/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TPlanItemDefinition>> planItemDefinition;
    protected List<TExitCriterion> exitCriterion;
    @XmlAttribute(name = "autoComplete")
    protected Boolean autoComplete;

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
     * Gets the value of the planItemDefinition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planItemDefinition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanItemDefinition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TUserEventListener }{@code >}
     * {@link JAXBElement }{@code <}{@link TEventListener }{@code >}
     * {@link JAXBElement }{@code <}{@link TTimerEventListener }{@code >}
     * {@link JAXBElement }{@code <}{@link TProcessTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TDecisionTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TMilestone }{@code >}
     * {@link JAXBElement }{@code <}{@link TStage }{@code >}
     * {@link JAXBElement }{@code <}{@link TCaseTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TPlanItemDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link THumanTask }{@code >}
     * {@link JAXBElement }{@code <}{@link TPlanFragment }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TPlanItemDefinition>> getPlanItemDefinition() {
        if (planItemDefinition == null) {
            planItemDefinition = new ArrayList<JAXBElement<? extends TPlanItemDefinition>>();
        }
        return this.planItemDefinition;
    }

    /**
     * Gets the value of the exitCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the exitCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExitCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TExitCriterion }
     * 
     * 
     */
    public List<TExitCriterion> getExitCriterion() {
        if (exitCriterion == null) {
            exitCriterion = new ArrayList<TExitCriterion>();
        }
        return this.exitCriterion;
    }

    /**
     * Gets the value of the autoComplete property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isAutoComplete() {
        if (autoComplete == null) {
            return false;
        } else {
            return autoComplete;
        }
    }

    /**
     * Sets the value of the autoComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAutoComplete(Boolean value) {
        this.autoComplete = value;
    }

    public TStage withPlanningTable(TPlanningTable value) {
        setPlanningTable(value);
        return this;
    }

    public TStage withPlanItemDefinition(JAXBElement<? extends TPlanItemDefinition> ... values) {
        if (values!= null) {
            for (JAXBElement<? extends TPlanItemDefinition> value: values) {
                getPlanItemDefinition().add(value);
            }
        }
        return this;
    }

    public TStage withPlanItemDefinition(Collection<JAXBElement<? extends TPlanItemDefinition>> values) {
        if (values!= null) {
            getPlanItemDefinition().addAll(values);
        }
        return this;
    }

    public TStage withExitCriterion(TExitCriterion... values) {
        if (values!= null) {
            for (TExitCriterion value: values) {
                getExitCriterion().add(value);
            }
        }
        return this;
    }

    public TStage withExitCriterion(Collection<TExitCriterion> values) {
        if (values!= null) {
            getExitCriterion().addAll(values);
        }
        return this;
    }

    public TStage withAutoComplete(Boolean value) {
        setAutoComplete(value);
        return this;
    }

    @Override
    public TStage withPlanItem(TPlanItem... values) {
        if (values!= null) {
            for (TPlanItem value: values) {
                getPlanItem().add(value);
            }
        }
        return this;
    }

    @Override
    public TStage withPlanItem(Collection<TPlanItem> values) {
        if (values!= null) {
            getPlanItem().addAll(values);
        }
        return this;
    }

    @Override
    public TStage withSentry(TSentry... values) {
        if (values!= null) {
            for (TSentry value: values) {
                getSentry().add(value);
            }
        }
        return this;
    }

    @Override
    public TStage withSentry(Collection<TSentry> values) {
        if (values!= null) {
            getSentry().addAll(values);
        }
        return this;
    }

    @Override
    public TStage withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public TStage withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TStage withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TStage withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TStage withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TStage withId(String value) {
        setId(value);
        return this;
    }

}
