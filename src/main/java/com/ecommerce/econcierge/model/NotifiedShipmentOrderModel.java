package com.ecommerce.econcierge.model;

import java.util.Date;
import java.util.List;

/**
 * Model for shipment notifications
 * 
 * @author EDavid
 * 
 */
public class NotifiedShipmentOrderModel
{
	private String tbOrderNumber;
	private String npOrderNumber;
	private Date shipDate;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String carrierCode;
	private String shipmentTrackingNumber;
	private String shipmentTrackingURL;
	
	private List<ShipmentLineItemModel> shipmentLineItem;

	public String getTbOrderNumber()
	{
		return tbOrderNumber;
	}

	public void setTbOrderNumber(String tbOrderNumber)
	{
		this.tbOrderNumber = tbOrderNumber;
	}

	public String getNpOrderNumber()
	{
		return npOrderNumber;
	}

	public void setNpOrderNumber(String npOrderNumber)
	{
		this.npOrderNumber = npOrderNumber;
	}

	public Date getShipDate()
	{
		return shipDate;
	}

	public void setShipDate(Date shipDate)
	{
		this.shipDate = shipDate;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getAddressLine1()
	{
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1)
	{
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2()
	{
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2)
	{
		this.addressLine2 = addressLine2;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public String getCarrierCode()
	{
		return carrierCode;
	}

	public void setCarrierCode(String carrierCode)
	{
		this.carrierCode = carrierCode;
	}

	public String getShipmentTrackingNumber()
	{
		return shipmentTrackingNumber;
	}

	public void setShipmentTrackingNumber(String shipmentTrackingNumber)
	{
		this.shipmentTrackingNumber = shipmentTrackingNumber;
	}

	public String getShipmentTrackingURL()
	{
		return shipmentTrackingURL;
	}

	public void setShipmentTrackingURL(String shipmentTrackingURL)
	{
		this.shipmentTrackingURL = shipmentTrackingURL;
	}

	public List<ShipmentLineItemModel> getShipmentLineItem()
	{
		return shipmentLineItem;
	}

	public void setShipmentLineItem(List<ShipmentLineItemModel> shipmentLineItem)
	{
		this.shipmentLineItem = shipmentLineItem;
	}
	
	
}
