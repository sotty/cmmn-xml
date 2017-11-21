
package org.omg.spec.cmmn._20151109.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyAttribute;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import org.omg.spec.cmmn._20151109.cmmndi.CMMNDI;


/**
 * 
 *         tDefinitions defines the type of element "definitions". 
 *       
 * 
 * <p>Java class for tDefinitions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tDefinitions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}import" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}caseFileItemDefinition" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}case" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}process" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}decision" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}extensionElements" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}relationship" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/MODEL}artifact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.omg.org/spec/CMMN/20151109/CMMNDI}CMMNDI" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="targetNamespace" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="expressionLanguage" type="{http://www.w3.org/2001/XMLSchema}anyURI" default="http://www.w3.org/1999/XPath" />
 *       &lt;attribute name="exporter" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="exporterVersion" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="author" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="creationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tDefinitions", propOrder = {
    "_import",
    "caseFileItemDefinition",
    "_case",
    "process",
    "decision",
    "extensionElements",
    "relationship",
    "artifact",
    "cmmndi"
})
public class TDefinitions {

    @XmlElement(name = "import")
    protected List<TImport> _import;
    protected List<TCaseFileItemDefinition> caseFileItemDefinition;
    @XmlElement(name = "case")
    protected List<TCase> _case;
    protected List<TProcess> process;
    protected List<TDecision> decision;
    protected TExtensionElements extensionElements;
    protected List<TRelationship> relationship;
    @XmlElementRef(name = "artifact", namespace = "http://www.omg.org/spec/CMMN/20151109/MODEL", type = JAXBElement.class, required = false)
    protected List<JAXBElement<? extends TArtifact>> artifact;
    @XmlElement(name = "CMMNDI", namespace = "http://www.omg.org/spec/CMMN/20151109/CMMNDI")
    protected CMMNDI cmmndi;
    @XmlAttribute(name = "id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "targetNamespace", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String targetNamespace;
    @XmlAttribute(name = "expressionLanguage")
    @XmlSchemaType(name = "anyURI")
    protected String expressionLanguage;
    @XmlAttribute(name = "exporter")
    protected String exporter;
    @XmlAttribute(name = "exporterVersion")
    protected String exporterVersion;
    @XmlAttribute(name = "author")
    protected String author;
    @XmlAttribute(name = "creationDate")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationDate;
    @XmlAnyAttribute
    private Map<QName, String> otherAttributes = new HashMap<QName, String>();

    /**
     * Gets the value of the import property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the import property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TImport }
     * 
     * 
     */
    public List<TImport> getImport() {
        if (_import == null) {
            _import = new ArrayList<TImport>();
        }
        return this._import;
    }

    /**
     * Gets the value of the caseFileItemDefinition property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the caseFileItemDefinition property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCaseFileItemDefinition().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCaseFileItemDefinition }
     * 
     * 
     */
    public List<TCaseFileItemDefinition> getCaseFileItemDefinition() {
        if (caseFileItemDefinition == null) {
            caseFileItemDefinition = new ArrayList<TCaseFileItemDefinition>();
        }
        return this.caseFileItemDefinition;
    }

    /**
     * Gets the value of the case property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the case property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCase().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TCase }
     * 
     * 
     */
    public List<TCase> getCase() {
        if (_case == null) {
            _case = new ArrayList<TCase>();
        }
        return this._case;
    }

    /**
     * Gets the value of the process property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the process property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TProcess }
     * 
     * 
     */
    public List<TProcess> getProcess() {
        if (process == null) {
            process = new ArrayList<TProcess>();
        }
        return this.process;
    }

    /**
     * Gets the value of the decision property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the decision property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDecision().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TDecision }
     * 
     * 
     */
    public List<TDecision> getDecision() {
        if (decision == null) {
            decision = new ArrayList<TDecision>();
        }
        return this.decision;
    }

    /**
     * Gets the value of the extensionElements property.
     * 
     * @return
     *     possible object is
     *     {@link TExtensionElements }
     *     
     */
    public TExtensionElements getExtensionElements() {
        return extensionElements;
    }

    /**
     * Sets the value of the extensionElements property.
     * 
     * @param value
     *     allowed object is
     *     {@link TExtensionElements }
     *     
     */
    public void setExtensionElements(TExtensionElements value) {
        this.extensionElements = value;
    }

    /**
     * Gets the value of the relationship property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the relationship property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRelationship().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TRelationship }
     * 
     * 
     */
    public List<TRelationship> getRelationship() {
        if (relationship == null) {
            relationship = new ArrayList<TRelationship>();
        }
        return this.relationship;
    }

    /**
     * Gets the value of the artifact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the artifact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArtifact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link TAssociation }{@code >}
     * {@link JAXBElement }{@code <}{@link TArtifact }{@code >}
     * {@link JAXBElement }{@code <}{@link TTextAnnotation }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends TArtifact>> getArtifact() {
        if (artifact == null) {
            artifact = new ArrayList<JAXBElement<? extends TArtifact>>();
        }
        return this.artifact;
    }

    /**
     * Gets the value of the cmmndi property.
     * 
     * @return
     *     possible object is
     *     {@link CMMNDI }
     *     
     */
    public CMMNDI getCMMNDI() {
        return cmmndi;
    }

    /**
     * Sets the value of the cmmndi property.
     * 
     * @param value
     *     allowed object is
     *     {@link CMMNDI }
     *     
     */
    public void setCMMNDI(CMMNDI value) {
        this.cmmndi = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
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

    /**
     * Gets the value of the targetNamespace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTargetNamespace() {
        return targetNamespace;
    }

    /**
     * Sets the value of the targetNamespace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTargetNamespace(String value) {
        this.targetNamespace = value;
    }

    /**
     * Gets the value of the expressionLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpressionLanguage() {
        if (expressionLanguage == null) {
            return "http://www.w3.org/1999/XPath";
        } else {
            return expressionLanguage;
        }
    }

    /**
     * Sets the value of the expressionLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpressionLanguage(String value) {
        this.expressionLanguage = value;
    }

    /**
     * Gets the value of the exporter property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExporter() {
        return exporter;
    }

    /**
     * Sets the value of the exporter property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExporter(String value) {
        this.exporter = value;
    }

    /**
     * Gets the value of the exporterVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExporterVersion() {
        return exporterVersion;
    }

    /**
     * Sets the value of the exporterVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExporterVersion(String value) {
        this.exporterVersion = value;
    }

    /**
     * Gets the value of the author property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the value of the author property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationDate(XMLGregorianCalendar value) {
        this.creationDate = value;
    }

    /**
     * Gets a map that contains attributes that aren't bound to any typed property on this class.
     * 
     * <p>
     * the map is keyed by the name of the attribute and 
     * the value is the string value of the attribute.
     * 
     * the map returned by this method is live, and you can add new attribute
     * by updating the map directly. Because of this design, there's no setter.
     * 
     * 
     * @return
     *     always non-null
     */
    public Map<QName, String> getOtherAttributes() {
        return otherAttributes;
    }

    public TDefinitions withImport(TImport... values) {
        if (values!= null) {
            for (TImport value: values) {
                getImport().add(value);
            }
        }
        return this;
    }

    public TDefinitions withImport(Collection<TImport> values) {
        if (values!= null) {
            getImport().addAll(values);
        }
        return this;
    }

    public TDefinitions withCaseFileItemDefinition(TCaseFileItemDefinition... values) {
        if (values!= null) {
            for (TCaseFileItemDefinition value: values) {
                getCaseFileItemDefinition().add(value);
            }
        }
        return this;
    }

    public TDefinitions withCaseFileItemDefinition(Collection<TCaseFileItemDefinition> values) {
        if (values!= null) {
            getCaseFileItemDefinition().addAll(values);
        }
        return this;
    }

    public TDefinitions withCase(TCase... values) {
        if (values!= null) {
            for (TCase value: values) {
                getCase().add(value);
            }
        }
        return this;
    }

    public TDefinitions withCase(Collection<TCase> values) {
        if (values!= null) {
            getCase().addAll(values);
        }
        return this;
    }

    public TDefinitions withProcess(TProcess... values) {
        if (values!= null) {
            for (TProcess value: values) {
                getProcess().add(value);
            }
        }
        return this;
    }

    public TDefinitions withProcess(Collection<TProcess> values) {
        if (values!= null) {
            getProcess().addAll(values);
        }
        return this;
    }

    public TDefinitions withDecision(TDecision... values) {
        if (values!= null) {
            for (TDecision value: values) {
                getDecision().add(value);
            }
        }
        return this;
    }

    public TDefinitions withDecision(Collection<TDecision> values) {
        if (values!= null) {
            getDecision().addAll(values);
        }
        return this;
    }

    public TDefinitions withExtensionElements(TExtensionElements value) {
        setExtensionElements(value);
        return this;
    }

    public TDefinitions withRelationship(TRelationship... values) {
        if (values!= null) {
            for (TRelationship value: values) {
                getRelationship().add(value);
            }
        }
        return this;
    }

    public TDefinitions withRelationship(Collection<TRelationship> values) {
        if (values!= null) {
            getRelationship().addAll(values);
        }
        return this;
    }

    public TDefinitions withArtifact(JAXBElement<? extends TArtifact> ... values) {
        if (values!= null) {
            for (JAXBElement<? extends TArtifact> value: values) {
                getArtifact().add(value);
            }
        }
        return this;
    }

    public TDefinitions withArtifact(Collection<JAXBElement<? extends TArtifact>> values) {
        if (values!= null) {
            getArtifact().addAll(values);
        }
        return this;
    }

    public TDefinitions withCMMNDI(CMMNDI value) {
        setCMMNDI(value);
        return this;
    }

    public TDefinitions withId(String value) {
        setId(value);
        return this;
    }

    public TDefinitions withName(String value) {
        setName(value);
        return this;
    }

    public TDefinitions withTargetNamespace(String value) {
        setTargetNamespace(value);
        return this;
    }

    public TDefinitions withExpressionLanguage(String value) {
        setExpressionLanguage(value);
        return this;
    }

    public TDefinitions withExporter(String value) {
        setExporter(value);
        return this;
    }

    public TDefinitions withExporterVersion(String value) {
        setExporterVersion(value);
        return this;
    }

    public TDefinitions withAuthor(String value) {
        setAuthor(value);
        return this;
    }

    public TDefinitions withCreationDate(XMLGregorianCalendar value) {
        setCreationDate(value);
        return this;
    }

}
