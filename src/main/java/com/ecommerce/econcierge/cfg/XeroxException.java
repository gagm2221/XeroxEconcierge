package com.ecommerce.econcierge.cfg;

/**
 * Xerox Related Exception
 * 
 * @author EDavid
 * 
 */
public abstract class XeroxException extends Exception
{

	private static final long serialVersionUID = 1L;

	public XeroxException()
	{
		super();
	}

	public XeroxException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public XeroxException(String message)
	{
		super(message);
	}

	public XeroxException(Throwable cause)
	{
		super(cause);
	}

}
