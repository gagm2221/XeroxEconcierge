package com.ecommerce.econcierge.cfg;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Service;

/**
 * Will able to log start,end and exception for each method tag as @Logit
 * 
 * @author edavid
 * 
 */
@Aspect
@Service
public class MethodLogger
{
	/**
	 * Log start method
	 * 
	 * @param jp
	 */
	@Before("@annotation(com.ecommerce.econcierge.cfg.LogIt)")
	public void methodStart(JoinPoint jp)
	{
		Logger logger = getLogger(jp);
		String methodName = getMethodName(jp);
		logger.info("Start - " + methodName);
	}

	/**
	 * Log end method
	 * 
	 * @param jp
	 */
	@AfterReturning(pointcut = "@annotation(com.ecommerce.econcierge.cfg.LogIt)")
	public void methodEnd(JoinPoint jp)
	{
		Logger logger = getLogger(jp);
		String methodName = getMethodName(jp);
		logger.info("End - " + methodName);
	}

	/**
	 * Log when exception occurs
	 * 
	 * @param jp
	 * @param ex
	 */
	@AfterThrowing(pointcut = "@annotation(com.ecommerce.econcierge.cfg.LogIt)", throwing = "ex")
	public void throwMethod(JoinPoint jp, Throwable ex)
	{
		Logger logger = getLogger(jp);
		String methodName = getMethodName(jp);
		logger.error("Error - " + methodName + " - " + ex.getMessage());
	}

	/**
	 * Get the method that this join point surrounds. Used for logging the entry
	 * into a method.
	 * 
	 * @param jp
	 * @return
	 */
	private String getMethodName(JoinPoint jp)
	{
		MethodSignature met = (MethodSignature) jp.getSignature();
		return met.getMethod().getName();
	}

	/**
	 * Class logger
	 * 
	 * @param jp
	 * @return
	 */
	private Logger getLogger(JoinPoint jp)
	{
		return Logger.getLogger(jp.getTarget().getClass());
	}
}
