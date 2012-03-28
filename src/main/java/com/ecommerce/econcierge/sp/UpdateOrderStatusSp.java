package com.ecommerce.econcierge.sp;

import org.springframework.dao.DataAccessException;

/**
 * SP use to update the order status
 * 
 * @author EDavid
 * 
 */
public interface UpdateOrderStatusSp
{
	/**
	 * Will update the status of the order
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	public Boolean execute() throws DataAccessException;
}
