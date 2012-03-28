package com.ecommerce.econcierge.cfg;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.ecommerce.econcierge.util.CfgCache;
import com.ecommerce.econcierge.util.StringEncrypter;
import com.ecommerce.econcierge.util.StringEncrypter.EncryptionException;

/**
 * Customize DriverManagerDataSource for xerox
 * 
 * @author EDavid
 *
 */
public class XeroxDriverManagerDataSource extends DriverManagerDataSource
{
	
	/*
	 * Decrypt the password provided
	 * @see org.springframework.jdbc.datasource.AbstractDriverBasedDataSource#getPassword()
	 */
	@Override
	public String getPassword()
	{
		try
		{
			StringEncrypter crypt = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, CfgCache.xerox.xeroxEncryptionKey());
			String password = crypt.decrypt(super.getPassword());
			return password;
		} catch (EncryptionException e)
		{
			throw new XeroxRuntimeException("Error database password decryption : "+e.getMessage());
		}
	}

}
