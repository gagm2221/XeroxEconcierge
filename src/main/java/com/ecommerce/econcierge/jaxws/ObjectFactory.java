package com.ecommerce.econcierge.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.econcierge.ws package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory
{

	private final static QName _NotifyShipmentResponse_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "notifyShipmentResponse");
	private final static QName _CreateOrderResponse_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "createOrderResponse");
	private final static QName _CancelOrder_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "cancelOrder");
	private final static QName _ServiceException_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "ServiceException");
	private final static QName _CreateOrder_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "createOrder");
	private final static QName _NotifyShipment_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "notifyShipment");
	private final static QName _CancelOrderResponse_QNAME = new QName("http://ws.order.esb.sdp.hcl.com/", "cancelOrderResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: com.econcierge.ws
	 * 
	 */
	public ObjectFactory()
	{
	}

	/**
	 * Create an instance of {@link CreateOrderResponse }
	 * 
	 */
	public CreateOrderResponse createCreateOrderResponse()
	{
		return new CreateOrderResponse();
	}

	/**
	 * Create an instance of {@link NotifyShipmentResponse }
	 * 
	 */
	public NotifyShipmentResponse createNotifyShipmentResponse()
	{
		return new NotifyShipmentResponse();
	}

	/**
	 * Create an instance of {@link CancelOrder }
	 * 
	 */
	public CancelOrder createCancelOrder()
	{
		return new CancelOrder();
	}

	/**
	 * Create an instance of {@link CancelOrderResponse }
	 * 
	 */
	public CancelOrderResponse createCancelOrderResponse()
	{
		return new CancelOrderResponse();
	}

	/**
	 * Create an instance of {@link NotifyShipment }
	 * 
	 */
	public NotifyShipment createNotifyShipment()
	{
		return new NotifyShipment();
	}

	/**
	 * Create an instance of {@link CreateOrder }
	 * 
	 */
	public CreateOrder createCreateOrder()
	{
		return new CreateOrder();
	}

	/**
	 * Create an instance of {@link ServiceException }
	 * 
	 */
	public ServiceException createServiceException()
	{
		return new ServiceException();
	}

	/**
	 * Create an instance of {@link ShipmentBean }
	 * 
	 */
	public ShipmentBean createShipmentBean()
	{
		return new ShipmentBean();
	}

	/**
	 * Create an instance of {@link ShipmentEventType }
	 * 
	 */
	public ShipmentEventType createShipmentEventType()
	{
		return new ShipmentEventType();
	}

	/**
	 * Create an instance of {@link CancelOrderEventType }
	 * 
	 */
	public CancelOrderEventType createCancelOrderEventType()
	{
		return new CancelOrderEventType();
	}

	/**
	 * Create an instance of {@link OrderEventType }
	 * 
	 */
	public OrderEventType createOrderEventType()
	{
		return new OrderEventType();
	}

	/**
	 * Create an instance of {@link CancelOrderRequest }
	 * 
	 */
	public CancelOrderRequest createCancelOrderRequest()
	{
		return new CancelOrderRequest();
	}

	/**
	 * Create an instance of {@link OrderLineItemBean }
	 * 
	 */
	public OrderLineItemBean createOrderLineItemBean()
	{
		return new OrderLineItemBean();
	}

	/**
	 * Create an instance of {@link ShipmentLineItemBean }
	 * 
	 */
	public ShipmentLineItemBean createShipmentLineItemBean()
	{
		return new ShipmentLineItemBean();
	}

	/**
	 * Create an instance of {@link OrderBean }
	 * 
	 */
	public OrderBean createOrderBean()
	{
		return new OrderBean();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link NotifyShipmentResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "notifyShipmentResponse")
	public JAXBElement<NotifyShipmentResponse> createNotifyShipmentResponse(NotifyShipmentResponse value)
	{
		return new JAXBElement<NotifyShipmentResponse>(_NotifyShipmentResponse_QNAME, NotifyShipmentResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CreateOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "createOrderResponse")
	public JAXBElement<CreateOrderResponse> createCreateOrderResponse(CreateOrderResponse value)
	{
		return new JAXBElement<CreateOrderResponse>(_CreateOrderResponse_QNAME, CreateOrderResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CancelOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "cancelOrder")
	public JAXBElement<CancelOrder> createCancelOrder(CancelOrder value)
	{
		return new JAXBElement<CancelOrder>(_CancelOrder_QNAME, CancelOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ServiceException }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "ServiceException")
	public JAXBElement<ServiceException> createServiceException(ServiceException value)
	{
		return new JAXBElement<ServiceException>(_ServiceException_QNAME, ServiceException.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link CreateOrder }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "createOrder")
	public JAXBElement<CreateOrder> createCreateOrder(CreateOrder value)
	{
		return new JAXBElement<CreateOrder>(_CreateOrder_QNAME, CreateOrder.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link NotifyShipment }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "notifyShipment")
	public JAXBElement<NotifyShipment> createNotifyShipment(NotifyShipment value)
	{
		return new JAXBElement<NotifyShipment>(_NotifyShipment_QNAME, NotifyShipment.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}
	 * {@link CancelOrderResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://ws.order.esb.sdp.hcl.com/", name = "cancelOrderResponse")
	public JAXBElement<CancelOrderResponse> createCancelOrderResponse(CancelOrderResponse value)
	{
		return new JAXBElement<CancelOrderResponse>(_CancelOrderResponse_QNAME, CancelOrderResponse.class, null, value);
	}

}
