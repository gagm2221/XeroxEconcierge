package com.ecommerce.econcierge.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;

/**
 * SP that will provide all the list of orders for shipment notification
 * 
 * @author EDavid
 * 
 */
public interface ShipmentNotificationSp extends GetXeroxOrdersSp
{
	/**
	 * The map key for result
	 */
	String RESULT = "result";

	/**
	 * Shipment Notification Status
	 */
	String SHIPMENT_NOTIFICATION_STATUS = "ShipmentDetails";

	/**
	 * List all orders for shipment notification
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<NotifiedShipmentOrderModel> execute() throws DataAccessException;

	/**
	 * Row mapper for shipment notification
	 * 
	 * @author EDavid
	 * 
	 */
	class ShipmentNotificationRowMapper implements RowMapper<NotifiedOrderRow>
	{
		// header
		private static final String TB_ORDER_NO = "XeroxOrder_No";
		private static final String NP_ORDER_NO = "Order_No";
		private static final String SHIP_DATE = "ShipDate";
		private static final String FIRST_NAME = "FirstName";
		private static final String LAST_NAME = "LastName";
		private static final String ADDRESS_LINE_1 = "AddressLine1";
		private static final String ADDRESS_LINE_2 = "AddressLine2";
		private static final String CITY = "City";
		private static final String STATE = "State";
		private static final String ZIP_CODE = "ZipCode";
		private static final String COUNTRY = "Country";
		private static final String CARRIER_CODE = "Carrier";
		private static final String SHIPMENT_TRACKING_NUMBER = "ShipTracking_No";
		private static final String SHIPMENT_TRACKING_URL = "ShipTrackingRef_NoURL";
		private static final String SHIPMENT_STATUS = "Status";
		// details
		private static final String MFR_PART_NO = "Mfrprn";
		private static final String QUANTITY = "Qty";

		/*
		 * Get the values form result set
		 * 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public NotifiedOrderRow mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			NotifiedOrderRow o = new NotifiedOrderRow();
			// header
			o.setTbOrderNumber(rs.getString(TB_ORDER_NO));
			o.setNpOrderNumber(rs.getString(NP_ORDER_NO));
			o.setShipDate(rs.getDate(SHIP_DATE));
			o.setFirstName(rs.getString(FIRST_NAME));
			o.setLastName(rs.getString(LAST_NAME));
			o.setAddressLine1(rs.getString(ADDRESS_LINE_1));
			o.setAddressLine2(rs.getString(ADDRESS_LINE_2));
			o.setCity(rs.getString(CITY));
			o.setState(rs.getString(STATE));
			o.setZipCode(rs.getString(ZIP_CODE));
			o.setCountry(rs.getString(COUNTRY));
			o.setCarrierCode(rs.getString(CARRIER_CODE));
			o.setShipmentTrackingNumber(rs.getString(SHIPMENT_TRACKING_NUMBER));
			o.setShipmentTrackingURL(rs.getString(SHIPMENT_TRACKING_URL));
			o.setShipmentStatus(rs.getString(SHIPMENT_STATUS));
			// details
			o.setMfgPartNumber(rs.getString(MFR_PART_NO));
			o.setDispatchedQuantity(rs.getInt(QUANTITY));

			return o;
		}

	}

	/**
	 * Single row container for shipment notification
	 * 
	 * @author edavid
	 * 
	 */
	class NotifiedOrderRow
	{
		// header
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
		private String shipmentStatus;
		// detail
		private String mfgPartNumber;
		private int dispatchedQuantity;

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

		public String getShipmentStatus()
		{
			return shipmentStatus;
		}

		public void setShipmentStatus(String shipmentStatus)
		{
			this.shipmentStatus = shipmentStatus;
		}

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
	}
}
