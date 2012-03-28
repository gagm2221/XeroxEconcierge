package com.ecommerce.econcierge.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.econcierge.model.ConfirmedOrderModel;

public interface ConfirmedOrdersSp
{
	/**
	 * Return static variables
	 */
	String RESULT = "result";

	/**
	 * Execute SP
	 */
	List<ConfirmedOrderModel> execute() throws DataAccessException;

	/**
	 * Parameters
	 */
	public String getList();

	public void setList(String list);

	public String getStore();

	public void setStore(String store);

	public String getSource();

	public void setSource(String source);

	/**
	 * Map the confirmed object from sp sinlge row result into
	 * OrderConfirmationModel
	 * 
	 * @author EDavid
	 * 
	 */
	class OrderConfirmationRowMapper implements RowMapper<ConfirmedOrderModel>
	{
		private static final String TB_ORDER_NO = "TODO";
		private static final String NP_ORDER_NO = "TODO";
		private static final String FIRST_NAME = "TODO";
		private static final String LAST_NAME = "TODO";
		private static final String ADDRESS_LINE_1 = "TODO";
		private static final String ADDRESS_LINE_2 = "TODO";
		private static final String CITY = "TODO";
		private static final String STATE = "TODO";
		private static final String ZIPCODE = "TODO";
		private static final String COUNTRY = "TODO";
		private static final String TOTAL_AMOUNT = "TODO";
		private static final String TOTAL_TAX = "TODO";
		private static final String SHIPPE_FEE = "TODO";
		private static final String DISCOUNT = "TODO";
		private static final String SUB_TOTAL = "TODO";

		/*
		 * Get values from result set
		 * 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public ConfirmedOrderModel mapRow(ResultSet rs, int index) throws SQLException
		{
			ConfirmedOrderModel o = new ConfirmedOrderModel();
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

			/**
			 * TODO How about the line item
			 */

			return o;
		}

	}
}
