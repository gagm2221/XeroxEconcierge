package com.ecommerce.econcierge.jaxws;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import com.ecommerce.econcierge.cfg.LogIt;
import com.ecommerce.econcierge.cfg.WebService;
import com.ecommerce.econcierge.cfg.XeroxWebServiceException;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.model.OrderLineItemModel;
import com.ecommerce.econcierge.model.ShipmentLineItemModel;
import com.ecommerce.econcierge.util.CfgCache;

/**
 * Push ordes to xerox
 * 
 * @author EDavid
 * 
 */
@WebService("xeroxWs")
public class XeroxWsImpl implements XeroxWs
{

	/**
	 * The web service instance
	 */
	private OrderEventService service = null;

	/**
	 * Initialized the service instance
	 */
	@PostConstruct
	public void init()
	{
		service = new OrderEventServiceImplService(CfgCache.xerox.xeroxWsUsername(), CfgCache.xerox.xeroxWsPassword(), false).getOrderEventServicePort();
	}

	/*
	 * Push the confirmed orders
	 * 
	 * @see
	 * com.ecommerce.econcierge.jaxws.XeroxWs#createOrder(com.ecommerce.econcierge
	 * .model.ConfirmedOrderModel)
	 */
	@LogIt
	public void pushCreateOrder(ConfirmedOrderModel orderModel) throws XeroxWebServiceException
	{
		try
		{
			ObjectFactory factory = new ObjectFactory();
			OrderEventType arg0 = factory.createOrderEventType();
			arg0.orderBean = new ArrayList<OrderBean>();
			OrderBean order = factory.createOrderBean();
			order.setTbOrderNumber(orderModel.getTbOrderNumber());
			order.setNpOrderNumber(orderModel.getNpOrderNumber());
			order.setFirstName(orderModel.getFirstName());
			order.setLastName(orderModel.getLastName());
			order.setAddressLine1(orderModel.getAddressLine1());
			order.setAddressLine2(orderModel.getAddressLine2());
			order.setCity(orderModel.getCity());
			order.setState(orderModel.getState());
			order.setZipCode(order.getZipCode());
			order.setCountry(US_CODE);
			order.setTotalAmount(orderModel.getTotalAmount());
			order.setTotalTax(orderModel.getTotalTax());
			order.setShippingFee(order.getShippingFee());
			order.setDiscount(order.getDiscount());
			order.setSubTotal(order.getSubTotal());

			// Adding line Items
			List<OrderLineItemBean> lineItems = new ArrayList<OrderLineItemBean>();
			OrderLineItemBean lineItem = null;
			List<OrderLineItemModel> items = orderModel.getOrderLineItems();
			for (OrderLineItemModel item : items)
			{
				lineItem = factory.createOrderLineItemBean();
				lineItem.setMfgPartNumber(item.getMfgPartNumber());
				lineItem.setQuantity(item.getQuantity());
				lineItem.setUnitPrice(item.getUnitPrice());
				lineItems.add(lineItem);

			}
			order.orderLineItem = lineItems;

			arg0.orderBean.add(order);

			// send to xerox
			service.createOrder(arg0);
		} catch (ServiceException_Exception e)
		{
			throw new XeroxWebServiceException(e);
		}
	}

	/*
	 * Push the cancelled orders
	 * 
	 * @see
	 * com.ecommerce.econcierge.jaxws.XeroxWs#cancelOrder(com.ecommerce.econcierge
	 * .model.CancelledOrderModel)
	 */
	@LogIt
	public void pushCancelOrder(CancelledOrderModel order) throws XeroxWebServiceException
	{
		try
		{
			ObjectFactory factory = new ObjectFactory();
			CancelOrderEventType arg0 = factory.createCancelOrderEventType();
			arg0.cancelOrderRequest = new ArrayList<CancelOrderRequest>();
			CancelOrderRequest req = factory.createCancelOrderRequest();
			req.setTbOrderNumber(order.getTbOrderNumber());
			req.setNpOrderNumber(order.getTbOrderNumber());
			arg0.cancelOrderRequest.add(req);

			// send to xerox
			service.cancelOrder(arg0);
		} catch (ServiceException_Exception e)
		{
			throw new XeroxWebServiceException(e);
		}
	}

	/*
	 * Push the notified shipment
	 * 
	 * @see
	 * com.ecommerce.econcierge.jaxws.XeroxWs#notifyShipment(com.ecommerce.econcierge
	 * .model.NotifiedShipmentOrderModel)
	 */
	@LogIt
	public void pushNotifyShipment(NotifiedShipmentOrderModel order) throws XeroxWebServiceException
	{
		try
		{
			ObjectFactory factory = new ObjectFactory();
			ShipmentEventType arg0 = factory.createShipmentEventType();
			arg0.shipmentBean = new ArrayList<ShipmentBean>();
			ShipmentBean shipment = factory.createShipmentBean();
			shipment.setTbOrderNumber(order.getTbOrderNumber());
			shipment.setNpOrderNumber(order.getNpOrderNumber());
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(order.getShipDate().getTime());
			DatatypeFactory df = DatatypeFactory.newInstance();
			shipment.setShipDate(df.newXMLGregorianCalendar(gc));
			shipment.setFirstName(order.getFirstName());
			shipment.setLastName(order.getLastName());
			shipment.setAddressLine1(order.getAddressLine1());
			shipment.setAddressLine2(order.getAddressLine2());
			shipment.setCity(order.getCity());
			shipment.setState(order.getState());
			shipment.setZipCode(order.getZipCode());
			shipment.setCountry(US_CODE);
			shipment.setCarrierCode(order.getCarrierCode());
			shipment.setShipmentTrackingNumber(order.getShipmentTrackingNumber());
			shipment.setShipmentTrackingURL(order.getShipmentTrackingURL());

			// Adding shipment items
			shipment.shipmentLineItem = new ArrayList<ShipmentLineItemBean>();
			List<ShipmentLineItemModel> items = order.getShipmentLineItem();
			ShipmentLineItemBean lineItem = null;
			for (ShipmentLineItemModel item : items)
			{
				lineItem = factory.createShipmentLineItemBean();
				lineItem.setMfgPartNumber(item.getMfgPartNumber());
				lineItem.setDispatchedQuantity(item.getDispatchedQuantity());
				lineItem.setShipmentTrackingNumber(item.getShipmentTrackingNumber());
				lineItem.setShipmentTrackingURL(item.getShipmentTrackingURL());
				shipment.shipmentLineItem.add(lineItem);

			}
			arg0.shipmentBean.add(shipment);

			// send to xerox
			service.notifyShipment(arg0);
		} catch (DatatypeConfigurationException e)
		{
			throw new XeroxWebServiceException(e);
		} catch (ServiceException_Exception e)
		{
			throw new XeroxWebServiceException(e);
		}
	}

	/**
	 * Destroy all class variables
	 */
	@PreDestroy
	public void close()
	{
		service = null;
	}
}
