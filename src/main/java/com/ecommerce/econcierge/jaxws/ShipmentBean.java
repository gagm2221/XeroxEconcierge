package com.ecommerce.econcierge.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Java class for ShipmentBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="ShipmentBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tbOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="npOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="shipDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="carrierCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentTrackingNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentTrackingURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="shipmentLineItem" type="{http://ws.order.esb.sdp.hcl.com/}ShipmentLineItemBean" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ShipmentBean", propOrder =
{ "tbOrderNumber", "npOrderNumber", "shipDate", "firstName", "lastName", "addressLine1", "addressLine2", "city", "state", "zipCode", "country", "carrierCode",
		"shipmentTrackingNumber", "shipmentTrackingURL", "shipmentLineItem" })
public class ShipmentBean
{

	@XmlElement(required = true)
	protected String tbOrderNumber;
	@XmlElement(required = true)
	protected String npOrderNumber;
	@XmlSchemaType(name = "dateTime")
	protected XMLGregorianCalendar shipDate;
	protected String firstName;
	protected String lastName;
	protected String addressLine1;
	protected String addressLine2;
	protected String city;
	protected String state;
	protected String zipCode;
	protected String country;
	protected String carrierCode;
	protected String shipmentTrackingNumber;
	protected String shipmentTrackingURL;
	@XmlElement(required = true)
	protected List<ShipmentLineItemBean> shipmentLineItem;

	/**
	 * Gets the value of the tbOrderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getTbOrderNumber()
	{
		return tbOrderNumber;
	}

	/**
	 * Sets the value of the tbOrderNumber property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setTbOrderNumber(String value)
	{
		this.tbOrderNumber = value;
	}

	/**
	 * Gets the value of the npOrderNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNpOrderNumber()
	{
		return npOrderNumber;
	}

	/**
	 * Sets the value of the npOrderNumber property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setNpOrderNumber(String value)
	{
		this.npOrderNumber = value;
	}

	/**
	 * Gets the value of the shipDate property.
	 * 
	 * @return possible object is {@link XMLGregorianCalendar }
	 * 
	 */
	public XMLGregorianCalendar getShipDate()
	{
		return shipDate;
	}

	/**
	 * Sets the value of the shipDate property.
	 * 
	 * @param value
	 *           allowed object is {@link XMLGregorianCalendar }
	 * 
	 */
	public void setShipDate(XMLGregorianCalendar value)
	{
		this.shipDate = value;
	}

	/**
	 * Gets the value of the firstName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * Sets the value of the firstName property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setFirstName(String value)
	{
		this.firstName = value;
	}

	/**
	 * Gets the value of the lastName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * Sets the value of the lastName property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setLastName(String value)
	{
		this.lastName = value;
	}

	/**
	 * Gets the value of the addressLine1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressLine1()
	{
		return addressLine1;
	}

	/**
	 * Sets the value of the addressLine1 property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setAddressLine1(String value)
	{
		this.addressLine1 = value;
	}

	/**
	 * Gets the value of the addressLine2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressLine2()
	{
		return addressLine2;
	}

	/**
	 * Sets the value of the addressLine2 property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setAddressLine2(String value)
	{
		this.addressLine2 = value;
	}

	/**
	 * Gets the value of the city property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * Sets the value of the city property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setCity(String value)
	{
		this.city = value;
	}

	/**
	 * Gets the value of the state property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * Sets the value of the state property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setState(String value)
	{
		this.state = value;
	}

	/**
	 * Gets the value of the zipCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getZipCode()
	{
		return zipCode;
	}

	/**
	 * Sets the value of the zipCode property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setZipCode(String value)
	{
		this.zipCode = value;
	}

	/**
	 * Gets the value of the country property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCountry()
	{
		return country;
	}

	/**
	 * Sets the value of the country property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setCountry(String value)
	{
		this.country = value;
	}

	/**
	 * Gets the value of the carrierCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCarrierCode()
	{
		return carrierCode;
	}

	/**
	 * Sets the value of the carrierCode property.
	 * 
	 * @param value
	 *           allowed object is {@link String }
	 * 
	 */
	public void setCarrierCode(String value)
	{
		this.carrierCode = value;
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

	/**
	 * Gets the value of the shipmentLineItem property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the shipmentLineItem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getShipmentLineItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link ShipmentLineItemBean }
	 * 
	 * 
	 */
	public List<ShipmentLineItemBean> getShipmentLineItem()
	{
		if (shipmentLineItem == null)
		{
			shipmentLineItem = new ArrayList<ShipmentLineItemBean>();
		}
		return this.shipmentLineItem;
	}

}
