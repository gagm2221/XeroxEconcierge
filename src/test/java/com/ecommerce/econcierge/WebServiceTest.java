package com.ecommerce.econcierge;

import org.apache.log4j.Logger;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.cfg.XeroxWebServiceException;
import com.ecommerce.econcierge.jaxws.XeroxWs;

import junit.framework.TestCase;

/**
 * Use to test web service
 * 
 * @author edavid
 * 
 */
public class WebServiceTest extends TestCase implements XeroxApplicationContext
{
	private static Logger logger = Logger.getLogger(WebServiceTest.class);

	/**
	 * Instance of web service
	 */
	private static XeroxWs xeroxWs = context.getBean(XeroxWs.class);

	public void testWebService()
	{
		validatePushCreateOrder();
		validatePushCancelOrder();
		validatePushNotifyShipment();
	}

	/**
	 * Validate Order Confirmation Web Service
	 */
	private void validatePushCreateOrder()
	{
		try
		{
			logger.info("Start validatePushCreateOrder");
			xeroxWs.pushCreateOrder(null);
			logger.info("End validatePushCreateOrder");
		} catch (XeroxWebServiceException e)
		{
			assertTrue("Xerox WS Exception Error testPushCreateOrder : " + e.getMessage(), false);
			logger.error("Xerox WS Exception Error testPushCreateOrder : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Xerox Exception Error testPushCreateOrder: " + e.getMessage(), false);
			logger.error("Xerox Exception Error testPushCreateOrder: " + e.getMessage());
		}
	}

	/**
	 * Validate Order Cancellation Web Service
	 */
	private void validatePushCancelOrder()
	{
		try
		{
			logger.info("Start validatePushCancelOrder");
			xeroxWs.pushCancelOrder(null);
			logger.info("End validatePushCancelOrder");
		} catch (XeroxWebServiceException e)
		{
			assertTrue("Xerox WS Exception Error validatePushCancelOrder : " + e.getMessage(), false);
			logger.error("Xerox WS Exception Error validatePushCancelOrder : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Xerox Exception Error validatePushCancelOrder: " + e.getMessage(), false);
			logger.error("Xerox Exception Error validatePushCancelOrder: " + e.getMessage());
		}
	}

	/**
	 * Validate Shipment Notification Web Service
	 */
	private void validatePushNotifyShipment()
	{
		try
		{
			logger.info("Start validatePushNotifyShipment");
			xeroxWs.pushNotifyShipment(null);
			logger.info("End validatePushNotifyShipment");
		} catch (XeroxWebServiceException e)
		{
			assertTrue("Xerox WS Exception Error validatePushNotifyShipment : " + e.getMessage(), false);
			logger.error("Xerox WS Exception Error validatePushNotifyShipment : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Xerox Exception Error validatePushNotifyShipment: " + e.getMessage(), false);
			logger.error("Xerox Exception Error validatePushNotifyShipment: " + e.getMessage());
		}
	}
}
