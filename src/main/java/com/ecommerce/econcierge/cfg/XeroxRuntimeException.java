package com.ecommerce.econcierge.cfg;

/**
 * Runtime Exception Related to xerox
 * 
 * @author EDavid
 * 
 */
public class XeroxRuntimeException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	public XeroxRuntimeException()
	{
		super();
	}

	public XeroxRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public XeroxRuntimeException(String message)
	{
		super(message);
	}

	public XeroxRuntimeException(Throwable cause)
	{
		super(cause);
	}
}
