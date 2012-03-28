package com.ecommerce.econcierge.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ecommerce.econcierge.cfg.LogIt;
import com.ecommerce.econcierge.cfg.XeroxDataAccessException;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.model.OrderStatusModel;
import com.ecommerce.econcierge.sp.CancelledOrdersSp;
import com.ecommerce.econcierge.sp.ConfirmedOrdersSp;
import com.ecommerce.econcierge.sp.ShipmentNotificationSp;
import com.ecommerce.econcierge.sp.UpdateOrderStatusSp;

/**
 * Implementation of Xerox Dao
 * 
 * @author EDavid
 * 
 */
@Repository("xeroxDao")
public class XeroxDaoImpl implements XeroxDao
{
	/**
	 * SP for confirmed orders
	 */
	@Autowired
	private ConfirmedOrdersSp confirmedOrdersSp;

	/**
	 * SP for cancelled orders
	 */
	@Autowired
	private CancelledOrdersSp cancelledOrdersSp;

	/**
	 * SP for shipment notifications
	 */
	@Autowired
	private ShipmentNotificationSp shipmentNotificationSp;

	/**
	 * SP for Update order status
	 */
	@Autowired
	private UpdateOrderStatusSp updateOrderStatusSp;

	/*
	 * Get confirmed orders
	 * 
	 * @see com.ecommerce.econcierge.dao.XeroxDao#getConfirmedOrders()
	 */
	@LogIt
	public List<ConfirmedOrderModel> getConfirmedOrders() throws XeroxDataAccessException
	{
		try
		{
			List<ConfirmedOrderModel> confirmedOrders = confirmedOrdersSp.execute();
			return confirmedOrders;
		} catch (DataAccessException e)
		{
			throw new XeroxDataAccessException(e);
		}
	}

	/*
	 * Get cancelled orders
	 * 
	 * @see com.ecommerce.econcierge.dao.XeroxDao#getCancelledOrders()
	 */
	@LogIt
	public List<CancelledOrderModel> getCancelledOrders() throws XeroxDataAccessException
	{
		try
		{
			List<CancelledOrderModel> cancelledOrders = cancelledOrdersSp.execute();
			return cancelledOrders;
		} catch (DataAccessException e)
		{
			throw new XeroxDataAccessException(e);
		}
	}

	/*
	 * Get orders for shipment notifications
	 * 
	 * @see com.ecommerce.econcierge.dao.XeroxDao#getNotifiedShipmentOrders()
	 */
	@LogIt
	public List<NotifiedShipmentOrderModel> getNotifiedShipmentOrders() throws XeroxDataAccessException
	{
		try
		{
			List<NotifiedShipmentOrderModel> notifiedShipmentOrders = shipmentNotificationSp.execute();
			return notifiedShipmentOrders;
		} catch (DataAccessException e)
		{
			throw new XeroxDataAccessException(e);
		}
	}

	/*
	 * Update xerox orders status
	 * 
	 * @see
	 * com.ecommerce.econcierge.dao.XeroxDao#updateOrderStatus(com.ecommerce.
	 * econcierge.model.OrderStatusModel)
	 */
	@LogIt
	public void updateOrderStatus(OrderStatusModel order) throws XeroxDataAccessException
	{
		try
		{
			boolean isSucces = updateOrderStatusSp.execute();
			if (isSucces)
			{
				// TODO throw XeroxDataAccessException something here
			}
		} catch (DataAccessException e)
		{
			throw new XeroxDataAccessException(e);
		}
	}

	/*
	 * Update sent status
	 * 
	 * @see com.ecommerce.econcierge.dao.XeroxDao#updateSentStatus(com.ecommerce.
	 * econcierge.model.OrderStatusModel)
	 */
	@LogIt
	public void updateSentStatus(OrderStatusModel order) throws XeroxDataAccessException
	{
		this.updateOrderStatus(order);
	}

	/*
	 * Update shipment notification status
	 * 
	 * @see
	 * com.ecommerce.econcierge.dao.XeroxDao#updateStopShippingNotification(com
	 * .ecommerce.econcierge.model.OrderStatusModel)
	 */
	@LogIt
	public void updateStopShippingNotification(OrderStatusModel order) throws XeroxDataAccessException
	{
		this.updateOrderStatus(order);
	}

}
