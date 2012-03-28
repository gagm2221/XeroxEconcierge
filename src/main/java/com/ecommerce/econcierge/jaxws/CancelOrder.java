package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for cancelOrder complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="cancelOrder">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ws.order.esb.sdp.hcl.com/}CancelOrderEventType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cancelOrder", propOrder =
{ "arg0" })
public class CancelOrder
{

	protected CancelOrderEventType arg0;

	/**
	 * Gets the value of the arg0 property.
	 * 
	 * @return possible object is {@link CancelOrderEventType }
	 * 
	 */
	public CancelOrderEventType getArg0()
	{
		return arg0;
	}

	/**
	 * Sets the value of the arg0 property.
	 * 
	 * @param value
	 *           allowed object is {@link CancelOrderEventType }
	 * 
	 */
	public void setArg0(CancelOrderEventType value)
	{
		this.arg0 = value;
	}

}
