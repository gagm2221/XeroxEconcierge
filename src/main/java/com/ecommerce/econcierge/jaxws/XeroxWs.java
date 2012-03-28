package com.ecommerce.econcierge.jaxws;

import com.ecommerce.econcierge.cfg.XeroxWebServiceException;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;

/**
 * The web service to push data to xerox
 * 
 * @author EDavid
 * 
 */
public interface XeroxWs
{
	/**
	 * Push order confirmation
	 * 
	 * @param order
	 * @throws XeroxWebServiceException
	 */
	void pushCreateOrder(ConfirmedOrderModel order) throws XeroxWebServiceException;

	/**
	 * Push cancelled orders
	 * 
	 * @param order
	 * @throws XeroxWebServiceException
	 */
	void pushCancelOrder(CancelledOrderModel order) throws XeroxWebServiceException;

	/**
	 * Push Notified shipments
	 * 
	 * @param order
	 * @throws XeroxWebServiceException
	 */
	void pushNotifyShipment(NotifiedShipmentOrderModel order) throws XeroxWebServiceException;
}
