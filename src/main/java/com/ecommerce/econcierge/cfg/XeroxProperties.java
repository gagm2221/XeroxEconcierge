package com.ecommerce.econcierge.cfg;

/**
 * Use to get the xerox.properties
 * 
 * @author EDavid
 * 
 */
public interface XeroxProperties
{
	/**
	 * Get the location of the WSDL
	 * 
	 * @return
	 */
	String wsdlLocation();

	/**
	 * Use to get the username for xerox web service
	 * 
	 * @return
	 */
	String xeroxWsUsername();

	/**
	 * use to get the password for xerox web service
	 * 
	 * @return
	 */
	String xeroxWsPassword();

	/**
	 * The xerox service port
	 * 
	 * @return
	 */
	String xeroxServicePort();

	/**
	 * The encryption key provided
	 * 
	 * @return
	 */
	String xeroxEncryptionKey();

	/**
	 * The shipment tracking URL
	 * 
	 * @param trackingNumber
	 * @return
	 */
	String shipmentTrackingUrl(String trackingNumber);
}
