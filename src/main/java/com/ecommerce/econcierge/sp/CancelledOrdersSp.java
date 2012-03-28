package com.ecommerce.econcierge.sp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;

import com.ecommerce.econcierge.model.CancelledOrderModel;

/**
 * SP to ge the cancelled orders
 * 
 * @author EDavid
 * 
 */
public interface CancelledOrdersSp
{

	/**
	 * WIll list all the cancelled orders
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<CancelledOrderModel> execute() throws DataAccessException;

	/**
	 * A row mapper for cancelled orders
	 * 
	 * @author EDavid
	 * 
	 */
	class CancelledOrderRowMapper implements RowMapper<CancelledOrderModel>
	{
		private static final String TB_ORDER_NO = "TODO";
		private static final String NP_ORDER_NO = "TODO";

		/*
		 * Get values from result set
		 * 
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet,
		 * int)
		 */
		public CancelledOrderModel mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			CancelledOrderModel o = new CancelledOrderModel();
			o.setTbOrderNumber(rs.getString(TB_ORDER_NO));
			o.setNpOrderNumber(rs.getString(NP_ORDER_NO));
			return o;
		}

	}
}
