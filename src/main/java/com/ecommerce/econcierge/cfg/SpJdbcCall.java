package com.ecommerce.econcierge.cfg;

import org.springframework.dao.DataAccessException;

/**
 * Interface declaration that will use for creating an stored procedure
 * 
 * @author EDavid
 * 
 * @param <RETURN>
 */
public interface SpJdbcCall<RETURN>
{
	/**
	 * Method defintion for execution of the store procedure
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	RETURN execute() throws DataAccessException;

	/**
	 * DataSource for ccproduct schema
	 */
	String CC_PRODUCT_DS = "ccproductds";
	
	/**
	 * DataSource for isb
	 */
	String ISB_DATA_SOURCE = "isb";
}
