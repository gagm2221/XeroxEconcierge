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
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.model.ShipmentLineItemModel;

/**
 * Implementation class for Shipment notifcation SP
 * 
 * @author EDavid
 * 
 */
@StoredProcedure("shipmentNotificationSp")
public class ShipmentNotificationSpImpl extends AbstractSimpleJdbcCall<List<NotifiedShipmentOrderModel>> implements ShipmentNotificationSp
{

	@Inject
	@Named(ISB_DATA_SOURCE)
	public ShipmentNotificationSpImpl(DataSource dataSource)
	{
		super(dataSource);

		// Set the stored procedure to be called
		super.setSp(SP_NAME);

		// declare parameter
		super.addDeclaredParameter(STATUS, Types.VARCHAR);

		// declare the result set
		super.returningResultSet(RESULT, new ShipmentNotificationRowMapper());

		super.compile();

	}

	@SuppressWarnings("unchecked")
	public List<NotifiedShipmentOrderModel> execute() throws DataAccessException
	{
		// The parameters
		Map<String, Object> _in_param = new HashMap<String, Object>();
		_in_param.put(STATUS, SHIPMENT_NOTIFICATION_STATUS);

		// execute SP
		Map<String, Object> result = super.run(_in_param);

		List<NotifiedOrderRow> list = (List<NotifiedOrderRow>) result.get(RESULT);

		List<NotifiedShipmentOrderModel> out = normalized(list);

		return out;

	}

	/**
	 * Normalized the data and set to NotifiedShipmentOrderModel
	 * 
	 * @param list
	 * @return
	 */
	private List<NotifiedShipmentOrderModel> normalized(List<NotifiedOrderRow> list)
	{
		List<NotifiedShipmentOrderModel> out = new ArrayList<NotifiedShipmentOrderModel>();

		NotifiedShipmentOrderModel nu;
		NotifiedShipmentOrderModel exist;
		ShipmentLineItemModel item;
		for (NotifiedOrderRow row : list)
		{
			// header
			nu = new NotifiedShipmentOrderModel();
			nu.setTbOrderNumber(row.getTbOrderNumber());
			nu.setNpOrderNumber(row.getNpOrderNumber());
			nu.setShipDate(row.getShipDate());
			nu.setFirstName(row.getFirstName());
			nu.setLastName(row.getLastName());
			nu.setAddressLine1(row.getAddressLine1());
			nu.setAddressLine2(row.getAddressLine2());
			nu.setCity(row.getCity());
			nu.setState(row.getState());
			nu.setZipCode(row.getZipCode());
			nu.setCountry(row.getCountry());
			nu.setCarrierCode(row.getCarrierCode());
			nu.setShipmentTrackingNumber(row.getShipmentTrackingNumber());
			nu.setShipmentTrackingURL(row.getShipmentTrackingURL());
			nu.setShipmentStatus(row.getShipmentStatus());

			// detail
			item = new ShipmentLineItemModel();
			item.setMfgPartNumber(row.getMfgPartNumber());
			item.setDispatchedQuantity(row.getDispatchedQuantity());

			if (out.contains(nu))
			{// when header already exit
				exist = out.get(out.indexOf(nu));

				// add shipment line item/detail to header
				exist.getShipmentLineItem().add(item);
			} else
			{// when new header
				// set shipment line item
				nu.setShipmentLineItem(new ArrayList<ShipmentLineItemModel>());
				nu.getShipmentLineItem().add(item);

				// add new header
				out.add(nu);
			}

		}

		return out;
	}

}
