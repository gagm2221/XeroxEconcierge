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
import com.ecommerce.econcierge.model.ConfirmedOrderModel;

/**
 * SP use to list all confirmed xerox orders
 * 
 * @author EDavid
 * 
 */
@StoredProcedure("confirmedOrdersSp")
public class ConfirmedOrdersSpImpl extends AbstractSimpleJdbcCall<List<ConfirmedOrderModel>> implements ConfirmedOrdersSp
{

	/**
	 * Parameters static variable names
	 */
	private static final String LIST = "list";
	private static final String STORE = "STORE";
	private static final String SOURCE = "Source";

	/**
	 * Declare the SP use and its parameters, use the cc_product_ds datasource
	 * defined in the application context
	 * 
	 * @param dataSource
	 */
	@Inject
	@Named(CC_PRODUCT_DS)
	public ConfirmedOrdersSpImpl(DataSource dataSource)
	{
		super(dataSource);

		// Set the stored procedure to be called
		super.setSp("dbo.prd_Get_Short_ProductDetails_list_v1");

		// declare parameter
		super.addDeclaredParameter(LIST, Types.VARCHAR);
		super.addDeclaredParameter(STORE, Types.VARCHAR);
		super.addDeclaredParameter(SOURCE, Types.VARCHAR);

		// declare the result set
		super.returningResultSet(RESULT, new OrderConfirmationRowMapper());

		super.compile();
	}

	/*
	 * The method that will provide the list of confirmed orders
	 * 
	 * @see com.ecommerce.econcierge.SpJdbcCall#execute()
	 */
	@SuppressWarnings("unchecked")
	public List<ConfirmedOrderModel> execute() throws DataAccessException
	{
		// The parameters
		Map<String, Object> _in_param = new HashMap<String, Object>();
		_in_param.put(LIST, this.getList());
		_in_param.put(STORE, this.getStore());
		_in_param.put(SOURCE, this.getSource());

		// execute SP
		Map<String, Object> result = super.run(_in_param);

		// get the results
		return (List<ConfirmedOrderModel>) result.get(RESULT);
	}

	/**
	 * Parameters
	 */
	private String list;
	private String store;
	private String source;

	public String getList()
	{
		return list;
	}

	public void setList(String list)
	{
		this.list = list;
	}

	public String getStore()
	{
		return store;
	}

	public void setStore(String store)
	{
		this.store = store;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
	}
}
