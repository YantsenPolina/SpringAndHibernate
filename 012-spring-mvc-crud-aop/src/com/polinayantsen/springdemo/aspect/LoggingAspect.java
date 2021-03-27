package com.polinayantsen.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Pointcut("execution(* com.polinayantsen.springdemo.controller.*.*(..))")
    private void controller() {}

    @Pointcut("execution(* com.polinayantsen.springdemo.service.*.*(..))")
    private void service() {}

    @Pointcut("execution(* com.polinayantsen.springdemo.dao.*.*(..))")
    private void dao() {}

    @Pointcut("controller() || service() || dao()")
    private void appFlow() {}

    @Before("appFlow()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("====> @Before advice. Method: " + joinPoint.getSignature().toShortString());
        Object[] arguments = joinPoint.getArgs();
        for (Object arg : arguments) {
            logger.info("====> @Before advice. Argument: " + arg);
        }
    }

    @AfterReturning(pointcut = "appFlow()", returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, Object result) {
        logger.info("====> @AfterReturning advice. Method: " + joinPoint.getSignature().toShortString());
        logger.info("====> @AfterReturning advice. Data returned: " + result);
    }
}
