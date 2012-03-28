package com.ecommerce.econcierge.cfg;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * An interface class that will contain the Spring application Context
 * 
 * @author EDavid
 * 
 */
public interface XeroxApplicationContext
{
	/**
	 * ' The Spring application context
	 * 
	 */
	public static final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

}
