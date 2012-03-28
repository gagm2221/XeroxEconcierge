package com.ecommerce.econcierge.cfg;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.HandlerResolver;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.PortInfo;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.ecommerce.econcierge.util.CfgCache;
import com.sun.xml.wss.XWSSecurityException;
import com.sun.xml.wss.impl.MessageConstants;
import com.sun.xml.wss.impl.SecurityTokenException;
import com.sun.xml.wss.impl.misc.Base64;
import com.sun.xml.wss.logging.LogDomainConstants;

/**
 * Handles the security token for soap jax-ws web service
 * 
 * 
 * @author EDavid
 * 
 */
public abstract class AbstractJaxWs extends Service
{

	protected AbstractJaxWs(URL arg0, QName arg1)
	{
		super(arg0, arg1);
	}
	
	/**
	 * Overide to set the
	 * https://test.econciergetools.com/esb-integration/OrderEventService as soap
	 * service point
	 */
	@Override
	public <T> T getPort(QName portName, Class<T> serviceEndpointInterface)
	{
		T service = super.getPort(portName, serviceEndpointInterface);
		BindingProvider dispatch = ((BindingProvider) service);
		dispatch.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, CfgCache.xerox.xeroxServicePort());
		return service;
	}
	/**
	 * For Authentication of header [UsernameToken]
	 * 
	 * @param username
	 * @param password
	 * @param isPasswordDisget
	 */
	protected void setHandlerResolver(final String username, final String password, final boolean isPasswordDisget)
	{
		this.setHandlerResolver(new HandlerResolver()
		{

			@SuppressWarnings("rawtypes")
			public List<Handler> getHandlerChain(PortInfo info)
			{
				List<Handler> handlerList = new ArrayList<Handler>();
				// if password digest
				if (isPasswordDisget)
					handlerList.add(new UsernameTokenPasswordDigestHandler(username, password));
				// if password text
				else
					handlerList.add(new UsernameTokenPasswordTextHandler(username, password));
				return handlerList;
			}
		});
	}

	/**
	 * This Will handle the header for Usernametoken of SOAP
	 * 
	 */
	private static abstract class UsernameTokenHandler implements SOAPHandler<SOAPMessageContext>
	{
		static final String WSSE_NAMESPACE_XSD;
		static final String WSU_NAMESPACE_XSD;

		static
		{
			WSSE_NAMESPACE_XSD = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
			WSU_NAMESPACE_XSD = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
		}

		private String username;
		private String password;

		public UsernameTokenHandler(String username, String password)
		{
			this.username = username;
			this.password = password;
		}

		public void close(MessageContext ctx)
		{
		}

		public boolean handleFault(SOAPMessageContext ctx)
		{
			// throw new
			// UnsupportedOperationException("Error Creating Password Digest.");
			return false;
		}

		public Set<QName> getHeaders()
		{
			return new TreeSet<QName>();
		}

		public String getUsername()
		{
			return username;
		}

		public String getPassword()
		{
			return password;
		}
	}

	/**
	 * Username Token handler when password type use is text
	 * 
	 * @author EDavid
	 * 
	 */
	private static class UsernameTokenPasswordTextHandler extends UsernameTokenHandler
	{

		private static final String PASSWORD_TEXT_TYPE;

		static
		{
			PASSWORD_TEXT_TYPE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText";
		}

		public UsernameTokenPasswordTextHandler(String username, String password)
		{
			super(username, password);
		}

		public boolean handleMessage(SOAPMessageContext ctx)
		{
			Boolean outboundProperty = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (outboundProperty.booleanValue())
			{
				try
				{
					SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
					SOAPHeader header = envelope.addHeader();

					SOAPElement security = header.addChildElement("Security", "wsse", WSSE_NAMESPACE_XSD);
					security.addAttribute(new QName(envelope.getElementQName().getPrefix() + ":mustUnderstand"), "1");

					SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
					usernameToken.addNamespaceDeclaration("wsu", WSU_NAMESPACE_XSD);
					usernameToken.addAttribute(new QName("wsu:Id"), String.valueOf(System.currentTimeMillis()));

					SOAPElement username = usernameToken.addChildElement("Username", "wsse");
					username.addTextNode(this.getUsername());

					SOAPElement password = usernameToken.addChildElement("Password", "wsse");
					password.setAttribute("Type", PASSWORD_TEXT_TYPE);
					password.addTextNode(this.getPassword());

				} catch (Exception e)
				{
					throw new RuntimeException("Exception in handler: " + e);
				}
			} else
			{
				// for inbound
			}
			return true;
		}
	}

	/**
	 * Username token handler when password type use is password digest
	 * 
	 * @author EDavid
	 * 
	 */
	private static class UsernameTokenPasswordDigestHandler extends UsernameTokenHandler
	{
		private static final String PASSWORD_DIGEST_TYPE;
		private static final String NONCE_ENCODING_TYPE;

		static
		{
			PASSWORD_DIGEST_TYPE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordDigest";
			NONCE_ENCODING_TYPE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary";
		}

		public UsernameTokenPasswordDigestHandler(String username, String password)
		{
			super(username, password);
		}

		public boolean handleMessage(SOAPMessageContext ctx)
		{
			Boolean outboundProperty = (Boolean) ctx.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
			if (outboundProperty.booleanValue())
			{
				try
				{
					DigestGenerator digestPassword = new DigestGenerator(this.getPassword());
					digestPassword.createNonce();
					digestPassword.createDigest();

					SOAPEnvelope envelope = ctx.getMessage().getSOAPPart().getEnvelope();
					SOAPHeader header = envelope.addHeader();

					SOAPElement security = header.addChildElement("Security", "wsse", WSSE_NAMESPACE_XSD);
					security.addAttribute(new QName(envelope.getElementQName().getPrefix() + ":mustUnderstand"), "1");

					SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
					usernameToken.addNamespaceDeclaration("wsu", WSU_NAMESPACE_XSD);
					usernameToken.addAttribute(new QName("wsu:Id"), String.valueOf(System.currentTimeMillis()));

					SOAPElement username = usernameToken.addChildElement("Username", "wsse");
					username.addTextNode(this.getUsername());

					SOAPElement password = usernameToken.addChildElement("Password", "wsse");
					password.setAttribute("Type", PASSWORD_DIGEST_TYPE);
					password.addTextNode(digestPassword.getPasswordDigest());

					SOAPElement nonce = usernameToken.addChildElement("Nonce", "wsse");
					nonce.setAttribute("EncodingType", NONCE_ENCODING_TYPE);
					nonce.addTextNode(digestPassword.getNonce());

					SOAPElement created = usernameToken.addChildElement("Created", "wsu");
					created.addTextNode(digestPassword.getCreated());

				} catch (Exception e)
				{
					throw new RuntimeException("Exception in handler: " + e);
				}
			} else
			{
				// for inbound
			}
			return true;
		}

	}

	/**
	 * 
	 * Will create nonce, created and password digest for password digest type of
	 * username token
	 * 
	 */
	private static class DigestGenerator
	{

		public DigestGenerator(String password) throws XWSSecurityException
		{
			this.created = getCreatedFromTimestamp();
			this.password = password;
		}

		private static Logger logger = Logger.getLogger(LogDomainConstants.WSS_API_DOMAIN, LogDomainConstants.WSS_API_DOMAIN_BUNDLE);

		private String password = null;

		// password Digest value
		private String passwordDigest = null;

		private byte[] decodedNonce = null;

		// specifies a cryptographically random sequence
		private String nonce = null;

		// default nonce encoding
		private String nonceEncodingType = MessageConstants.BASE64_ENCODING_NS;

		// time stamp to indicate creation time
		private String created = null;

		/*
		 * Create a unique nonce. Default encoded with base64. A nonce is a random
		 * value that the sender creates to include in the username token that it
		 * sends. Nonce is an effective counter measure against replay attacks.
		 */
		public void createNonce()
		{

			this.decodedNonce = new byte[18];
			try
			{
				SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
				random.nextBytes(decodedNonce);
			} catch (NoSuchAlgorithmException e)
			{
				logger.log(Level.SEVERE, "WSS0310.no.such.algorithm", new Object[]
				{ e.getMessage() });
				throw new RuntimeException("No such algorithm found" + e.getMessage());
			}
			if (MessageConstants.BASE64_ENCODING_NS == nonceEncodingType)
				this.nonce = Base64.encode(decodedNonce, 0);
			else
			{
				logger.log(Level.SEVERE, "WSS0389.unrecognized.nonce.encoding", nonceEncodingType);
				throw new RuntimeException("Unrecognized encoding: " + nonceEncodingType);
			}
		}

		/*
		 * Password Digest creation. As per WSS-UsernameToken spec, if either or
		 * both of <wsse:Nonce> and <wsu:Created> are present, then they must be
		 * included in the digest as follows:
		 * 
		 * Password_digest = Base64( SHA_1 (nonce + created + password) )
		 */
		public void createDigest() throws SecurityTokenException
		{

			String utf8String = "";
			if (created != null)
			{
				utf8String = utf8String + created;
			}

			// password is also optional
			if (password != null)
			{
				utf8String = utf8String + password;
			}

			byte[] utf8Bytes;
			try
			{
				utf8Bytes = utf8String.getBytes("utf-8");
			} catch (UnsupportedEncodingException uee)
			{
				logger.log(Level.SEVERE, "WSS0390.unsupported.charset.exception");
				throw new SecurityTokenException(uee);
			}

			byte[] bytesToHash;
			if (decodedNonce != null)
			{
				bytesToHash = new byte[utf8Bytes.length + 18];
				for (int i = 0; i < 18; i++)
					bytesToHash[i] = decodedNonce[i];
				for (int i = 18; i < utf8Bytes.length + 18; i++)
					bytesToHash[i] = utf8Bytes[i - 18];
			} else
			{
				bytesToHash = utf8Bytes;
			}

			byte[] hash;
			try
			{
				MessageDigest sha = MessageDigest.getInstance("SHA-1");
				hash = sha.digest(bytesToHash);
			} catch (Exception e)
			{
				logger.log(Level.SEVERE, "WSS0311.passwd.digest.couldnot.be.created", new Object[]
				{ e.getMessage() });
				throw new SecurityTokenException("Password Digest could not be created. " + e.getMessage());
			}
			this.passwordDigest = Base64.encode(hash, 0);
		}

		private String getCreatedFromTimestamp() throws XWSSecurityException
		{
			return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'").format(new Date(System.currentTimeMillis()));
		}

		public String getPasswordDigest()
		{
			return passwordDigest;
		}

		public String getNonce()
		{
			return nonce;
		}

		public String getCreated()
		{
			return created;
		}
	}

}
