package com.ecommerce.econcierge.sp;

import java.sql.Types;
import java.util.ArrayList;
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
import com.ecommerce.econcierge.model.OrderLineItemModel;

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
	 * Declare the SP use and its parameters, use the cc_product_ds datasource
	 * defined in the application context
	 * 
	 * @param dataSource
	 */
	@Inject
	@Named(ISB_DATA_SOURCE)
	public ConfirmedOrdersSpImpl(DataSource dataSource)
	{
		super(dataSource);

		// Set the stored procedure to be called
		super.setSp(SP_NAME);

		// declare parameter
		super.addDeclaredParameter(STATUS, Types.VARCHAR);

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
		_in_param.put(STATUS, CONFIRMED_STATUS);

		// execute SP
		Map<String, Object> result = super.run(_in_param);

		// get the results
		List<ConfirmedOrderRow> list = (List<ConfirmedOrderRow>) result.get(RESULT);

		// normalized the data
		List<ConfirmedOrderModel> out = normalized(list);

		return out;
	}

	/**
	 * Convert ConfirmedOrderRow into ConfirmedOrderModel
	 * 
	 * @param list
	 * @return
	 */
	private List<ConfirmedOrderModel> normalized(List<ConfirmedOrderRow> list)
	{
		List<ConfirmedOrderModel> out = new ArrayList<ConfirmedOrderModel>();

		ConfirmedOrderModel nu;
		ConfirmedOrderModel exist;
		OrderLineItemModel item;
		for (ConfirmedOrderRow row : list)
		{
			// header
			nu = new ConfirmedOrderModel();
			nu.setTbOrderNumber(row.getTbOrderNumber());
			nu.setNpOrderNumber(row.getNpOrderNumber());

			nu.setFirstName(row.getFirstName());
			nu.setLastName(row.getLastName());
			nu.setAddressLine1(row.getAddressLine1());
			nu.setAddressLine2(row.getAddressLine2());
			nu.setCity(row.getCity());
			nu.setState(row.getState());
			nu.setZipCode(row.getZipCode());
			nu.setCountry(row.getCountry());
			nu.setTotalAmount(row.getTotalAmount());
			nu.setTotalTax(row.getTotalTax());
			nu.setShippingFee(row.getShippingFee());
			nu.setDiscount(row.getDiscount());
			nu.setSubTotal(row.getSubTotal());

			// detail
			item = new OrderLineItemModel();
			item.setMfgPartNumber(row.getMfgPartNumber());
			item.setQuantity(row.getQuantity());
			item.setUnitPrice(row.getUnitPrice());

			if (out.contains(nu))
			{// when header already exist
				exist = out.get(out.indexOf(nu));

				// add line item/detail to header
				exist.getOrderLineItems().add(item);
			} else
			{// when new header
				// set order line item
				nu.setOrderLineItems(new ArrayList<OrderLineItemModel>());
				nu.getOrderLineItems().add(item);

				// add new header
				out.add(nu);
			}
		}

		return out;
	}
}
