
package org.omg.spec.cmmn._20151109.cmmndi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CMMNDI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMMNDI"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNDiagram" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNStyle" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMMNDI", propOrder = {
    "cmmnDiagram",
    "cmmnStyle"
})
public class CMMNDI {

    @XmlElement(name = "CMMNDiagram")
    protected List<CMMNDiagram> cmmnDiagram;
    @XmlElement(name = "CMMNStyle")
    protected List<CMMNStyle> cmmnStyle;

    /**
     * Gets the value of the cmmnDiagram property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmmnDiagram property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMMNDiagram().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMMNDiagram }
     * 
     * 
     */
    public List<CMMNDiagram> getCMMNDiagram() {
        if (cmmnDiagram == null) {
            cmmnDiagram = new ArrayList<CMMNDiagram>();
        }
        return this.cmmnDiagram;
    }

    public boolean isSetCMMNDiagram() {
        return ((this.cmmnDiagram!= null)&&(!this.cmmnDiagram.isEmpty()));
    }

    public void unsetCMMNDiagram() {
        this.cmmnDiagram = null;
    }

    /**
     * Gets the value of the cmmnStyle property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cmmnStyle property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCMMNStyle().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CMMNStyle }
     * 
     * 
     */
    public List<CMMNStyle> getCMMNStyle() {
        if (cmmnStyle == null) {
            cmmnStyle = new ArrayList<CMMNStyle>();
        }
        return this.cmmnStyle;
    }

    public boolean isSetCMMNStyle() {
        return ((this.cmmnStyle!= null)&&(!this.cmmnStyle.isEmpty()));
    }

    public void unsetCMMNStyle() {
        this.cmmnStyle = null;
    }

    public CMMNDI withCMMNDiagram(CMMNDiagram... values) {
        if (values!= null) {
            for (CMMNDiagram value: values) {
                getCMMNDiagram().add(value);
            }
        }
        return this;
    }

    public CMMNDI withCMMNDiagram(Collection<CMMNDiagram> values) {
        if (values!= null) {
            getCMMNDiagram().addAll(values);
        }
        return this;
    }

    public CMMNDI withCMMNStyle(CMMNStyle... values) {
        if (values!= null) {
            for (CMMNStyle value: values) {
                getCMMNStyle().add(value);
            }
        }
        return this;
    }

    public CMMNDI withCMMNStyle(Collection<CMMNStyle> values) {
        if (values!= null) {
            getCMMNStyle().addAll(values);
        }
        return this;
    }

}
