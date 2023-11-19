package com.infy.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {

	private static final Log LOGGER = LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut="execution(* com.infy.repository.*.*(..))",throwing = "exception")
	public void logRepositoryException(Exception exception) {
		LOGGER.error("Exception caught: " + exception.getMessage());
	}
	
	@AfterThrowing(pointcut="execution(* com.infy.service.*.*(..))",throwing = "exception")
	public void logServiceException(Exception exception) {
		LOGGER.error("Exception caught: " + exception.getMessage());
	}

}