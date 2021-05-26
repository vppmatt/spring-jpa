package com.multicode.aspects;

import org.aspectj.lang.*;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.multicode.service.*.* (..))")
    public void logServiceMethods() {}

    @Pointcut("execution(* com.multicode.repositories.*.* (..))")
    public void logRepositoryMethods() {}

    @Before("logServiceMethods()")
    public void logAtStartOfMethod(JoinPoint joinPoint) {
        logger.debug("Starting service method {} with arguments {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @After("logServiceMethods()")
    public void logAtEndOfMethod() {
        logger.debug("Ending service method");
    }

    @Around("logRepositoryMethods()")
    public Object logAroundAMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.debug("Entering repository method {}", proceedingJoinPoint.getSignature().getName());
        Object returnValue = proceedingJoinPoint.proceed();
        logger.debug("Exiting repository method {}", proceedingJoinPoint.getSignature().getName());
        return returnValue;
    }
}
