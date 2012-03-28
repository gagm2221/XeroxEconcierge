package com.ecommerce.econcierge.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
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
public interface ShipmentNotificationSp
{
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
	class ShipmentNotificationRowMapper implements RowMapper<NotifiedShipmentOrderModel>
	{
		private static final String TB_ORDER_NO = "TODO";
		private static final String NP_ORDER_NO = "TODO";
		private static final String SHIP_DATE = "TODO";
		private static final String FIRST_NAME = "TODO";
		private static final String LAST_NAME = "TODO";
		private static final String ADDRESS_LINE_1 = "TODO";
		private static final String ADDRESS_LINE_2 = "TODO";
		private static final String CITY = "TODO";
		private static final String STATE = "TODO";
		private static final String ZIP_CODE = "TODO";
		private static final String COUNTRY = "TODO";
		private static final String CARRIER_CODE = "TODO";
		private static final String SHIPMENT_TRACKING_NUMBER = "TODO";
		private static final String SHIPMENT_TRACKING_URL = "TODO";

		/*
		 * Get the values form result set
		 * 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public NotifiedShipmentOrderModel mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			NotifiedShipmentOrderModel o = new NotifiedShipmentOrderModel();
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
			return o;
		}

	}
}
