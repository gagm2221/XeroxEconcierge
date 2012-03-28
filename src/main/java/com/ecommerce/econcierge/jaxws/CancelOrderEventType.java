package com.ecommerce.econcierge.jaxws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for CancelOrderEventType complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="CancelOrderEventType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cancelOrderRequest" type="{http://ws.order.esb.sdp.hcl.com/}CancelOrderRequest" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CancelOrderEventType", propOrder =
{ "cancelOrderRequest" })
public class CancelOrderEventType
{

	@XmlElement(required = true)
	protected List<CancelOrderRequest> cancelOrderRequest;

	/**
	 * Gets the value of the cancelOrderRequest property.
	 * 
	 * <p>
	 * This accessor method returns a reference to the live list, not a snapshot.
	 * Therefore any modification you make to the returned list will be present
	 * inside the JAXB object. This is why there is not a <CODE>set</CODE> method
	 * for the cancelOrderRequest property.
	 * 
	 * <p>
	 * For example, to add a new item, do as follows:
	 * 
	 * <pre>
	 * getCancelOrderRequest().add(newItem);
	 * </pre>
	 * 
	 * 
	 * <p>
	 * Objects of the following type(s) are allowed in the list
	 * {@link CancelOrderRequest }
	 * 
	 * 
	 */
	public List<CancelOrderRequest> getCancelOrderRequest()
	{
		if (cancelOrderRequest == null)
		{
			cancelOrderRequest = new ArrayList<CancelOrderRequest>();
		}
		return this.cancelOrderRequest;
	}

}
