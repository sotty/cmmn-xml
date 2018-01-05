
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         tCaseRoles defines the type of element "caseRoles inside tCase".
 *       
 * 
 * <p>Java class for tCaseRoles complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCaseRoles"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}role" maxOccurs="unbounded" minOccurs="0"/&gt;
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
@XmlType(name = "tCaseRoles", propOrder = {
    "role"
})
public class TCaseRoles
    extends TCmmnElement
{

    protected List<TRole> role;

    /**
     * Gets the value of the role property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the role property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRole().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRole }
     * 
     * 
     */
    public List<TRole> getRole() {
        if (role == null) {
            role = new ArrayList<TRole>();
        }
        return this.role;
    }

    public boolean isSetRole() {
        return ((this.role!= null)&&(!this.role.isEmpty()));
    }

    public void unsetRole() {
        this.role = null;
    }

    public TCaseRoles withRole(TRole... values) {
        if (values!= null) {
            for (TRole value: values) {
                getRole().add(value);
            }
        }
        return this;
    }

    public TCaseRoles withRole(Collection<TRole> values) {
        if (values!= null) {
            getRole().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseRoles withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TCaseRoles withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseRoles withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TCaseRoles withId(String value) {
        setId(value);
        return this;
    }

}
