package com.ecommerce.econcierge.sp;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import com.ecommerce.econcierge.cfg.AbstractSimpleJdbcCall;
import com.ecommerce.econcierge.cfg.StoredProcedure;
import com.ecommerce.econcierge.model.CancelledOrderModel;

/**
 * Implementation class for cancelled orders SP
 * 
 * @author EDavid
 * 
 */
@StoredProcedure("cancelledOrdersSp")
public class CancelledOrdersSpImpl extends AbstractSimpleJdbcCall<List<CancelledOrderModel>> implements CancelledOrdersSp
{

	@Inject
	@Named(CC_PRODUCT_DS)
	public CancelledOrdersSpImpl(DataSource dataSource)
	{
		super(dataSource);
	}

	public List<CancelledOrderModel> execute() throws DataAccessException
	{
		return null;
	}

}
