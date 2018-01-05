
package org.omg.spec.cmmn._20151109.cmmndi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;
import org.omg.spec.cmmn._20151109.dc.Bounds;
import org.omg.spec.cmmn._20151109.di.Shape;
import org.omg.spec.cmmn._20151109.di.Style;


/**
 * <p>Java class for CMMNShape complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMMNShape"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}Shape"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNLabel"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="cmmnElementRef" use="required" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="isCollapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;attribute name="isPlanningTableCollapsed" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMMNShape", propOrder = {
    "cmmnLabel"
})
public class CMMNShape
    extends Shape
{

    @XmlElement(name = "CMMNLabel", required = true)
    protected CMMNLabel cmmnLabel;
    @XmlAttribute(name = "cmmnElementRef", required = true)
    protected QName cmmnElementRef;
    @XmlAttribute(name = "isCollapsed")
    protected Boolean isCollapsed;
    @XmlAttribute(name = "isPlanningTableCollapsed")
    protected Boolean isPlanningTableCollapsed;

    /**
     * Gets the value of the cmmnLabel property.
     * 
     * @return
     *     possible object is
     *     {@link CMMNLabel }
     *     
     */
    public CMMNLabel getCMMNLabel() {
        return cmmnLabel;
    }

    /**
     * Sets the value of the cmmnLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CMMNLabel }
     *     
     */
    public void setCMMNLabel(CMMNLabel value) {
        this.cmmnLabel = value;
    }

    public boolean isSetCMMNLabel() {
        return (this.cmmnLabel!= null);
    }

    /**
     * Gets the value of the cmmnElementRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getCmmnElementRef() {
        return cmmnElementRef;
    }

    /**
     * Sets the value of the cmmnElementRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setCmmnElementRef(QName value) {
        this.cmmnElementRef = value;
    }

    public boolean isSetCmmnElementRef() {
        return (this.cmmnElementRef!= null);
    }

    /**
     * Gets the value of the isCollapsed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsCollapsed() {
        return isCollapsed;
    }

    /**
     * Sets the value of the isCollapsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsCollapsed(boolean value) {
        this.isCollapsed = value;
    }

    public boolean isSetIsCollapsed() {
        return (this.isCollapsed!= null);
    }

    public void unsetIsCollapsed() {
        this.isCollapsed = null;
    }

    /**
     * Gets the value of the isPlanningTableCollapsed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isIsPlanningTableCollapsed() {
        return isPlanningTableCollapsed;
    }

    /**
     * Sets the value of the isPlanningTableCollapsed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsPlanningTableCollapsed(boolean value) {
        this.isPlanningTableCollapsed = value;
    }

    public boolean isSetIsPlanningTableCollapsed() {
        return (this.isPlanningTableCollapsed!= null);
    }

    public void unsetIsPlanningTableCollapsed() {
        this.isPlanningTableCollapsed = null;
    }

    public CMMNShape withCMMNLabel(CMMNLabel value) {
        setCMMNLabel(value);
        return this;
    }

    public CMMNShape withCmmnElementRef(QName value) {
        setCmmnElementRef(value);
        return this;
    }

    public CMMNShape withIsCollapsed(boolean value) {
        setIsCollapsed(value);
        return this;
    }

    public CMMNShape withIsPlanningTableCollapsed(boolean value) {
        setIsPlanningTableCollapsed(value);
        return this;
    }

    @Override
    public CMMNShape withBounds(Bounds value) {
        setBounds(value);
        return this;
    }

    @Override
    public CMMNShape withExtension(org.omg.spec.cmmn._20151109.di.DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    @Override
    public CMMNShape withStyle(JAXBElement<? extends Style> value) {
        setStyle(value);
        return this;
    }

    @Override
    public CMMNShape withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    @Override
    public CMMNShape withId(String value) {
        setId(value);
        return this;
    }

}
