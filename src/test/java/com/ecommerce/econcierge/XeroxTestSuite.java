package com.ecommerce.econcierge;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;

/**
 * Test Suite for xerox
 * 
 * @author edavid
 * 
 */
public class XeroxTestSuite
{
	private static Logger logger = Logger.getLogger(XeroxTestSuite.class);

	/**
	 * List of test cases 1.ConfigTest 2.UtilTest
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Test suite() throws Exception
	{
		try
		{
			logger.info("Xerox test suite started.");
			TestSuite suite = new TestSuite(XeroxTestSuite.class.getName());
			// $JUnit-BEGIN$
			suite.addTestSuite(ConfigTest.class);
			suite.addTestSuite(UtilTest.class);
			suite.addTestSuite(WebServiceTest.class);
			// $JUnit-END$
			logger.info("Xerox test suite finish.");
			return suite;
		} catch (Exception e)
		{
			logger.error("Xerox test suite error : " + e.getMessage());
			throw e;
		}
	}

}
