
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tDiscretionaryItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDiscretionaryItem">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tTableItem">
 *       &lt;sequence>
 *         &lt;element name="itemControl" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tPlanItemControl" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}entryCriterion" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}exitCriterion" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="definitionRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDiscretionaryItem", propOrder = {
    "itemControl",
    "entryCriterion",
    "exitCriterion"
})
public class TDiscretionaryItem
    extends TTableItem
{

    protected TPlanItemControl itemControl;
    protected List<TEntryCriterion> entryCriterion;
    protected List<TExitCriterion> exitCriterion;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "definitionRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object definitionRef;

    /**
     * Gets the value of the itemControl property.
     * 
     * @return
     *     possible object is
     *     {@link TPlanItemControl }
     *     
     */
    public TPlanItemControl getItemControl() {
        return itemControl;
    }

    /**
     * Sets the value of the itemControl property.
     * 
     * @param value
     *     allowed object is
     *     {@link TPlanItemControl }
     *     
     */
    public void setItemControl(TPlanItemControl value) {
        this.itemControl = value;
    }

    /**
     * Gets the value of the entryCriterion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the entryCriterion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEntryCriterion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TEntryCriterion }
     * 
     * 
     */
    public List<TEntryCriterion> getEntryCriterion() {
        if (entryCriterion == null) {
            entryCriterion = new ArrayList<TEntryCriterion>();
        }
        return this.entryCriterion;
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

    /**
     * Gets the value of the definitionRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getDefinitionRef() {
        return definitionRef;
    }

    /**
     * Sets the value of the definitionRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setDefinitionRef(Object value) {
        this.definitionRef = value;
    }

    public TDiscretionaryItem withItemControl(TPlanItemControl value) {
        setItemControl(value);
        return this;
    }

    public TDiscretionaryItem withEntryCriterion(TEntryCriterion... values) {
        if (values!= null) {
            for (TEntryCriterion value: values) {
                getEntryCriterion().add(value);
            }
        }
        return this;
    }

    public TDiscretionaryItem withEntryCriterion(Collection<TEntryCriterion> values) {
        if (values!= null) {
            getEntryCriterion().addAll(values);
        }
        return this;
    }

    public TDiscretionaryItem withExitCriterion(TExitCriterion... values) {
        if (values!= null) {
            for (TExitCriterion value: values) {
                getExitCriterion().add(value);
            }
        }
        return this;
    }

    public TDiscretionaryItem withExitCriterion(Collection<TExitCriterion> values) {
        if (values!= null) {
            getExitCriterion().addAll(values);
        }
        return this;
    }

    public TDiscretionaryItem withName(String value) {
        setName(value);
        return this;
    }

    public TDiscretionaryItem withDefinitionRef(Object value) {
        setDefinitionRef(value);
        return this;
    }

    @Override
    public TDiscretionaryItem withApplicabilityRuleRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getApplicabilityRuleRefs().add(value);
            }
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withApplicabilityRuleRefs(Collection<Object> values) {
        if (values!= null) {
            getApplicabilityRuleRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withAuthorizedRoleRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAuthorizedRoleRefs().add(value);
            }
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withAuthorizedRoleRefs(Collection<Object> values) {
        if (values!= null) {
            getAuthorizedRoleRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TDiscretionaryItem withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TDiscretionaryItem withId(String value) {
        setId(value);
        return this;
    }

}
