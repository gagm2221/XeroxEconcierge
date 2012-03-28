package com.ecommerce.econcierge.util;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.cfg.XeroxProperties;

/**
 * Use to get the value from property files
 * 
 * @author EDavid
 * 
 */
public final class CfgCache implements XeroxApplicationContext
{
	// the xerox.properties
	public static final XeroxProperties xerox;

	/**
	 * The avoid instantion of this class
	 */
	private CfgCache()
	{
	}

	static
	{
		// create an instance of xerox properties
		xerox = context.getBean(XeroxProperties.class);
	}

}
