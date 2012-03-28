package com.ecommerce.econcierge.dao;

import java.util.List;

import com.ecommerce.econcierge.cfg.XeroxDataAccessException;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.model.OrderStatusModel;

/**
 * Xerox Dao Interface
 * 
 * @author EDavid
 * 
 */
public interface XeroxDao
{
	/**
	 * Get all confirmed Orders
	 * 
	 * @return
	 * @throws XeroxDataAccessException
	 */
	List<ConfirmedOrderModel> getConfirmedOrders() throws XeroxDataAccessException;

	/**
	 * Get all Cancelled Orders
	 * 
	 * @return
	 * @throws XeroxDataAccessException
	 */
	List<CancelledOrderModel> getCancelledOrders() throws XeroxDataAccessException;

	/**
	 * Get notified shipment orders
	 * 
	 * @return
	 * @throws XeroxDataAccessException
	 */
	List<NotifiedShipmentOrderModel> getNotifiedShipmentOrders() throws XeroxDataAccessException;

	/**
	 * Common update status
	 * 
	 * @param order
	 * @throws XeroxDataAccessException
	 */
	void updateOrderStatus(OrderStatusModel order) throws XeroxDataAccessException;

	/**
	 * Update sent status
	 * 
	 * @param order
	 * @throws XeroxDataAccessException
	 */
	void updateSentStatus(OrderStatusModel order) throws XeroxDataAccessException;

	/**
	 * Update Shipping Notification
	 * 
	 * @param order
	 * @throws XeroxDataAccessException
	 */
	void updateStopShippingNotification(OrderStatusModel order) throws XeroxDataAccessException;
}
