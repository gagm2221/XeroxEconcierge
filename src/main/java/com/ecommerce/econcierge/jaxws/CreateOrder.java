package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for createOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="createOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ws.order.esb.sdp.hcl.com/}OrderEventType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "createOrder", propOrder =
{ "arg0" })
public class CreateOrder
{

	protected OrderEventType arg0;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 * @return possible object is {@link OrderEventType }
	 * 
	 */
	public OrderEventType getArg0()
	{
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 * @param value
	 *           allowed object is {@link OrderEventType }
	 * 
	 */
	public void setArg0(OrderEventType value)
	{
		this.arg0 = value;
	}

}
