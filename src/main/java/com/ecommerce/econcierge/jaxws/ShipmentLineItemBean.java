package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ShipmentLineItemBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentLineItemBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mfgPartNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dispatchedQuantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shipmentTrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentTrackingURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentLineItemBean", propOrder =
{ "mfgPartNumber", "dispatchedQuantity", "shipmentTrackingNumber", "shipmentTrackingURL" })
public class ShipmentLineItemBean
{

	@XmlElement(required = true)
	protected String mfgPartNumber;
	protected int dispatchedQuantity;
	protected String shipmentTrackingNumber;
	protected String shipmentTrackingURL;

	/**
	 * Gets the value of the mfgPartNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMfgPartNumber()
	{
		return mfgPartNumber;
	}

	/**
	 * Sets the value of the mfgPartNumber property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setMfgPartNumber(String value)
	{
		this.mfgPartNumber = value;
	}

	/**
	 * Gets the value of the dispatchedQuantity property.
	 * 
	 */
	public int getDispatchedQuantity()
	{
		return dispatchedQuantity;
	}

	/**
	 * Sets the value of the dispatchedQuantity property.
	 * 
	 */
	public void setDispatchedQuantity(int value)
	{
		this.dispatchedQuantity = value;
	}

	/**
	 * Gets the value of the shipmentTrackingNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShipmentTrackingNumber()
	{
		return shipmentTrackingNumber;
	}

	/**
	 * Sets the value of the shipmentTrackingNumber property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setShipmentTrackingNumber(String value)
	{
		this.shipmentTrackingNumber = value;
	}

	/**
	 * Gets the value of the shipmentTrackingURL property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getShipmentTrackingURL()
	{
		return shipmentTrackingURL;
	}

	/**
	 * Sets the value of the shipmentTrackingURL property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setShipmentTrackingURL(String value)
	{
		this.shipmentTrackingURL = value;
	}

}
