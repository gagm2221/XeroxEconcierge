package com.ecommerce.econcierge.cfg;

/**
 * Exception Use for Dao, this will tag that an exception occurs at dao lebel
 * 
 * @author EDavid
 * 
 */
public class XeroxDataAccessException extends XeroxException
{

	private static final long serialVersionUID = 1L;

	public XeroxDataAccessException()
	{
		super();
	}

	public XeroxDataAccessException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public XeroxDataAccessException(String message)
	{
		super(message);
	}

	public XeroxDataAccessException(Throwable cause)
	{
		super(cause);
	}

}
