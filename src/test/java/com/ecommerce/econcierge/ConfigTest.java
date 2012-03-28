package com.ecommerce.econcierge;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.cfg.XeroxDriverManagerDataSource;
import com.ecommerce.econcierge.cfg.XeroxProperties;
import com.ecommerce.econcierge.dao.XeroxDao;
import com.ecommerce.econcierge.jaxws.XeroxWs;
import com.ecommerce.econcierge.service.XeroxService;
import com.ecommerce.econcierge.sp.CancelledOrdersSp;
import com.ecommerce.econcierge.sp.ConfirmedOrdersSp;
import com.ecommerce.econcierge.sp.ShipmentNotificationSp;

/**
 * Test xerox configuration are running properly.
 * 
 * @author edavid
 * 
 */
public class ConfigTest extends TestCase implements XeroxApplicationContext
{
	private static Logger logger = Logger.getLogger(ConfigTest.class);

	protected void setUp() throws Exception
	{
		super.setUp();
	}

	protected void tearDown() throws Exception
	{
		super.tearDown();
	}

	/**
	 * Test method
	 */
	public void testConfig()
	{
		validateDataSource();
		validateXeroxPropertiesBean();
		validateSPsExist();
		validateDaosExist();
		validateWebServicesExist();
		validateServicesExist();
	}

	/**
	 * Validate data source bean
	 */
	private void validateDataSource()
	{
		try
		{
			logger.info("Start validateDataSource");
			Object ccproductds = context.getBean("ccproductds");
			assertTrue("Data source is not configured properly.", ccproductds instanceof XeroxDriverManagerDataSource);
			logger.info("End validateDataSource");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateDataSource : " + e.getMessage(), false);
			logger.error("Error validateDataSource : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating dataSource [ccproductds] : " + e.getMessage(), false);
			logger.error("Error validateDataSource : " + e.getMessage());
		}
	}

	/**
	 * Validate xerox properties bean
	 */
	private void validateXeroxPropertiesBean()
	{
		try
		{
			logger.info("Start validateXeroxPropertiesBean");
			XeroxProperties xeroxProperties = context.getBean(XeroxProperties.class);
			assertNotNull("XeroxProperties is null, it might nor configured properly.", xeroxProperties);
			logger.info("End validateXeroxPropertiesBean");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateXeroxPropertiesBean : " + e.getMessage(), false);
			logger.error("Error validateXeroxPropertiesBean : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateXeroxPropertiesBean  : " + e.getMessage(), false);
			logger.error("Error validateXeroxPropertiesBean : " + e.getMessage());
		}
	}

	/**
	 * Validate sp related bean
	 */
	private void validateSPsExist()
	{
		validateConfirmedOrders();
		validateCancelledOrders();
		validateShipNotifications();
	}

	/**
	 * Validate confirmed orders sp bean
	 */
	private void validateConfirmedOrders()
	{
		try
		{
			logger.info("Start validateConfirmedOrders");
			ConfirmedOrdersSp sp = context.getBean(ConfirmedOrdersSp.class);
			assertNotNull("ConfirmedOrdersSp is null,it might nor configured properly ", sp);
			logger.info("End validateConfirmedOrders");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateConfirmedOrders : " + e.getMessage(), false);
			logger.error("Error validateConfirmedOrders : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateConfirmedOrders  : " + e.getMessage(), false);
			logger.error("Error validateConfirmedOrders : " + e.getMessage());
		}
	}

	/**
	 * Validate Cancelled orders bean
	 */
	private void validateCancelledOrders()
	{
		try
		{
			logger.info("Start validateCancelledOrders");
			CancelledOrdersSp sp = context.getBean(CancelledOrdersSp.class);
			assertNotNull("CancelledOrdersSp is null,it might nor configured properly ", sp);
			logger.info("End validateCancelledOrders");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateCancelledOrders : " + e.getMessage(), false);
			logger.error("Error validateCancelledOrders : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateCancelledOrders  : " + e.getMessage(), false);
			logger.error("Error validateCancelledOrders : " + e.getMessage());
		}
	}

	/**
	 * Validate ship notification sp bean
	 */
	private void validateShipNotifications()
	{
		try
		{
			logger.info("Start validateShipNotifications");
			ShipmentNotificationSp sp = context.getBean(ShipmentNotificationSp.class);
			assertNotNull("ShipmentNotificationSp is null,it might nor configured properly ", sp);
			logger.info("End validateShipNotifications");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateShipNotifications : " + e.getMessage(), false);
			logger.error("Error validateShipNotifications : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateShipNotifications  : " + e.getMessage(), false);
			logger.error("Error validateShipNotifications : " + e.getMessage());
		}
	}

	/**
	 * Validate Service related sp's bean
	 */
	private void validateServicesExist()
	{
		try
		{
			logger.info("Start validateServicesExist");
			XeroxService service = context.getBean(XeroxService.class);
			assertNotNull("XeroxService is null,it might nor configured properly ", service);
			logger.info("End validateServicesExist");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateServicesExist : " + e.getMessage(), false);
			logger.error("Error validateServicesExist : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateServicesExist  : " + e.getMessage(), false);
			logger.error("Error validateServicesExist : " + e.getMessage());
		}
	}

	/**
	 * Validate web service related bean
	 */
	private void validateWebServicesExist()
	{
		try
		{
			logger.info("Start validateWebServicesExist");
			XeroxWs ws = context.getBean(XeroxWs.class);
			assertNotNull("XeroxWs is null,it might nor configured properly ", ws);
			logger.info("End validateWebServicesExist");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateWebServicesExist : " + e.getMessage(), false);
			logger.error("Error validateWebServicesExist : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateWebServicesExist  : " + e.getMessage(), false);
			logger.error("Error validateWebServicesExist : " + e.getMessage());
		}
	}

	/**
	 * Validate dao layer sp bean
	 */
	private void validateDaosExist()
	{
		try
		{
			logger.info("Start validateDaosExist");
			XeroxDao dao = context.getBean(XeroxDao.class);
			assertNotNull("XeroxDao is null,it might nor configured properly ", dao);
			logger.info("End validateDaosExist");
		} catch (BeansException e)
		{
			assertTrue("Spring configuration validateDaosExist : " + e.getMessage(), false);
			logger.error("Error validateDaosExist : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Exception on validating validateDaosExist  : " + e.getMessage(), false);
			logger.error("Error validateDaosExist : " + e.getMessage());
		}
	}
}
