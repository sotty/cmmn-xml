
package org.omg.spec.cmmn._20151109.di;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.omg.spec.cmmn._20151109.dc.Point;


/**
 * <p>Java class for Edge complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Edge">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.omg.org/spec/CMMN/20151109/DI}DiagramElement">
 *       &lt;sequence>
 *         &lt;element name="waypoint" type="{http://www.omg.org/spec/CMMN/20151109/DC}Point" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;anyAttribute processContents='lax' namespace='##other'/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Edge", propOrder = {
    "waypoints"
})
public abstract class Edge
    extends DiagramElement
{

    @XmlElement(name = "waypoint")
    protected List<Point> waypoints;

    /**
     * Gets the value of the waypoints property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the waypoints property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWaypoints().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Point }
     * 
     * 
     */
    public List<Point> getWaypoints() {
        if (waypoints == null) {
            waypoints = new ArrayList<Point>();
        }
        return this.waypoints;
    }

    public boolean isSetWaypoints() {
        return ((this.waypoints!= null)&&(!this.waypoints.isEmpty()));
    }

    public void unsetWaypoints() {
        this.waypoints = null;
    }

    public Edge withWaypoints(Point... values) {
        if (values!= null) {
            for (Point value: values) {
                getWaypoints().add(value);
            }
        }
        return this;
    }

    public Edge withWaypoints(Collection<Point> values) {
        if (values!= null) {
            getWaypoints().addAll(values);
        }
        return this;
    }

    @Override
    public Edge withExtension(DiagramElement.Extension value) {
        setExtension(value);
        return this;
    }

    @Override
    public Edge withStyle(Style value) {
        setStyle(value);
        return this;
    }

    @Override
    public Edge withSharedStyle(Object value) {
        setSharedStyle(value);
        return this;
    }

    @Override
    public Edge withId(String value) {
        setId(value);
        return this;
    }

}
