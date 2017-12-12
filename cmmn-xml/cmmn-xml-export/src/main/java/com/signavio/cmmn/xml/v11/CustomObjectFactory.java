package com.signavio.cmmn.xml.v11;

import org.omg.spec.CMMN.xml.v11.CMMNObjectFactory;

import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

@XmlRegistry
public class CustomObjectFactory extends CMMNObjectFactory {

    // Signavio additional meta-attributes

    public static final QName QNAME_SIGNAVIO_SHAPE_ID           = new QName(Constants.NS_SCHEMA_SIGNAVIO, "shapeId");
    public static final QName QNAME_SIGNAVIO_DIAGRAM_ID         = new QName(Constants.NS_SCHEMA_SIGNAVIO, "diagramId");
    public static final QName QNAME_SIGNAVIO_DIAGRAM_MD         = new QName(Constants.NS_SCHEMA_SIGNAVIO, "diagramMetaData");
    public static final QName QNAME_SIGNAVIO_GLOSSARY_ID        = new QName(Constants.NS_SCHEMA_SIGNAVIO, "glossaryId");
	public static final QName QNAME_SIGNAVIO_REVISION_ID        = new QName(Constants.NS_SCHEMA_SIGNAVIO, "revisionId");
	public static final QName QNAME_SIGNAVIO_REVISION_NUMBER    = new QName(Constants.NS_SCHEMA_SIGNAVIO, "revisionNumber");

}

