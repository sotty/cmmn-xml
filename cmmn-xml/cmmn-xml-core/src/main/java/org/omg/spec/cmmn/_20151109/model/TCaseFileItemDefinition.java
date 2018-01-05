
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.namespace.QName;


/**
 * 
 *         tCaseFileItemDefinition defines the type of element "caseFileItemDefinition"
 *       
 * 
 * <p>Java class for tCaseFileItemDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tCaseFileItemDefinition"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/MODEL}tCmmnElement"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}property" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="definitionType" type="{http://www.omg.org/spec/CMMN/20151109/MODEL}DefinitionTypeEnum" default="http://www.omg.org/spec/CMMN/DefinitionType/Unspecified" /&gt;
 *       &lt;attribute name="structureRef" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;attribute name="importRef" type="{http://www.w3.org/2001/XMLSchema}QName" /&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tCaseFileItemDefinition", propOrder = {
    "property"
})
public class TCaseFileItemDefinition
    extends TCmmnElement
{

    protected List<TProperty> property;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "definitionType")
    protected String definitionType;
    @XmlAttribute(name = "structureRef")
    protected QName structureRef;
    @XmlAttribute(name = "importRef")
    protected QName importRef;

    /**
     * Gets the value of the property property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the property property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProperty().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProperty }
     * 
     * 
     */
    public List<TProperty> getProperty() {
        if (property == null) {
            property = new ArrayList<TProperty>();
        }
        return this.property;
    }

    public boolean isSetProperty() {
        return ((this.property!= null)&&(!this.property.isEmpty()));
    }

    public void unsetProperty() {
        this.property = null;
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
     * Gets the value of the definitionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefinitionType() {
        if (definitionType == null) {
            return "http://www.omg.org/spec/CMMN/DefinitionType/Unspecified";
        } else {
            return definitionType;
        }
    }

    /**
     * Sets the value of the definitionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefinitionType(String value) {
        this.definitionType = value;
    }

    public boolean isSetDefinitionType() {
        return (this.definitionType!= null);
    }

    /**
     * Gets the value of the structureRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getStructureRef() {
        return structureRef;
    }

    /**
     * Sets the value of the structureRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setStructureRef(QName value) {
        this.structureRef = value;
    }

    public boolean isSetStructureRef() {
        return (this.structureRef!= null);
    }

    /**
     * Gets the value of the importRef property.
     * 
     * @return
     *     possible object is
     *     {@link QName }
     *     
     */
    public QName getImportRef() {
        return importRef;
    }

    /**
     * Sets the value of the importRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link QName }
     *     
     */
    public void setImportRef(QName value) {
        this.importRef = value;
    }

    public boolean isSetImportRef() {
        return (this.importRef!= null);
    }

    public TCaseFileItemDefinition withProperty(TProperty... values) {
        if (values!= null) {
            for (TProperty value: values) {
                getProperty().add(value);
            }
        }
        return this;
    }

    public TCaseFileItemDefinition withProperty(Collection<TProperty> values) {
        if (values!= null) {
            getProperty().addAll(values);
        }
        return this;
    }

    public TCaseFileItemDefinition withName(String value) {
        setName(value);
        return this;
    }

    public TCaseFileItemDefinition withDefinitionType(String value) {
        setDefinitionType(value);
        return this;
    }

    public TCaseFileItemDefinition withStructureRef(QName value) {
        setStructureRef(value);
        return this;
    }

    public TCaseFileItemDefinition withImportRef(QName value) {
        setImportRef(value);
        return this;
    }

    @Override
    public TCaseFileItemDefinition withDocumentation(TDocumentation... values) {
        if (values!= null) {
            for (TDocumentation value: values) {
                getDocumentation().add(value);
            }
        }
        return this;
    }

    @Override
    public TCaseFileItemDefinition withDocumentation(Collection<TDocumentation> values) {
        if (values!= null) {
            getDocumentation().addAll(values);
        }
        return this;
    }

    @Override
    public TCaseFileItemDefinition withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    @Override
    public TCaseFileItemDefinition withId(String value) {
        setId(value);
        return this;
    }

}
