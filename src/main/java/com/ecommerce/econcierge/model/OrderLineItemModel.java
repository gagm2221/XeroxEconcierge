package com.ecommerce.econcierge.model;

/**
 * Line item for confirmed orders
 * 
 * @author EDavid
 * 
 */
public class OrderLineItemModel
{
	protected String mfgPartNumber;
	protected int quantity;
	protected double unitPrice;
	public String getMfgPartNumber()
	{
		return mfgPartNumber;
	}
	public void setMfgPartNumber(String mfgPartNumber)
	{
		this.mfgPartNumber = mfgPartNumber;
	}
	public int getQuantity()
	{
		return quantity;
	}
	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
	}
	public double getUnitPrice()
	{
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice)
	{
		this.unitPrice = unitPrice;
	}
	
	
}
