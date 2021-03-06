
package org.omg.spec.cmmn._20151109.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for MultiplicityEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="MultiplicityEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="ZeroOrOne"/&gt;
 *     &lt;enumeration value="ZeroOrMore"/&gt;
 *     &lt;enumeration value="ExactlyOne"/&gt;
 *     &lt;enumeration value="OneOrMore"/&gt;
 *     &lt;enumeration value="Unspecified"/&gt;
 *     &lt;enumeration value="Unknown"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "MultiplicityEnum")
@XmlEnum
public enum MultiplicityEnum {

    @XmlEnumValue("ZeroOrOne")
    ZERO_OR_ONE("ZeroOrOne"),
    @XmlEnumValue("ZeroOrMore")
    ZERO_OR_MORE("ZeroOrMore"),
    @XmlEnumValue("ExactlyOne")
    EXACTLY_ONE("ExactlyOne"),
    @XmlEnumValue("OneOrMore")
    ONE_OR_MORE("OneOrMore"),
    @XmlEnumValue("Unspecified")
    UNSPECIFIED("Unspecified"),
    @XmlEnumValue("Unknown")
    UNKNOWN("Unknown");
    private final String value;

    MultiplicityEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MultiplicityEnum fromValue(String v) {
        for (MultiplicityEnum c: MultiplicityEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
