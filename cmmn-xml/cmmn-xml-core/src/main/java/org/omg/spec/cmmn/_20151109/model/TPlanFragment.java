
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tPlanFragment defines the type for element "planFragment"
 *       
 * 
 * <p>Java class for tPlanFragment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanFragment"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanItemDefinition"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}planItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}sentry" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "tPlanFragment", propOrder = {
    "planItem",
    "sentry"
})
@XmlSeeAlso({
    TStage.class
})
public class TPlanFragment
    extends TPlanItemDefinition
{

    protected List<TPlanItem> planItem;
    protected List<TSentry> sentry;

    /**
     * Gets the value of the planItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the planItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlanItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TPlanItem }
     * 
     * 
     */
    public List<TPlanItem> getPlanItem() {
        if (planItem == null) {
            planItem = new ArrayList<TPlanItem>();
        }
        return this.planItem;
    }

    public boolean isSetPlanItem() {
        return ((this.planItem!= null)&&(!this.planItem.isEmpty()));
    }

    public void unsetPlanItem() {
        this.planItem = null;
    }

    /**
     * Gets the value of the sentry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sentry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSentry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TSentry }
     * 
     * 
     */
    public List<TSentry> getSentry() {
        if (sentry == null) {
            sentry = new ArrayList<TSentry>();
        }
        return this.sentry;
    }

    public boolean isSetSentry() {
        return ((this.sentry!= null)&&(!this.sentry.isEmpty()));
    }

    public void unsetSentry() {
        this.sentry = null;
    }

    public TPlanFragment withPlanItem(TPlanItem... values) {
        if (values!= null) {
            for (TPlanItem value: values) {
                getPlanItem().add(value);
            }
        }
        return this;
    }

    public TPlanFragment withPlanItem(Collection<TPlanItem> values) {
        if (values!= null) {
            getPlanItem().addAll(values);
        }
        return this;
    }

    public TPlanFragment withSentry(TSentry... values) {
        if (values!= null) {
            for (TSentry value: values) {
                getSentry().add(value);
            }
        }
        return this;
    }

    public TPlanFragment withSentry(Collection<TSentry> values) {
        if (values!= null) {
            getSentry().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanFragment withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public TPlanFragment withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TPlanFragment withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanFragment withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanFragment withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanFragment withId(String value) {
        setId(value);
        return this;
    }

}
