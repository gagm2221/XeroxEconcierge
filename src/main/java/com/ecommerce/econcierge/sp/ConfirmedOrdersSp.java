package com.ecommerce.econcierge.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.econcierge.model.ConfirmedOrderModel;

public interface ConfirmedOrdersSp extends GetXeroxOrdersSp
{

	/**
	 * For the Confirmed Status
	 */
	String CONFIRMED_STATUS = "Point of Sale";

	/**
	 * Return static variables
	 */
	String RESULT = "result";

	/**
	 * Execute SP
	 */
	List<ConfirmedOrderModel> execute() throws DataAccessException;

	/**
	 * Row mapper for Order Confirmation SP
	 * 
	 * @author edavid
	 * 
	 */
	class OrderConfirmationRowMapper implements RowMapper<ConfirmedOrderRow>
	{
		//header
		private static final String TB_ORDER_NO = "XeroxOrder_No";
		private static final String NP_ORDER_NO = "Order_No";
		private static final String FIRST_NAME = "FirstName";
		private static final String LAST_NAME = "LastName";
		private static final String ADDRESS_LINE_1 = "AddressLine1";
		private static final String ADDRESS_LINE_2 = "AddressLine2";
		private static final String CITY = "City";
		private static final String STATE = "State";
		private static final String ZIPCODE = "ZipCode";
		private static final String COUNTRY = "Country";
		private static final String TOTAL_AMOUNT = "Total_Amount";
		private static final String TOTAL_TAX = "Tax";
		private static final String SHIPPE_FEE = "Shipping";
		private static final String DISCOUNT = "Discount";
		private static final String SUB_TOTAL = "SubTotal";
		//details
		private static final String MFR_PART_NO = "MfrPrn";
		private static final String QUANTITY = "Quantity";
		private static final String UNIT_PRICE = "UnitPrice";

		/*
		 * Map a single row
		 * 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public ConfirmedOrderRow mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			ConfirmedOrderRow o = new ConfirmedOrderRow();
			// header
			o.setTbOrderNumber(rs.getString(TB_ORDER_NO));
			o.setNpOrderNumber(rs.getString(NP_ORDER_NO));
			o.setFirstName(rs.getString(FIRST_NAME));
			o.setLastName(rs.getString(LAST_NAME));
			o.setAddressLine1(rs.getString(ADDRESS_LINE_1));
			o.setAddressLine2(rs.getString(ADDRESS_LINE_2));
			o.setCity(rs.getString(CITY));
			o.setState(rs.getString(STATE));
			o.setZipCode(rs.getString(ZIPCODE));
			o.setCountry(rs.getString(COUNTRY));
			o.setTotalAmount(rs.getDouble(TOTAL_AMOUNT));
			o.setTotalTax(rs.getDouble(TOTAL_TAX));
			o.setShippingFee(rs.getDouble(SHIPPE_FEE));
			o.setDiscount(rs.getDouble(DISCOUNT));
			o.setSubTotal(rs.getDouble(SUB_TOTAL));
			// detail
			o.setMfgPartNumber(rs.getString(MFR_PART_NO));
			o.setQuantity(rs.getInt(QUANTITY));
			o.setUnitPrice(rs.getDouble(UNIT_PRICE));
			return o;
		}

	}

	/**
	 * Holder of Confirmed Order single row
	 * 
	 * @author edavid
	 * 
	 */
	class ConfirmedOrderRow
	{
		// head
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

		// detail
		private String mfgPartNumber;
		private int quantity;
		private double unitPrice;

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
}
