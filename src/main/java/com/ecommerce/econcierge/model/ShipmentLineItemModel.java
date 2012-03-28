package com.ecommerce.econcierge.model;

/**
 * Line item for shipment notification
 * 
 * @author EDavid
 * 
 */
public class ShipmentLineItemModel
{
	private String mfgPartNumber;
	private int dispatchedQuantity;
	private String shipmentTrackingNumber;
	private String shipmentTrackingURL;
	public String getMfgPartNumber()
	{
		return mfgPartNumber;
	}
	public void setMfgPartNumber(String mfgPartNumber)
	{
		this.mfgPartNumber = mfgPartNumber;
	}
	public int getDispatchedQuantity()
	{
		return dispatchedQuantity;
	}
	public void setDispatchedQuantity(int dispatchedQuantity)
	{
		this.dispatchedQuantity = dispatchedQuantity;
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
	
	
}
