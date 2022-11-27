package com.gsu.app.jobsplanet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LoggingAspect {
	
	Logger logger = LogManager.getLogger();

	 //AOP expression for which methods shall be intercepted
	  @Around("execution(* com.gsu.app.jobsplanet.controller..*(..)))")
	  public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable 
	  {
	    MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
	     
	    //Get intercepted method details
	    String className = methodSignature.getDeclaringType().getSimpleName();
	    String methodName = methodSignature.getName();
	     
	    final StopWatch stopWatch = new StopWatch();
	     
	    //Measure method execution time
	    stopWatch.start();
	    Object result = proceedingJoinPoint.proceed();
	    stopWatch.stop();
	 
	    //Log method execution time
	    logger.info("Execution time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis() + " ms");
	 
	    return result;
	  }
	
	
}
