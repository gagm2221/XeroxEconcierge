package com.ecommerce.econcierge.service;

import com.ecommerce.econcierge.cfg.XeroxServiceException;

/**
 * Service layer for xerox
 * 
 * @author EDavid
 * 
 */
public interface XeroxService
{
	/**
	 * Process the confirmed orders
	 * 
	 * @throws XeroxServiceException
	 */
	void processConfirmedOrders() throws XeroxServiceException;

	/**
	 * Process the cancelled orders
	 * 
	 * @throws XeroxServiceException
	 */
	void processCancelledOrders() throws XeroxServiceException;

	/**
	 * Process the for shipment notification
	 * 
	 * @throws XeroxServiceException
	 */
	void processShipmentNotification() throws XeroxServiceException;
}
