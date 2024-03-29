package com.ecommerce.econcierge.jaxws;

import javax.xml.ws.WebFault;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.5-b01 Generated
 * source version: 2.2
 * 
 */
@WebFault(name = "ServiceException", targetNamespace = "http://ws.order.esb.sdp.hcl.com/")
public class ServiceException_Exception extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Java type that goes as soapenv:Fault detail element.
	 * 
	 */
	private ServiceException faultInfo;

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 */
	public ServiceException_Exception(String message, ServiceException faultInfo)
	{
		super(message);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @param message
	 * @param faultInfo
	 * @param cause
	 */
	public ServiceException_Exception(String message, ServiceException faultInfo, Throwable cause)
	{
		super(message, cause);
		this.faultInfo = faultInfo;
	}

	/**
	 * 
	 * @return returns fault bean: com.econcierge.ws.ServiceException
	 */
	public ServiceException getFaultInfo()
	{
		return faultInfo;
	}

}
