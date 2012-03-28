package com.ecommerce.econcierge;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;

import com.ecommerce.econcierge.cfg.XeroxApplicationContext;
import com.ecommerce.econcierge.cfg.XeroxServiceException;
import com.ecommerce.econcierge.service.XeroxService;
import com.ecommerce.econcierge.util.StringEncrypter;
import com.ecommerce.econcierge.util.StringEncrypter.EncryptionException;

/**
 * The main class in executing the push data to Xerox eXoncierge
 * 
 * @author EDavid
 * 
 */
public class EconciergeBatchMain implements XeroxApplicationContext
{
	private static Logger logger = Logger.getLogger(EconciergeBatchMain.class);

	/**
	 * Provide the valid action depends on the arguments
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		try
		{
			// default as backend application
			boolean isBackEndAppAction = true;

			// check if not default
			if (args != null && args.length > 0)
			{
				// validate argument type
				if ("-action".equals(args[0]))
				{
					// validate action type
					if (args.length > 1)
					{
						if ("crypt".equals(args[1]))
						{
							isBackEndAppAction = false;
						} else if ("app".equals(args[1]))
						{
							isBackEndAppAction = true;
						} else
						{
							// invalid action type
							displayInvalidActionType();
							exit();
						}
					} else
					{
						// action type not set
						displayActionTypeNotSet();
						exit();
					}
				} else if ("-help".equals(args[0]))
				{
					// display usage
					displayUsageHelp();
					exit();
				} else
				{
					// invalid argument
					displayInvalidFirstArgument();
					exit();
				}
			}

			if (isBackEndAppAction)
			{
				// run the backend application
				runBackendApplication();
				exit();
			} else
			{
				// run ecnryption if valid
				boolean isValidArgs = true;
				String arg = "";

				// validate arguments
				if (args.length >= 6)
				{
					if (!"-key".equals(args[2]))
					{
						isValidArgs = false;
						arg = args[2];
					} else if (!"-value".equals(args[4]))
					{
						isValidArgs = false;
						arg = args[4];
					} else if (args[3].length() < 24)
					{
						displayIncorrectEncryptionKey(args[3]);
						exit();
					}
				} else
				{
					isValidArgs = false;
				}
				if (isValidArgs)
				{
					// perform encryption
					encrypt(args[3], args[5]);
				} else
				{
					// invalid encryption arguments
					displayInvalidEncryptionArg(arg);
					exit();
				}
			}
		} catch (Exception e)
		{
			//display program error message
			displayProgramError(e);
		}
	}

	/**
	 * Display program error message
	 * @param e
	 */
	private static void displayProgramError(Exception e)
	{
		System.err.print("Program error, please report to pcmall developers : "+e.getMessage());		
	}
	
	/**
	 * Invalid encryption key
	 * 
	 * @param arg
	 */
	private static void displayIncorrectEncryptionKey(String arg)
	{
		System.err.println("Invalid encryption argument [" + arg + "].Key must be greater than or equal to 24 character.");
	}

	/**
	 * Invalid encryption argument.
	 */
	private static void displayInvalidEncryptionArg(String arg)
	{
		System.err.println("Invalid encryption argument [" + arg + "].");
	}

	/**
	 * Action type is not provided.
	 */
	private static void displayActionTypeNotSet()
	{
		System.err.println("Please provide a valid action type.");
	}

	/**
	 * Error for Invalid action type.
	 */
	private static void displayInvalidActionType()
	{
		System.err.println("Invalid action type.Expected  [crypt] or [app] as action type.");
	}

	/**
	 * Error for invalid first argument.
	 */
	private static void displayInvalidFirstArgument()
	{
		System.err.println("Invalid argument type.Expected [-action] as first argument");
	}

	/**
	 * -help --> Display the usage
	 */
	private static void displayUsageHelp()
	{
		System.out.println("usage : [options] ");
		System.out.println("options : ");
		System.out.println("-help --> Display usage.");
		System.out.println("-action app --> Execute the Backend Application.");
		System.out
				.println("-action crypt -key <encryption key> -value <any string> --> Encrypt a string given an ecryption key. Ecryption key must be greated than or equal to 24 character.");
	}

	/**
	 * Encrypt
	 * 
	 * @param key
	 * @param value
	 */
	private static void encrypt(String key, String value) throws EncryptionException
	{
		String encrypted = new StringEncrypter(StringEncrypter.DESEDE_ENCRYPTION_SCHEME, key).encrypt(value);
		System.out.println("Ecryption Report :");
		System.out.println("Encrytion Key : " + key);
		System.out.println("String Original Value : " + value);
		System.out.println("String Encrypted Value : " + encrypted);
	}

	/**
	 * Exit code
	 */
	private static void exit()
	{
		System.exit(0);
	}

	/**
	 * Three thread will be run.The process confirmed orders, process cancelled
	 * orders,process shipment notifications
	 * 
	 */
	private static void runBackendApplication()
	{
		try
		{
			logger.info("Started the Xerox eConcierge back end processing.");
			// An instance of xerox service, from spring application context
			XeroxService xeroxService = context.getBean(XeroxService.class);

			// Start the process confirmed orders
			processConfirmedOrders(xeroxService);

			// Start the process cancelled orders
			processCancelledOrders(xeroxService);

			// Start the shipment notifications
			processShipmentNotifications(xeroxService);
			logger.info("All threads has been started.");
		} catch (BeansException e)
		{
			logger.error(e);
		} catch (XeroxServiceException e)
		{
			logger.error(e);
		}
	}

	/**
	 * Start the process confirmed orders
	 * 
	 * @param xeroxService
	 * @throws XeroxServiceException 
	 */
	private static void processShipmentNotifications(XeroxService xeroxService) throws XeroxServiceException
	{
		xeroxService.processShipmentNotification();
	}

	/**
	 * Start the process cancelled orders
	 * 
	 * @param xeroxService
	 * @throws XeroxServiceException 
	 */
	private static void processCancelledOrders(XeroxService xeroxService) throws XeroxServiceException
	{
		xeroxService.processCancelledOrders();
	}

	/**
	 * Start the shipment notifications
	 * 
	 * @param xeroxService
	 * @throws XeroxServiceException 
	 */
	private static void processConfirmedOrders(XeroxService xeroxService) throws XeroxServiceException
	{
		xeroxService.processConfirmedOrders();
	}
}
