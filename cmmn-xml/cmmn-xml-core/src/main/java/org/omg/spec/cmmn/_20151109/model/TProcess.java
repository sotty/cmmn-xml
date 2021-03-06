
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 *         tProcess defines the type of element "process"
 *       
 * 
 * <p>Java class for tProcess complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tProcess"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="input" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tProcessParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="output" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}tProcessParameter" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="externalRef" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="implementationType" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://www.omg.org/spec/CMMN/ProcessType/Unspecified" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tProcess", propOrder = {
    "input",
    "output"
})
public class TProcess
    extends TCmmnElement
{

    protected List<TProcessParameter> input;
    protected List<TProcessParameter> output;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "externalRef")
    protected QName externalRef;
    @XmlAttribute(name = "implementationType")
    @XmlSchemaType(name = "anyURI")
    protected String implementationType;

    /**
     * Gets the value of the input property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the input property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProcessParameter }
     * 
     * 
     */
    public List<TProcessParameter> getInput() {
        if (input == null) {
            input = new ArrayList<TProcessParameter>();
        }
        return this.input;
    }

    public boolean isSetInput() {
        return ((this.input!= null)&&(!this.input.isEmpty()));
    }

    public void unsetInput() {
        this.input = null;
    }

    /**
     * Gets the value of the output property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the output property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutput().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProcessParameter }
     * 
     * 
     */
    public List<TProcessParameter> getOutput() {
        if (output == null) {
            output = new ArrayList<TProcessParameter>();
        }
        return this.output;
    }

    public boolean isSetOutput() {
        return ((this.output!= null)&&(!this.output.isEmpty()));
    }

    public void unsetOutput() {
        this.output = null;
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

    public boolean isSetName() {
        return (this.name!= null);
    }

    /**
     * Gets the value of the externalRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getExternalRef() {
        return externalRef;
    }

    /**
     * Sets the value of the externalRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setExternalRef(QName value) {
        this.externalRef = value;
    }

    public boolean isSetExternalRef() {
        return (this.externalRef!= null);
    }

    /**
     * Gets the value of the implementationType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImplementationType() {
        if (implementationType == null) {
            return "http://www.omg.org/spec/CMMN/ProcessType/Unspecified";
        } else {
            return implementationType;
        }
    }

    /**
     * Sets the value of the implementationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImplementationType(String value) {
        this.implementationType = value;
    }

    public boolean isSetImplementationType() {
        return (this.implementationType!= null);
    }

    public TProcess withInput(TProcessParameter... values) {
        if (values!= null) {
            for (TProcessParameter value: values) {
                getInput().add(value);
            }
        }
        return this;
    }

    public TProcess withInput(Collection<TProcessParameter> values) {
        if (values!= null) {
            getInput().addAll(values);
        }
        return this;
    }

    public TProcess withOutput(TProcessParameter... values) {
        if (values!= null) {
            for (TProcessParameter value: values) {
                getOutput().add(value);
            }
        }
        return this;
    }

    public TProcess withOutput(Collection<TProcessParameter> values) {
        if (values!= null) {
            getOutput().addAll(values);
        }
        return this;
    }

    public TProcess withName(String value) {
        setName(value);
        return this;
    }

    public TProcess withExternalRef(QName value) {
        setExternalRef(value);
        return this;
    }

    public TProcess withImplementationType(String value) {
        setImplementationType(value);
        return this;
    }

    @Override
    public TProcess withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TProcess withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TProcess withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TProcess withId(String value) {
        setId(value);
        return this;
    }

}
