
package org.omg.spec.cmmn._20151109.di;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNDiagram;


/**
 * <p>Java class for Diagram complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Diagram"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}DiagramElement"&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="documentation" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="resolution" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Diagram")
@XmlSeeAlso({
    CMMNDiagram.class
})
public abstract class Diagram
    extends DiagramElement
{

    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "documentation")
    protected String documentation;
    @XmlAttribute(name = "resolution")
    protected Double resolution;

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
     * Gets the value of the documentation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDocumentation() {
        return documentation;
    }

    /**
     * Sets the value of the documentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDocumentation(String value) {
        this.documentation = value;
    }

    public boolean isSetDocumentation() {
        return (this.documentation!= null);
    }

    /**
     * Gets the value of the resolution property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getResolution() {
        return resolution;
    }

    /**
     * Sets the value of the resolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setResolution(double value) {
        this.resolution = value;
    }

    public boolean isSetResolution() {
        return (this.resolution!= null);
    }

    public void unsetResolution() {
        this.resolution = null;
    }

    public Diagram withName(String value) {
        setName(value);
        return this;
    }

    public Diagram withDocumentation(String value) {
        setDocumentation(value);
        return this;
    }

    public Diagram withResolution(double value) {
        setResolution(value);
        return this;
    }

    @Override
    public Diagram withExtension(DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    @Override
    public Diagram withStyle(JAXBElement<? extends Style> value) {
        setStyle(value);
        return this;
    }

    @Override
    public Diagram withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    @Override
    public Diagram withId(String value) {
        setId(value);
        return this;
    }

}
