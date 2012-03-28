package com.ecommerce.econcierge.model;

/**
 * Model for order status
 * 
 * @author EDavid
 * 
 */
public class OrderStatusModel
{
	public static final boolean ALREADY_SENT_STATUS = true;

	private String tbOrderNumber;
	private String npOrderNumber;
	private boolean sentStatus;
	private boolean stopShippingNotification;

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

	public boolean isSentStatus()
	{
		return sentStatus;
	}

	public void setSentStatus(boolean sentStatus)
	{
		this.sentStatus = sentStatus;
	}

	public boolean isStopShippingNotification()
	{
		return stopShippingNotification;
	}

	public void setStopShippingNotification(boolean stopShippingNotification)
	{
		this.stopShippingNotification = stopShippingNotification;
	}

}
