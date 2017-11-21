
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tChildren defines a container for zero or more "caseFileItem" elements.
 *       
 * 
 * <p>Java class for tChildren complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tChildren">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}caseFileItem" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tChildren", propOrder = {
    "caseFileItem"
})
public class TChildren
    extends TCmmnElement
{

    protected List<TCaseFileItem> caseFileItem;

    /**
     * Gets the value of the caseFileItem property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the caseFileItem property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseFileItem().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCaseFileItem }
     * 
     * 
     */
    public List<TCaseFileItem> getCaseFileItem() {
        if (caseFileItem == null) {
            caseFileItem = new ArrayList<TCaseFileItem>();
        }
        return this.caseFileItem;
    }

    public TChildren withCaseFileItem(TCaseFileItem... values) {
        if (values!= null) {
            for (TCaseFileItem value: values) {
                getCaseFileItem().add(value);
            }
        }
        return this;
    }

    public TChildren withCaseFileItem(Collection<TCaseFileItem> values) {
        if (values!= null) {
            getCaseFileItem().addAll(values);
        }
        return this;
    }

    @Override
    public TChildren withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TChildren withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TChildren withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TChildren withId(String value) {
        setId(value);
        return this;
    }

}
