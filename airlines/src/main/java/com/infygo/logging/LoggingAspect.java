package com.infygo.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	private static final Log LOGGER=LogFactory.getLog(LoggingAspect.class);
	private void logTimestamp() {
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        LOGGER.info("Timestamp: " + timeStamp);
    }
	
	@Before("execution(* com.infygo.service.*.addNewFlight(..))")
    public void logBeforeAddingFlight(JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logTimestamp();

        LOGGER.info("About to add a new flight. Method: " + className + "." + methodName);
    }

    @AfterReturning("execution(* com.infygo.service.*.addNewFlight(..))")
    public void logAfterAddingFlight() throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.info("New Flight Added");
    }

    @AfterThrowing(pointcut = "execution(* com.infygo.service.*.addNewFlight(..))", throwing = "exception")
    public void logErrorAddingFlight(Exception exception) throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.error("Failed to add Flight: " + exception);
    }
    
    @Before("execution(* com.infygo.service.*.deleteFlight(..))")
    public void logBeforeDeletingFlight(JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logTimestamp();

        LOGGER.info("About to Delete flight. Method: " + className + "." + methodName);
    }

    @AfterReturning("execution(* com.infygo.service.*.deleteFlight(..))")
    public void logAfterDeletingFlight() throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.info("Flight Deleted");
    }

    @AfterThrowing(pointcut = "execution(* com.infygo.service.*.deleteFlight(..))", throwing = "exception")
    public void logErrorDeletingFlight(Exception exception) throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.error("Failed to Delete Flight: " + exception);
    }
    
    @Before("execution(* com.infygo.service.*.searchFlight(..))")
    public void logBeforesearchingFlight(JoinPoint joinPoint) throws Exception {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getName();

        logTimestamp();

        LOGGER.info("About to Search flights. Method: " + className + "." + methodName);
    }

    @AfterReturning("execution(* com.infygo.service.*.searchFlight(..))")
    public void logAfterSearchingFlight() throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.info("Required Flights fetched Successfully");
    }

    @AfterThrowing(pointcut = "execution(* com.infygo.service.*.searchFlight(..))", throwing = "exception")
    public void logErrorsearchingFlight(Exception exception) throws Exception {
        // Log current date and time stamp
        logTimestamp();

        LOGGER.error("Failed to Fetch Flights: " + exception);
    }

}
