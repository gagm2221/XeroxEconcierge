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
			order.setTbOrderNumber("EC-011332890017347");
			order.setNpOrderNumber("W8789710");
			order.setFirstName("Abcede");
			order.setLastName("Daeafa");
			order.setAddressLine1("330, Port avenue");
			order.setAddressLine2("Sterling boulevard");
			order.setCity("St.Louis");
			order.setState("MI");
			order.setZipCode("64001");
			order.setCountry("US");
			order.setTotalAmount(4.0);
			order.setTotalTax(1.0);
			order.setShippingFee(3.0);
			order.setDiscount(0.0);
			order.setSubTotal(8.0);
			
			//Adding line Items
			List<OrderLineItemBean> lineItems = new ArrayList<OrderLineItemBean>();
			OrderLineItemBean lineItem = factory.createOrderLineItemBean();
			lineItem.setMfgPartNumber("106R01388");
			lineItem.setQuantity(1);
			lineItem.setUnitPrice(1.0);
			lineItems.add(lineItem);
			lineItem = factory.createOrderLineItemBean();
			lineItem.setMfgPartNumber("106R01389");
			lineItem.setQuantity(1);
			lineItem.setUnitPrice(1.0);
			lineItems.add(lineItem);
			lineItem = factory.createOrderLineItemBean();
			lineItem.setMfgPartNumber("106R01390");
			lineItem.setQuantity(1);
			lineItem.setUnitPrice(1.0);
			lineItems.add(lineItem);
			lineItem = factory.createOrderLineItemBean();
			lineItem.setMfgPartNumber("106R01391");
			lineItem.setQuantity(1);
			lineItem.setUnitPrice(1.0);
			lineItems.add(lineItem);
			
			order.orderLineItem = lineItems;
			arg0.orderBean.add(order);
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
			req.setTbOrderNumber("EC-011332890071912");
			req.setNpOrderNumber("W8789711");
			arg0.cancelOrderRequest.add(req);
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
			shipment.setTbOrderNumber("EC-011332890091926");
			shipment.setNpOrderNumber("W8789712");
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTimeInMillis(System.currentTimeMillis());
			DatatypeFactory df = DatatypeFactory.newInstance();
			shipment.setShipDate(df.newXMLGregorianCalendar(gc));
			shipment.setFirstName("ABC");
			shipment.setLastName("DEF");
			shipment.setAddressLine1("330, Port avenue");
			shipment.setAddressLine2("Sterling boulevard");
			shipment.setCity("St.Louis");
			shipment.setState("MI");
			shipment.setZipCode("64001");
			shipment.setCountry("US");
			shipment.setCarrierCode("FG");
			shipment.setShipmentTrackingNumber("X12222");
			shipment.setShipmentTrackingURL("http://www.xd.com/tracking?o=W1234");

			shipment.shipmentLineItem = new ArrayList<ShipmentLineItemBean>();
			ShipmentLineItemBean lineItem = factory.createShipmentLineItemBean();
			lineItem.setMfgPartNumber("106R01388");
			lineItem.setDispatchedQuantity(2);
			shipment.shipmentLineItem.add(lineItem);
			lineItem = factory.createShipmentLineItemBean();
			lineItem.setMfgPartNumber("106R01390");
			lineItem.setDispatchedQuantity(1);
			shipment.shipmentLineItem.add(lineItem);
			
			arg0.shipmentBean.add(shipment);
			
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
