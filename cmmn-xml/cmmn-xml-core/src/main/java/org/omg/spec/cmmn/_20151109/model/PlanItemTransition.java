
package org.omg.spec.cmmn._20151109.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlanItemTransition.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlanItemTransition"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="close"/&gt;
 *     &lt;enumeration value="complete"/&gt;
 *     &lt;enumeration value="create"/&gt;
 *     &lt;enumeration value="disable"/&gt;
 *     &lt;enumeration value="enable"/&gt;
 *     &lt;enumeration value="exit"/&gt;
 *     &lt;enumeration value="fault"/&gt;
 *     &lt;enumeration value="manualStart"/&gt;
 *     &lt;enumeration value="occur"/&gt;
 *     &lt;enumeration value="parentResume"/&gt;
 *     &lt;enumeration value="parentSuspend"/&gt;
 *     &lt;enumeration value="reactivate"/&gt;
 *     &lt;enumeration value="reenable"/&gt;
 *     &lt;enumeration value="resume"/&gt;
 *     &lt;enumeration value="start"/&gt;
 *     &lt;enumeration value="suspend"/&gt;
 *     &lt;enumeration value="terminate"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "PlanItemTransition")
@XmlEnum
public enum PlanItemTransition {

    @XmlEnumValue("close")
    CLOSE("close"),
    @XmlEnumValue("complete")
    COMPLETE("complete"),
    @XmlEnumValue("create")
    CREATE("create"),
    @XmlEnumValue("disable")
    DISABLE("disable"),
    @XmlEnumValue("enable")
    ENABLE("enable"),
    @XmlEnumValue("exit")
    EXIT("exit"),
    @XmlEnumValue("fault")
    FAULT("fault"),
    @XmlEnumValue("manualStart")
    MANUAL_START("manualStart"),
    @XmlEnumValue("occur")
    OCCUR("occur"),
    @XmlEnumValue("parentResume")
    PARENT_RESUME("parentResume"),
    @XmlEnumValue("parentSuspend")
    PARENT_SUSPEND("parentSuspend"),
    @XmlEnumValue("reactivate")
    REACTIVATE("reactivate"),
    @XmlEnumValue("reenable")
    REENABLE("reenable"),
    @XmlEnumValue("resume")
    RESUME("resume"),
    @XmlEnumValue("start")
    START("start"),
    @XmlEnumValue("suspend")
    SUSPEND("suspend"),
    @XmlEnumValue("terminate")
    TERMINATE("terminate");
    private final String value;

    PlanItemTransition(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlanItemTransition fromValue(String v) {
        for (PlanItemTransition c: PlanItemTransition.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
