
package org.omg.spec.cmmn._20151109.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CaseFileItemTransition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CaseFileItemTransition"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="addChild"/&gt;
 *     &lt;enumeration value="addReference"/&gt;
 *     &lt;enumeration value="create"/&gt;
 *     &lt;enumeration value="delete"/&gt;
 *     &lt;enumeration value="removeChild"/&gt;
 *     &lt;enumeration value="removeReference"/&gt;
 *     &lt;enumeration value="replace"/&gt;
 *     &lt;enumeration value="update"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "CaseFileItemTransition")
@XmlEnum
public enum CaseFileItemTransition {

    @XmlEnumValue("addChild")
    ADD_CHILD("addChild"),
    @XmlEnumValue("addReference")
    ADD_REFERENCE("addReference"),
    @XmlEnumValue("create")
    CREATE("create"),
    @XmlEnumValue("delete")
    DELETE("delete"),
    @XmlEnumValue("removeChild")
    REMOVE_CHILD("removeChild"),
    @XmlEnumValue("removeReference")
    REMOVE_REFERENCE("removeReference"),
    @XmlEnumValue("replace")
    REPLACE("replace"),
    @XmlEnumValue("update")
    UPDATE("update");
    private final String value;

    CaseFileItemTransition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CaseFileItemTransition fromValue(String v) {
        for (CaseFileItemTransition c: CaseFileItemTransition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
