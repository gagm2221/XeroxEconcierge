package com.ecommerce.econcierge.sp;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;

import com.ecommerce.econcierge.cfg.AbstractSimpleJdbcCall;
import com.ecommerce.econcierge.cfg.StoredProcedure;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;

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
	@Named(CC_PRODUCT_DS)
	public ShipmentNotificationSpImpl(DataSource dataSource)
	{
		super(dataSource);
	}

	public List<NotifiedShipmentOrderModel> execute() throws DataAccessException
	{
		return null;
	}

}
