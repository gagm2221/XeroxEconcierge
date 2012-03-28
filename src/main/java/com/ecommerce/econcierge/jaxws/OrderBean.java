package com.ecommerce.econcierge.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OrderBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="OrderBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tbOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="npOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="addressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="state" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="zipCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="totalAmount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="totalTax" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="shippingFee" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="discount" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="subTotal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="orderLineItem" type="{http://ws.order.esb.sdp.hcl.com/}OrderLineItemBean" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderBean", propOrder =
{ "tbOrderNumber", "npOrderNumber", "firstName", "lastName", "addressLine1", "addressLine2", "city", "state", "zipCode", "country", "totalAmount", "totalTax",
		"shippingFee", "discount", "subTotal", "orderLineItem" })
public class OrderBean
{

	@XmlElement(required = true)
	protected String tbOrderNumber;
	@XmlElement(required = true)
	protected String npOrderNumber;
	protected String firstName;
	protected String lastName;
	protected String addressLine1;
	protected String addressLine2;
	protected String city;
	protected String state;
	protected String zipCode;
	protected String country;
	protected double totalAmount;
	protected double totalTax;
	protected double shippingFee;
	protected double discount;
	protected double subTotal;
	@XmlElement(required = true)
	protected List<OrderLineItemBean> orderLineItem;

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
	 * Gets the value of the totalAmount property.
	 * 
	 */
	public double getTotalAmount()
	{
		return totalAmount;
	}

	/**
	 * Sets the value of the totalAmount property.
	 * 
	 */
	public void setTotalAmount(double value)
	{
		this.totalAmount = value;
	}

	/**
	 * Gets the value of the totalTax property.
	 * 
	 */
	public double getTotalTax()
	{
		return totalTax;
	}

	/**
	 * Sets the value of the totalTax property.
	 * 
	 */
	public void setTotalTax(double value)
	{
		this.totalTax = value;
	}

	/**
	 * Gets the value of the shippingFee property.
	 * 
	 */
	public double getShippingFee()
	{
		return shippingFee;
	}

	/**
	 * Sets the value of the shippingFee property.
	 * 
	 */
	public void setShippingFee(double value)
	{
		this.shippingFee = value;
	}

	/**
	 * Gets the value of the discount property.
	 * 
	 */
	public double getDiscount()
	{
		return discount;
	}

	/**
	 * Sets the value of the discount property.
	 * 
	 */
	public void setDiscount(double value)
	{
		this.discount = value;
	}

	/**
	 * Gets the value of the subTotal property.
	 * 
	 */
	public double getSubTotal()
	{
		return subTotal;
	}

	/**
	 * Sets the value of the subTotal property.
	 * 
	 */
	public void setSubTotal(double value)
	{
		this.subTotal = value;
	}

	/**
	 * Gets the value of the orderLineItem property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the orderLineItem property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getOrderLineItem().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link OrderLineItemBean }
	 * 
	 * 
	 */
	public List<OrderLineItemBean> getOrderLineItem()
	{
		if (orderLineItem == null)
		{
			orderLineItem = new ArrayList<OrderLineItemBean>();
		}
		return this.orderLineItem;
	}

}
