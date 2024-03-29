package com.ecommerce.econcierge.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.5-b01 Generated
 * source version: 2.2
 * 
 */
@WebService(name = "OrderEventService", targetNamespace = "http://ws.order.esb.sdp.hcl.com/")
@XmlSeeAlso(
{ ObjectFactory.class })
public interface OrderEventService
{

	/**
	 * Canceling a Xerox Order
	 * 
	 * @param arg0
	 * @throws ServiceException_Exception
	 */
	@WebMethod(action = "cancelOrder")
	@RequestWrapper(localName = "cancelOrder", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.CancelOrder")
	@ResponseWrapper(localName = "cancelOrderResponse", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.CancelOrderResponse")
	public void cancelOrder(@WebParam(name = "arg0", targetNamespace = "") CancelOrderEventType arg0) throws ServiceException_Exception;

	/**
	 * Creating a Xerox Order
	 * 
	 * @param arg0
	 * @throws ServiceException_Exception
	 */
	@WebMethod(action = "createOrder")
	@RequestWrapper(localName = "createOrder", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.CreateOrder")
	@ResponseWrapper(localName = "createOrderResponse", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.CreateOrderResponse")
	public void createOrder(@WebParam(name = "arg0", targetNamespace = "") OrderEventType arg0) throws ServiceException_Exception;

	/**
	 * Shipment Notification
	 * 
	 * @param arg0
	 * @throws ServiceException_Exception
	 */
	@WebMethod(action = "notifyShipment")
	@RequestWrapper(localName = "notifyShipment", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.NotifyShipment")
	@ResponseWrapper(localName = "notifyShipmentResponse", targetNamespace = "http://ws.order.esb.sdp.hcl.com/", className = "com.ecommerce.econcierge.jaxws.NotifyShipmentResponse")
	public void notifyShipment(@WebParam(name = "arg0", targetNamespace = "") ShipmentEventType arg0) throws ServiceException_Exception;

}
