package com.ecommerce.econcierge.cfg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ecommerce.econcierge.util.StringEncrypter;
import com.ecommerce.econcierge.util.StringEncrypter.EncryptionException;

/**
 * Property Configuration For Xerox
 * 
 * @author EDavid
 * 
 */
@Component("xeroxProperties")
public class XeroxPropertiesImpl implements XeroxProperties
{
	/**
	 * The value for the xerox wsdl location
	 */
	@Value("${xerox.wsdl.location}")
	private String wsdlLocation;

	public String wsdlLocation()
	{
		return wsdlLocation;
	}

	/**
	 * The username for xerox web service
	 */
	@Value("${xerox.ws.username}")
	private String xeroxWsUsername;

	public String xeroxWsUsername()
	{
		return xeroxWsUsername;
	}

	/**
	 * The password for xerox web service
	 */
	@Value("${xerox.ws.password}")
	private String xeroxWsPassword;

	public String xeroxWsPassword()
	{
		try
		{
			StringEncrypter crypt = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, xeroxEncryptionKey());
			return crypt.decrypt(xeroxWsPassword);
		} catch (EncryptionException e)
		{
			throw new XeroxRuntimeException("Error getting the  xeroxWsPassword : "+e.toString());
		}
	}

	/**
	 * The Xerox Web Service port
	 */
	@Value("${xerox.ws.servicePort}")
	private String xeroxServicePort;
	
	public String xeroxServicePort()
	{
		return xeroxServicePort;
	}
	
	/**
	 * The encryption key provided
	 */
	@Value("${xerox.encryptionKey}")
	private String encryptionKey;

	public String xeroxEncryptionKey()
	{
		return encryptionKey;
	}
}
