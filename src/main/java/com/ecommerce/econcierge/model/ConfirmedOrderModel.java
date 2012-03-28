package com.ecommerce.econcierge.model;

/**
 * Model for confirmed orders
 * 
 * @author EDavid
 * 
 */
public class ConfirmedOrderModel
{
	private String tbOrderNumber;
	private String npOrderNumber;
	private String firstName;
	private String lastName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private double totalAmount;
	private double totalTax;
	private double shippingFee;
	private double discount;
	private double subTotal;

	private OrderLineItemModel orderLineItem;

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

	public double getTotalAmount()
	{
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount)
	{
		this.totalAmount = totalAmount;
	}

	public double getTotalTax()
	{
		return totalTax;
	}

	public void setTotalTax(double totalTax)
	{
		this.totalTax = totalTax;
	}

	public double getShippingFee()
	{
		return shippingFee;
	}

	public void setShippingFee(double shippingFee)
	{
		this.shippingFee = shippingFee;
	}

	public double getDiscount()
	{
		return discount;
	}

	public void setDiscount(double discount)
	{
		this.discount = discount;
	}

	public double getSubTotal()
	{
		return subTotal;
	}

	public void setSubTotal(double subTotal)
	{
		this.subTotal = subTotal;
	}

	public OrderLineItemModel getOrderLineItem()
	{
		return orderLineItem;
	}

	public void setOrderLineItem(OrderLineItemModel orderLineItem)
	{
		this.orderLineItem = orderLineItem;
	}

}
