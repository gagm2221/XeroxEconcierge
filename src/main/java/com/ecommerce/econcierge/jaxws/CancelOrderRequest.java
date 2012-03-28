package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CancelOrderRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CancelOrderRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tbOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="npOrderNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelOrderRequest", propOrder =
{ "tbOrderNumber", "npOrderNumber" })
public class CancelOrderRequest
{

	@XmlElement(required = true)
	protected String tbOrderNumber;
	@XmlElement(required = true)
	protected String npOrderNumber;

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

}
