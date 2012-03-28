package com.ecommerce.econcierge.cfg;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * Extension of Spring @Component Use o define a class that it is for web service
 * 
 * @author EDavid
 * 
 */
@Target(
{ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebService
{
	String value() default "";
}
