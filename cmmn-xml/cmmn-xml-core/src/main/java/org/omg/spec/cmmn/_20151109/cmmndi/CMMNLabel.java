
package org.omg.spec.cmmn._20151109.cmmndi;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.omg.spec.cmmn._20151109.dc.Bounds;
import org.omg.spec.cmmn._20151109.di.Shape;
import org.omg.spec.cmmn._20151109.di.Style;


/**
 * <p>Java class for CMMNLabel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CMMNLabel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}Shape"&gt;
 *       &lt;anyAttribute processContents='lax' namespace='##other'/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CMMNLabel")
public class CMMNLabel
    extends Shape
{


    @Override
    public CMMNLabel withBounds(Bounds value) {
        setBounds(value);
        return this;
    }

    @Override
    public CMMNLabel withExtension(org.omg.spec.cmmn._20151109.di.DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    @Override
    public CMMNLabel withStyle(JAXBElement<? extends Style> value) {
        setStyle(value);
        return this;
    }

    @Override
    public CMMNLabel withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    @Override
    public CMMNLabel withId(String value) {
        setId(value);
        return this;
    }

}
