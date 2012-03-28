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
			List<ConfirmedOrderModel> confirmedOrders = xeroxDao.getConfirmedOrders();
			if (confirmedOrders != null)
			{
				OrderStatusModel orderStatus;
				for (ConfirmedOrderModel order : confirmedOrders)
				{
					xeroxWs.pushCreateOrder(order);
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
			List<CancelledOrderModel> cancelledOrders = xeroxDao.getCancelledOrders();
			if (cancelledOrders != null)
			{
				OrderStatusModel orderStatus;
				for (CancelledOrderModel order : cancelledOrders)
				{
					xeroxWs.pushCancelOrder(order);
					orderStatus = new OrderStatusModel();
					orderStatus.setSentStatus(OrderStatusModel.ALREADY_SENT_STATUS);
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
		logger.info("Start : processShipmentNotification");
		try
		{
			List<NotifiedShipmentOrderModel> notifiedShipmentOrders = xeroxDao.getNotifiedShipmentOrders();
			if (notifiedShipmentOrders != null)
			{
				OrderStatusModel orderStatus;
				for (NotifiedShipmentOrderModel order : notifiedShipmentOrders)
				{
					xeroxWs.pushNotifyShipment(order);
					orderStatus = new OrderStatusModel();
					xeroxDao.updateStopShippingNotification(orderStatus);
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

}
