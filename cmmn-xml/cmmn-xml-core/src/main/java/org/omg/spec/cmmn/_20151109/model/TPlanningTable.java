
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tPlanningTable complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tPlanningTable"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tTableItem"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}tableItem" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}applicabilityRule" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "tPlanningTable", propOrder = {
    "tableItem",
    "applicabilityRule"
})
public class TPlanningTable
    extends TTableItem
{

    @XmlElementRef(name = "tableItem", namespace = "http://www.omg.org/spec/CMMN/20151109/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TTableItem>> tableItem;
    protected List<TApplicabilityRule> applicabilityRule;

    /**
     * Gets the value of the tableItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the tableItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTableItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TPlanningTable }{@code >}
     * {@link JAXBElement }{@code <}{@link TDiscretionaryItem }{@code >}
     * {@link JAXBElement }{@code <}{@link TTableItem }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TTableItem>> getTableItem() {
        if (tableItem == null) {
            tableItem = new ArrayList<JAXBElement<? extends TTableItem>>();
        }
        return this.tableItem;
    }

    public boolean isSetTableItem() {
        return ((this.tableItem!= null)&&(!this.tableItem.isEmpty()));
    }

    public void unsetTableItem() {
        this.tableItem = null;
    }

    /**
     * Gets the value of the applicabilityRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the applicabilityRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getApplicabilityRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TApplicabilityRule }
     * 
     * 
     */
    public List<TApplicabilityRule> getApplicabilityRule() {
        if (applicabilityRule == null) {
            applicabilityRule = new ArrayList<TApplicabilityRule>();
        }
        return this.applicabilityRule;
    }

    public boolean isSetApplicabilityRule() {
        return ((this.applicabilityRule!= null)&&(!this.applicabilityRule.isEmpty()));
    }

    public void unsetApplicabilityRule() {
        this.applicabilityRule = null;
    }

    public TPlanningTable withTableItem(JAXBElement<? extends TTableItem> ... values) {
        if (values!= null) {
            for (JAXBElement<? extends TTableItem> value: values) {
                getTableItem().add(value);
            }
        }
        return this;
    }

    public TPlanningTable withTableItem(Collection<JAXBElement<? extends TTableItem>> values) {
        if (values!= null) {
            getTableItem().addAll(values);
        }
        return this;
    }

    public TPlanningTable withApplicabilityRule(TApplicabilityRule... values) {
        if (values!= null) {
            for (TApplicabilityRule value: values) {
                getApplicabilityRule().add(value);
            }
        }
        return this;
    }

    public TPlanningTable withApplicabilityRule(Collection<TApplicabilityRule> values) {
        if (values!= null) {
            getApplicabilityRule().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanningTable withApplicabilityRuleRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getApplicabilityRuleRefs().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanningTable withApplicabilityRuleRefs(Collection<Object> values) {
        if (values!= null) {
            getApplicabilityRuleRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanningTable withAuthorizedRoleRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAuthorizedRoleRefs().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanningTable withAuthorizedRoleRefs(Collection<Object> values) {
        if (values!= null) {
            getAuthorizedRoleRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanningTable withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TPlanningTable withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TPlanningTable withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TPlanningTable withId(String value) {
        setId(value);
        return this;
    }

}
