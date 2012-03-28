package com.ecommerce.econcierge.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ShipmentEventType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="shipmentBean" type="{http://ws.order.esb.sdp.hcl.com/}ShipmentBean" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentEventType", propOrder =
{ "shipmentBean" })
public class ShipmentEventType
{

	@XmlElement(required = true)
	protected List<ShipmentBean> shipmentBean;

	/**
	 * Gets the value of the shipmentBean property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the shipmentBean property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getShipmentBean().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ShipmentBean }
	 * 
	 * 
	 */
	public List<ShipmentBean> getShipmentBean()
	{
		if (shipmentBean == null)
		{
			shipmentBean = new ArrayList<ShipmentBean>();
		}
		return this.shipmentBean;
	}

}
