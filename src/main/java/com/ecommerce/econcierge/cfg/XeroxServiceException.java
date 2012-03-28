package com.ecommerce.econcierge.cfg;

/**
 * Exception related to service layer, this will tag an exception occurs at
 * service layer
 * 
 * @author EDavid
 * 
 */
public class XeroxServiceException extends XeroxException
{

	private static final long serialVersionUID = 1L;

	public XeroxServiceException()
	{
		super();
	}

	public XeroxServiceException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public XeroxServiceException(String message)
	{
		super(message);
	}

	public XeroxServiceException(Throwable cause)
	{
		super(cause);
	}

}
