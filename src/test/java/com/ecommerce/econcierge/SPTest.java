package com.ecommerce.econcierge;

import java.util.List;

import junit.framework.TestCase;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.model.CancelledOrderModel;
import com.ecommerce.econcierge.model.ConfirmedOrderModel;
import com.ecommerce.econcierge.model.NotifiedShipmentOrderModel;
import com.ecommerce.econcierge.sp.CancelledOrdersSp;
import com.ecommerce.econcierge.sp.ConfirmedOrdersSp;
import com.ecommerce.econcierge.sp.ShipmentNotificationSp;

/**
 * Test SP's that no exception will occur
 * 
 * @author edavid
 * 
 */
public class SPTest extends TestCase implements XeroxApplicationContext
{
	private static final Logger logger = Logger.getLogger(SPTest.class);

	/**
	 * SP's declaration
	 */
	private ConfirmedOrdersSp confirmedOrdersSp = null;
	private CancelledOrdersSp cancelledOrdersSp = null;
	private ShipmentNotificationSp shipmentNotificationSp = null;

	/**
	 * Instantiate SP
	 */
	@Override
	protected void setUp() throws Exception
	{
		super.setUp();
		confirmedOrdersSp = context.getBean(ConfirmedOrdersSp.class);
		cancelledOrdersSp = context.getBean(CancelledOrdersSp.class);
		shipmentNotificationSp = context.getBean(ShipmentNotificationSp.class);
	}

	/**
	 * Null all SP's
	 */
	@Override
	protected void tearDown() throws Exception
	{
		super.tearDown();
		confirmedOrdersSp = null;
		cancelledOrdersSp = null;
		shipmentNotificationSp = null;
	}

	/**
	 * Test method
	 */
	public void testSPs()
	{
		validateConfirmationSp();
		validateCancelledSp();
		validateShipmentNotificationSp();
	}

	/**
	 * Validate if no exception occurs on confirmation SP
	 */
	private void validateConfirmationSp()
	{
		try
		{
			List<ConfirmedOrderModel> list = confirmedOrdersSp.execute();
			logger.info(list.size());
			assertTrue("validateConfirmationSp List must not be null.", list != null);
		} catch (DataAccessException e)
		{
			assertTrue("validateConfirmationSp Error : " + e.getMessage(), false);
		}
	}

	/**
	 * Validate if no exception occurs on cancelled SP
	 */
	private void validateCancelledSp()
	{
		try
		{
			List<CancelledOrderModel> list = cancelledOrdersSp.execute();
			logger.info(list.size());
			assertTrue("validateCancelledSp List must not be null.", list != null);
		} catch (DataAccessException e)
		{
			assertTrue("validateCancelledSp Error : " + e.getMessage(), false);
		}
	}

	/**
	 * Validate if no exception occurs on shipment notification SP
	 */
	private void validateShipmentNotificationSp()
	{
		try
		{
			List<NotifiedShipmentOrderModel> list = shipmentNotificationSp.execute();
			logger.info(list.size());
			assertTrue("validateShipmentNotificationSp List must not be null.", list != null);
		} catch (DataAccessException e)
		{
			assertTrue("validateShipmentNotificationSp Error : " + e.getMessage(), false);
		}
	}
}
