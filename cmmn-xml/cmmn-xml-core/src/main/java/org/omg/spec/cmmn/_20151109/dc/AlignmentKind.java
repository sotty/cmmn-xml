
package org.omg.spec.cmmn._20151109.dc;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AlignmentKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="AlignmentKind"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="start"/&gt;
 *     &lt;enumeration value="end"/&gt;
 *     &lt;enumeration value="center"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AlignmentKind")
@XmlEnum
public enum AlignmentKind {

    @XmlEnumValue("start")
    START("start"),
    @XmlEnumValue("end")
    END("end"),
    @XmlEnumValue("center")
    CENTER("center");
    private final String value;

    AlignmentKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static AlignmentKind fromValue(String v) {
        for (AlignmentKind c: AlignmentKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
