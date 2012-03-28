package com.ecommerce.econcierge.cfg;

/**
 * Exception related to web service, this will tag an exception that an error
 * occurs at web service layer
 * 
 * @author EDavid
 * 
 */
public class XeroxWebServiceException extends XeroxException
{

	private static final long serialVersionUID = 1L;

	public XeroxWebServiceException()
	{
		super();
	}

	public XeroxWebServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public XeroxWebServiceException(String message)
	{
		super(message);
	}

	public XeroxWebServiceException(Throwable cause)
	{
		super(cause);
	}

}
