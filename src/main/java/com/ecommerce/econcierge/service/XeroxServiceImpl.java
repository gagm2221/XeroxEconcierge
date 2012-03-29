package com.ecommerce.econcierge.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.econcierge.cfg.LogIt;
import com.ecommerce.econcierge.cfg.XeroxDataAccessException;
import com.ecommerce.econcierge.cfg.XeroxServiceException;
import com.ecommerce.econcierge.cfg.XeroxWebServiceException;
import com.ecommerce.econcierge.dao.XeroxDao;
import com.ecommerce.econcierge.jaxws.XeroxWs;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.model.OrderStatusModel;
import com.ecommerce.econcierge.util.CfgCache;

/**
 * Implementation class for xerox service layer
 * 
 * @author EDavid
 * 
 */
@Service("xeroxService")
public class XeroxServiceImpl implements XeroxService
{
	private static final Logger logger = Logger.getLogger(XeroxServiceImpl.class);
	private static final String FINAL_SHIPMENT_STATUS = "TODO"; // TODO

	/**
	 * The instance of xerox dao
	 */
	@Autowired
	private XeroxDao xeroxDao;

	/**
	 * The instance of xerox web service
	 */
	@Autowired
	private XeroxWs xeroxWs;

	/*
	 * Process the confirmed orders
	 * 
	 * @see
	 * com.ecommerce.econcierge.service.XeroxService#processConfirmedOrders()
	 */
	@LogIt
	public void processConfirmedOrders() throws XeroxServiceException
	{
		try
		{
			// Get all confirmed orders
			List<ConfirmedOrderModel> confirmedOrders = xeroxDao.getConfirmedOrders();
			if (confirmedOrders != null)
			{
				OrderStatusModel orderStatus;
				for (ConfirmedOrderModel order : confirmedOrders)
				{
					// perform push
					xeroxWs.pushCreateOrder(order);

					// update sent status
					orderStatus = new OrderStatusModel();
					orderStatus.setTbOrderNumber(order.getTbOrderNumber());
					orderStatus.setNpOrderNumber(order.getNpOrderNumber());
					orderStatus.setSentStatus(OrderStatusModel.ALREADY_SENT_STATUS);
					xeroxDao.updateSentStatus(orderStatus);
				}
			} else
			{
				logger.info("No confirmed orders to process.");
			}
		} catch (XeroxDataAccessException e)
		{
			throw new XeroxServiceException(e);
		} catch (XeroxWebServiceException e)
		{
			throw new XeroxServiceException(e);
		}
	}

	/*
	 * Process the cancelled orders
	 * 
	 * @see
	 * com.ecommerce.econcierge.service.XeroxService#processCancelledOrders()
	 */
	@LogIt
	public void processCancelledOrders() throws XeroxServiceException
	{
		try
		{
			// Get all cancelled orders
			List<CancelledOrderModel> cancelledOrders = xeroxDao.getCancelledOrders();
			if (cancelledOrders != null)
			{
				OrderStatusModel orderStatus;
				for (CancelledOrderModel order : cancelledOrders)
				{
					// perform push
					xeroxWs.pushCancelOrder(order);

					orderStatus = new OrderStatusModel();
					orderStatus.setSentStatus(OrderStatusModel.ALREADY_SENT_STATUS);
					// update sent status
					xeroxDao.updateSentStatus(orderStatus);
				}
			} else
			{
				logger.info("No cancelled orders to process.");
			}
		} catch (XeroxDataAccessException e)
		{
			throw new XeroxServiceException(e);
		} catch (XeroxWebServiceException e)
		{
			throw new XeroxServiceException(e);
		}
	}

	/*
	 * Process the for shipment notification
	 * 
	 * @see
	 * com.ecommerce.econcierge.service.XeroxService#processShipmentNotification
	 * ()
	 */
	@LogIt
	public void processShipmentNotification() throws XeroxServiceException
	{
		try
		{
			// Get all notified shipments
			List<NotifiedShipmentOrderModel> notifiedShipmentOrders = xeroxDao.getNotifiedShipmentOrders();
			if (notifiedShipmentOrders != null)
			{
				OrderStatusModel orderStatus;
				for (NotifiedShipmentOrderModel order : notifiedShipmentOrders)
				{
					// set shipment tracking url
					order.setShipmentTrackingURL(getShipmentTrackingUrl(order.getShipmentTrackingNumber()));

					// perform push
					xeroxWs.pushNotifyShipment(order);

					// update order status if all ship
					if (isAllShip(order.getShipmentStatus()))
					{
						orderStatus = new OrderStatusModel();
						orderStatus.setNpOrderNumber(order.getNpOrderNumber());
						orderStatus.setTbOrderNumber(order.getNpOrderNumber());
						orderStatus.setStopShippingNotification(OrderStatusModel.STOP_SHIPPING_STATUS);
						xeroxDao.updateStopShippingNotification(orderStatus);
					}
				}
			} else
			{
				logger.info("No shipment notifications to process.");
			}
		} catch (XeroxDataAccessException e)
		{
			throw new XeroxServiceException(e);
		} catch (XeroxWebServiceException e)
		{
			throw new XeroxServiceException(e);
		}
	}

	private String getShipmentTrackingUrl(String trackingNumber)
	{
		// TODO for ecryption of the trackingNumber
		return CfgCache.xerox.shipmentTrackingUrl(trackingNumber);
	}

	/**
	 * Validate if shipment are all shipped
	 * 
	 * @param shipmentStatus
	 * @return
	 */
	private boolean isAllShip(String shipmentStatus)
	{
		return shipmentStatus != null && FINAL_SHIPMENT_STATUS.equals(shipmentStatus.trim());
	}
}
