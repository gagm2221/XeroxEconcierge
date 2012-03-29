package com.ecommerce.econcierge;

import org.apache.log4j.Logger;

import junit.framework.TestCase;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.util.CfgCache;
import com.ecommerce.econcierge.util.StringEncrypter;
import com.ecommerce.econcierge.util.StringEncrypter.EncryptionException;

/**
 * Validate Utilities
 * 
 * @author edavid
 * 
 */
public class UtilTest extends TestCase implements XeroxApplicationContext
{
	private static Logger logger = Logger.getLogger(UtilTest.class);

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
	 * 
	 */
	public void testUtils()
	{
		validateCfgCache();
		validateStringEncrypter();
	}

	/**
	 * Validate Cfg CacheUtil
	 */
	private void validateCfgCache()
	{
		validateWsdlLocation();
		validateXeroxWsUsername();
		validateXeroxWsPassword();
		validateXeroxServicePort();
		validateXeroxEncryptionKey();
		validateTrackingUrl();
	}

	/**
	 * Validate wsdlLocation exist
	 */
	private void validateWsdlLocation()
	{
		logger.info("Start validateWsdlLocation");
		String value = CfgCache.xerox.wsdlLocation();
		logger.info("wsdl location : " + value);
		assertNotNull("wsdlLocation is not set.", value);
		logger.info("End validateWsdlLocation");
	}

	/**
	 * Validate xeroxWsUsername exist
	 */
	private void validateXeroxWsUsername()
	{
		logger.info("Start validateXeroxWsUsername");
		String value = CfgCache.xerox.xeroxWsUsername();
		logger.info("ws username : " + value);
		assertNotNull("xeroxWsUsername is not set", value);
		logger.info("End validateXeroxWsUsername");
	}

	/**
	 * xeroxWsPassword exist
	 */
	private void validateXeroxWsPassword()
	{
		logger.info("Start validateXeroxWsPassword");
		String value = CfgCache.xerox.xeroxWsPassword();
		logger.info("xerox password : " + value);
		assertNotNull("xeroxWsPassword is not set", value);
		logger.info("End validateXeroxWsPassword");
	}

	/**
	 * xeroxServicePort exist
	 */
	private void validateXeroxServicePort()
	{
		logger.info("Start validateXeroxServicePort");
		String value = CfgCache.xerox.xeroxServicePort();
		logger.info("xerox service port : " + value);
		assertNotNull("xeroxServicePort is not set", value);
		logger.info("End validateXeroxServicePort");
	}

	/**
	 * validate xeroxEncryptionKey
	 */
	private void validateXeroxEncryptionKey()
	{
		logger.info("Start validateXeroxEncryptionKey");
		String value = CfgCache.xerox.xeroxEncryptionKey();
		logger.info("encryption key : " + value);
		assertNotNull("xeroxEncryptionKey is not set", value);
		logger.info("End validateXeroxEncryptionKey");
	}

	/**
	 * Validate shipment tracking URL
	 */
	private void validateTrackingUrl()
	{
		logger.info("Start validateTrackingUrl");
		String value = CfgCache.xerox.shipmentTrackingUrl("s83fj9Asfg456sdfg");
		logger.info("tracking url : " + value);
		assertNotNull("validateTrackingUrl is not set", value);
		logger.info("End validateTrackingUrl");
	}

	/**
	 * Validate StringEncrypter util
	 */
	private void validateStringEncrypter()
	{
		validateSuccessEncryptionWith24EKey();
		validateLessThan24EKey();
		validateGreaterThan24EKey();
	}

	/**
	 * Validate StringEncrypter when encryption key is equal to 24
	 */
	private void validateSuccessEncryptionWith24EKey()
	{
		try
		{
			logger.info("Start validateSuccessEncryptionWith24EKey");
			String value = "qwerty123456";
			String key = "aAasd8sdfk9Jus8Jlsbf8ldf";
			StringEncrypter crypt = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, key);
			String encryptValue = crypt.encrypt(value);
			String deCryptValue = crypt.decrypt(encryptValue);
			assertEquals("Original and decrypted form encrypted value is not correct.", value, deCryptValue);
			logger.info("End validateSuccessEncryptionWith24EKey");
		} catch (EncryptionException e)
		{
			assertTrue("Encryption Exception Occurs", false);
			logger.error("Error validateSuccessEncryptionWith24EKey : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Encryption Exception Occurs", false);
			logger.error("Error validateSuccessEncryptionWith24EKey : " + e.getMessage());
		}
	}

	/**
	 * Validate StringEncrypter when encryption key is less than to 24
	 */
	private void validateLessThan24EKey()
	{
		try
		{
			logger.info("Start validateLessThan24EKey");
			String value = "qwerty123456";
			String key = "aAasd8sdfk9Jus8Jlsbf8ld";
			StringEncrypter crypt = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, key);
			String encryptValue = crypt.encrypt(value);
			@SuppressWarnings("unused")
			String deCryptValue = crypt.decrypt(encryptValue);
			assertTrue("Expected error, ecryption key is less than 24.", false);
			logger.info("End validateLessThan24EKey");
		} catch (EncryptionException e)
		{
			assertTrue("Encryption Exception Occurs", false);
			logger.error("Error validateLessThan24EKey : " + e.getMessage());
		} catch (IllegalArgumentException e)
		{
			assertTrue(true);
			logger.info("Expected Error validateLessThan24EKey : " + e.getMessage());
		}
	}

	/**
	 * Validate StringEncrypter when encryption key is greater than to 24
	 */
	private void validateGreaterThan24EKey()
	{
		try
		{
			logger.info("Start validateGreaterThan24EKey");
			String value = "qwerty123456";
			String key = "aAasd8sdfk9Jus8Jlsbf8ldf5s";
			StringEncrypter crypt = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, key);
			String encryptValue = crypt.encrypt(value);
			String deCryptValue = crypt.decrypt(encryptValue);
			assertEquals("Original and decrypted form encrypted value is not correct.", value, deCryptValue);
			logger.info("End validateGreaterThan24EKey");
		} catch (EncryptionException e)
		{
			assertTrue("Encryption Exception Occurs", false);
			logger.error("Error validateGreaterThan24EKey : " + e.getMessage());
		} catch (Exception e)
		{
			assertTrue("Encryption Exception Occurs", false);
			logger.error("Error validateGreaterThan24EKey : " + e.getMessage());
		}
	}

}
