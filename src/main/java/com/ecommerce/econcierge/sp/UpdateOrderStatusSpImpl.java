package com.ecommerce.econcierge.sp;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import com.ecommerce.econcierge.cfg.AbstractSimpleJdbcCall;
import com.ecommerce.econcierge.cfg.StoredProcedure;

/**
 * Implementation class use to update the status on an order
 * 
 * @author EDavid
 * 
 */
@StoredProcedure("updateOrderStatusSp")
public class UpdateOrderStatusSpImpl extends AbstractSimpleJdbcCall<Boolean> implements UpdateOrderStatusSp
{

	@Inject
	@Named(CC_PRODUCT_DS)
	public UpdateOrderStatusSpImpl(DataSource dataSource)
	{
		super(dataSource);
	}

	public Boolean execute() throws DataAccessException
	{
		return false;
	}

}
