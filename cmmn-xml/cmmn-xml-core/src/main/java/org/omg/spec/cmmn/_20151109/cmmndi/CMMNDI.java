
package org.omg.spec.cmmn._20151109.cmmndi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CMMNDI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMMNDI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNDiagram" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNStyle" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMMNDI", propOrder = {
    "cmmnDiagrams",
    "cmmnStyles"
})
@XmlRootElement(name = "CMMNDI")
public class CMMNDI {

    @XmlElement(name = "CMMNDiagram")
    protected List<CMMNDiagram> cmmnDiagrams;
    @XmlElement(name = "CMMNStyle")
    protected List<CMMNStyle> cmmnStyles;

    /**
     * Gets the value of the cmmnDiagrams property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmmnDiagrams property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMMNDiagrams().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMMNDiagram }
     * 
     * 
     */
    public List<CMMNDiagram> getCMMNDiagrams() {
        if (cmmnDiagrams == null) {
            cmmnDiagrams = new ArrayList<CMMNDiagram>();
        }
        return this.cmmnDiagrams;
    }

    public boolean isSetCMMNDiagrams() {
        return ((this.cmmnDiagrams!= null)&&(!this.cmmnDiagrams.isEmpty()));
    }

    public void unsetCMMNDiagrams() {
        this.cmmnDiagrams = null;
    }

    /**
     * Gets the value of the cmmnStyles property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmmnStyles property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMMNStyles().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMMNStyle }
     * 
     * 
     */
    public List<CMMNStyle> getCMMNStyles() {
        if (cmmnStyles == null) {
            cmmnStyles = new ArrayList<CMMNStyle>();
        }
        return this.cmmnStyles;
    }

    public boolean isSetCMMNStyles() {
        return ((this.cmmnStyles!= null)&&(!this.cmmnStyles.isEmpty()));
    }

    public void unsetCMMNStyles() {
        this.cmmnStyles = null;
    }

    public CMMNDI withCMMNDiagrams(CMMNDiagram... values) {
        if (values!= null) {
            for (CMMNDiagram value: values) {
                getCMMNDiagrams().add(value);
            }
        }
        return this;
    }

    public CMMNDI withCMMNDiagrams(Collection<CMMNDiagram> values) {
        if (values!= null) {
            getCMMNDiagrams().addAll(values);
        }
        return this;
    }

    public CMMNDI withCMMNStyles(CMMNStyle... values) {
        if (values!= null) {
            for (CMMNStyle value: values) {
                getCMMNStyles().add(value);
            }
        }
        return this;
    }

    public CMMNDI withCMMNStyles(Collection<CMMNStyle> values) {
        if (values!= null) {
            getCMMNStyles().addAll(values);
        }
        return this;
    }

}
