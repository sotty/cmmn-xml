
package org.omg.spec.cmmn._20151109.model;

import java.util.Collection;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tCaseFileItemOnPart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCaseFileItemOnPart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tOnPart"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="standardEvent" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}CaseFileItemTransition" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="sourceRef" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCaseFileItemOnPart", propOrder = {
    "standardEvent"
})
public class TCaseFileItemOnPart
    extends TOnPart
{

    @XmlSchemaType(name = "string")
    protected CaseFileItemTransition standardEvent;
    @XmlAttribute(name = "sourceRef")
    @XmlIDREF
    @XmlSchemaType(name = "IDREF")
    protected Object sourceRef;

    /**
     * Gets the value of the standardEvent property.
     * 
     * @return
     *     possible object is
     *     {@link CaseFileItemTransition }
     *     
     */
    public CaseFileItemTransition getStandardEvent() {
        return standardEvent;
    }

    /**
     * Sets the value of the standardEvent property.
     * 
     * @param value
     *     allowed object is
     *     {@link CaseFileItemTransition }
     *     
     */
    public void setStandardEvent(CaseFileItemTransition value) {
        this.standardEvent = value;
    }

    public boolean isSetStandardEvent() {
        return (this.standardEvent!= null);
    }

    /**
     * Gets the value of the sourceRef property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getSourceRef() {
        return sourceRef;
    }

    /**
     * Sets the value of the sourceRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setSourceRef(Object value) {
        this.sourceRef = value;
    }

    public boolean isSetSourceRef() {
        return (this.sourceRef!= null);
    }

    public TCaseFileItemOnPart withStandardEvent(CaseFileItemTransition value) {
        setStandardEvent(value);
        return this;
    }

    public TCaseFileItemOnPart withSourceRef(Object value) {
        setSourceRef(value);
        return this;
    }

    @Override
    public TCaseFileItemOnPart withName(String value) {
        setName(value);
        return this;
    }

    @Override
    public TCaseFileItemOnPart withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TCaseFileItemOnPart withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseFileItemOnPart withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TCaseFileItemOnPart withId(String value) {
        setId(value);
        return this;
    }

}
