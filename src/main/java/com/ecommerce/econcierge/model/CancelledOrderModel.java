package com.ecommerce.econcierge.model;

/**
 * Model for cancelled order
 * 
 * @author EDavid
 * 
 */
public class CancelledOrderModel
{
	private String tbOrderNumber;
	private String npOrderNumber;

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

}
