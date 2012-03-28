package com.ecommerce.econcierge.cfg;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * Extension of Spring Component. This is use to tag a class as Stored Procedure
 * 
 * @author EDavid
 * 
 */
@Target(
{ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface StoredProcedure
{
	String value() default "";
}
