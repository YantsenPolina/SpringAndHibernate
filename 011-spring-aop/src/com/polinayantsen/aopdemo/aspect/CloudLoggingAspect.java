package com.polinayantsen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class CloudLoggingAspect {

    @Before("com.polinayantsen.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterNoSetter())")
    public void loggingToCloud() {
        System.out.println("====> Logging to Cloud");
    }
}
