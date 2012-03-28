package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for OrderLineItemBean complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="OrderLineItemBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mfgPartNumber" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OrderLineItemBean", propOrder =
{ "mfgPartNumber", "quantity", "unitPrice" })
public class OrderLineItemBean
{

	@XmlElement(required = true)
	protected String mfgPartNumber;
	protected int quantity;
	protected double unitPrice;

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
	 * Gets the value of the quantity property.
	 * 
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * Sets the value of the quantity property.
	 * 
	 */
	public void setQuantity(int value)
	{
		this.quantity = value;
	}

	/**
	 * Gets the value of the unitPrice property.
	 * 
	 */
	public double getUnitPrice()
	{
		return unitPrice;
	}

	/**
	 * Sets the value of the unitPrice property.
	 * 
	 */
	public void setUnitPrice(double value)
	{
		this.unitPrice = value;
	}

}
