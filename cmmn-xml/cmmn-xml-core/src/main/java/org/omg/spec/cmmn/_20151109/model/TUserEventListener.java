
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
 * <p>Java class for tUserEventListener complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tUserEventListener"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tEventListener"&gt;
 *       &lt;attribute name="authorizedRoleRefs" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tUserEventListener")
public class TUserEventListener
    extends TEventListener
{

    @XmlAttribute(name = "authorizedRoleRefs")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> authorizedRoleRefs;

    /**
     * Gets the value of the authorizedRoleRefs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the authorizedRoleRefs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAuthorizedRoleRefs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAuthorizedRoleRefs() {
        if (authorizedRoleRefs == null) {
            authorizedRoleRefs = new ArrayList<Object>();
        }
        return this.authorizedRoleRefs;
    }

    public boolean isSetAuthorizedRoleRefs() {
        return ((this.authorizedRoleRefs!= null)&&(!this.authorizedRoleRefs.isEmpty()));
    }

    public void unsetAuthorizedRoleRefs() {
        this.authorizedRoleRefs = null;
    }

    public TUserEventListener withAuthorizedRoleRefs(Object... values) {
        if (values!= null) {
            for (Object value: values) {
                getAuthorizedRoleRefs().add(value);
            }
        }
        return this;
    }

    public TUserEventListener withAuthorizedRoleRefs(Collection<Object> values) {
        if (values!= null) {
            getAuthorizedRoleRefs().addAll(values);
        }
        return this;
    }

    @Override
    public TUserEventListener withDefaultControl(TPlanItemControl value) {
        setDefaultControl(value);
        return this;
    }

    @Override
    public TUserEventListener withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TUserEventListener withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TUserEventListener withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TUserEventListener withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TUserEventListener withId(String value) {
        setId(value);
        return this;
    }

}
