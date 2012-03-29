package com.ecommerce.econcierge.sp;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Named(ISB_DATA_SOURCE)
	public CancelledOrdersSpImpl(DataSource dataSource)
	{
		super(dataSource);

		// Set the stored procedure to be called
		super.setSp(SP_NAME);

		// declare parameter
		super.addDeclaredParameter(STATUS, Types.VARCHAR);

		// declare the result set
		super.returningResultSet(RESULT, new CancelledOrderRowMapper());

		super.compile();
	}

	@SuppressWarnings("unchecked")
	public List<CancelledOrderModel> execute() throws DataAccessException
	{
		// The parameters
		Map<String, Object> _in_param = new HashMap<String, Object>();
		_in_param.put(STATUS, CANCELLED_STATUS);

		// execute SP
		Map<String, Object> result = super.run(_in_param);

		return (List<CancelledOrderModel>) result.get(RESULT);
	}

}
