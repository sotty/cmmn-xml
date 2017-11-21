
package org.omg.spec.cmmn._20151109.cmmndi;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.omg.spec.cmmn._20151109.dc.Color;
import org.omg.spec.cmmn._20151109.di.Style;


/**
 * <p>Java class for CMMNStyle complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMMNStyle">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}Style">
 *       &lt;sequence>
 *         &lt;element name="FillColor" type="{http://www.omg.org/spec/CMMN/20151109/DC}Color" minOccurs="0"/>
 *         &lt;element name="StrokeColor" type="{http://www.omg.org/spec/CMMN/20151109/DC}Color" minOccurs="0"/>
 *         &lt;element name="FontColor" type="{http://www.omg.org/spec/CMMN/20151109/DC}Color" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fontFamily" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fontSize" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="fontItalic" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fontBold" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fontUnderline" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="fontStrikeThrough" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       &lt;attribute name="labelHorizontalAlignement" type="{http://www.omg.org/spec/CMMN/20151109/DC}AlignmentKind" />
 *       &lt;attribute name="labelVerticalAlignment" type="{http://www.omg.org/spec/CMMN/20151109/DC}AlignmentKind" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMMNStyle", propOrder = {
    "fillColor",
    "strokeColor",
    "fontColor"
})
public class CMMNStyle
    extends Style
{

    @XmlElement(name = "FillColor")
    protected Color fillColor;
    @XmlElement(name = "StrokeColor")
    protected Color strokeColor;
    @XmlElement(name = "FontColor")
    protected Color fontColor;
    @XmlAttribute(name = "fontFamily")
    protected String fontFamily;
    @XmlAttribute(name = "fontSize")
    protected Double fontSize;
    @XmlAttribute(name = "fontItalic")
    protected Boolean fontItalic;
    @XmlAttribute(name = "fontBold")
    protected Boolean fontBold;
    @XmlAttribute(name = "fontUnderline")
    protected Boolean fontUnderline;
    @XmlAttribute(name = "fontStrikeThrough")
    protected Boolean fontStrikeThrough;
    @XmlAttribute(name = "labelHorizontalAlignement")
    protected org.omg.spec.cmmn._20151109.dc.AlignmentKind labelHorizontalAlignement;
    @XmlAttribute(name = "labelVerticalAlignment")
    protected org.omg.spec.cmmn._20151109.dc.AlignmentKind labelVerticalAlignment;

    /**
     * Gets the value of the fillColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getFillColor() {
        return fillColor;
    }

    /**
     * Sets the value of the fillColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setFillColor(Color value) {
        this.fillColor = value;
    }

    public boolean isSetFillColor() {
        return (this.fillColor!= null);
    }

    /**
     * Gets the value of the strokeColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getStrokeColor() {
        return strokeColor;
    }

    /**
     * Sets the value of the strokeColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setStrokeColor(Color value) {
        this.strokeColor = value;
    }

    public boolean isSetStrokeColor() {
        return (this.strokeColor!= null);
    }

    /**
     * Gets the value of the fontColor property.
     * 
     * @return
     *     possible object is
     *     {@link Color }
     *     
     */
    public Color getFontColor() {
        return fontColor;
    }

    /**
     * Sets the value of the fontColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Color }
     *     
     */
    public void setFontColor(Color value) {
        this.fontColor = value;
    }

    public boolean isSetFontColor() {
        return (this.fontColor!= null);
    }

    /**
     * Gets the value of the fontFamily property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFontFamily() {
        return fontFamily;
    }

    /**
     * Sets the value of the fontFamily property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFontFamily(String value) {
        this.fontFamily = value;
    }

    public boolean isSetFontFamily() {
        return (this.fontFamily!= null);
    }

    /**
     * Gets the value of the fontSize property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public double getFontSize() {
        return fontSize;
    }

    /**
     * Sets the value of the fontSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setFontSize(double value) {
        this.fontSize = value;
    }

    public boolean isSetFontSize() {
        return (this.fontSize!= null);
    }

    public void unsetFontSize() {
        this.fontSize = null;
    }

    /**
     * Gets the value of the fontItalic property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFontItalic() {
        return fontItalic;
    }

    /**
     * Sets the value of the fontItalic property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFontItalic(boolean value) {
        this.fontItalic = value;
    }

    public boolean isSetFontItalic() {
        return (this.fontItalic!= null);
    }

    public void unsetFontItalic() {
        this.fontItalic = null;
    }

    /**
     * Gets the value of the fontBold property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFontBold() {
        return fontBold;
    }

    /**
     * Sets the value of the fontBold property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFontBold(boolean value) {
        this.fontBold = value;
    }

    public boolean isSetFontBold() {
        return (this.fontBold!= null);
    }

    public void unsetFontBold() {
        this.fontBold = null;
    }

    /**
     * Gets the value of the fontUnderline property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFontUnderline() {
        return fontUnderline;
    }

    /**
     * Sets the value of the fontUnderline property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFontUnderline(boolean value) {
        this.fontUnderline = value;
    }

    public boolean isSetFontUnderline() {
        return (this.fontUnderline!= null);
    }

    public void unsetFontUnderline() {
        this.fontUnderline = null;
    }

    /**
     * Gets the value of the fontStrikeThrough property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isFontStrikeThrough() {
        return fontStrikeThrough;
    }

    /**
     * Sets the value of the fontStrikeThrough property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFontStrikeThrough(boolean value) {
        this.fontStrikeThrough = value;
    }

    public boolean isSetFontStrikeThrough() {
        return (this.fontStrikeThrough!= null);
    }

    public void unsetFontStrikeThrough() {
        this.fontStrikeThrough = null;
    }

    /**
     * Gets the value of the labelHorizontalAlignement property.
     * 
     * @return
     *     possible object is
     *     {@link org.omg.spec.cmmn._20151109.dc.AlignmentKind }
     *     
     */
    public org.omg.spec.cmmn._20151109.dc.AlignmentKind getLabelHorizontalAlignement() {
        return labelHorizontalAlignement;
    }

    /**
     * Sets the value of the labelHorizontalAlignement property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.omg.spec.cmmn._20151109.dc.AlignmentKind }
     *     
     */
    public void setLabelHorizontalAlignement(org.omg.spec.cmmn._20151109.dc.AlignmentKind value) {
        this.labelHorizontalAlignement = value;
    }

    public boolean isSetLabelHorizontalAlignement() {
        return (this.labelHorizontalAlignement!= null);
    }

    /**
     * Gets the value of the labelVerticalAlignment property.
     * 
     * @return
     *     possible object is
     *     {@link org.omg.spec.cmmn._20151109.dc.AlignmentKind }
     *     
     */
    public org.omg.spec.cmmn._20151109.dc.AlignmentKind getLabelVerticalAlignment() {
        return labelVerticalAlignment;
    }

    /**
     * Sets the value of the labelVerticalAlignment property.
     * 
     * @param value
     *     allowed object is
     *     {@link org.omg.spec.cmmn._20151109.dc.AlignmentKind }
     *     
     */
    public void setLabelVerticalAlignment(org.omg.spec.cmmn._20151109.dc.AlignmentKind value) {
        this.labelVerticalAlignment = value;
    }

    public boolean isSetLabelVerticalAlignment() {
        return (this.labelVerticalAlignment!= null);
    }

    public CMMNStyle withFillColor(Color value) {
        setFillColor(value);
        return this;
    }

    public CMMNStyle withStrokeColor(Color value) {
        setStrokeColor(value);
        return this;
    }

    public CMMNStyle withFontColor(Color value) {
        setFontColor(value);
        return this;
    }

    public CMMNStyle withFontFamily(String value) {
        setFontFamily(value);
        return this;
    }

    public CMMNStyle withFontSize(double value) {
        setFontSize(value);
        return this;
    }

    public CMMNStyle withFontItalic(boolean value) {
        setFontItalic(value);
        return this;
    }

    public CMMNStyle withFontBold(boolean value) {
        setFontBold(value);
        return this;
    }

    public CMMNStyle withFontUnderline(boolean value) {
        setFontUnderline(value);
        return this;
    }

    public CMMNStyle withFontStrikeThrough(boolean value) {
        setFontStrikeThrough(value);
        return this;
    }

    public CMMNStyle withLabelHorizontalAlignement(org.omg.spec.cmmn._20151109.dc.AlignmentKind value) {
        setLabelHorizontalAlignement(value);
        return this;
    }

    public CMMNStyle withLabelVerticalAlignment(org.omg.spec.cmmn._20151109.dc.AlignmentKind value) {
        setLabelVerticalAlignment(value);
        return this;
    }

}
