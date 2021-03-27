package com.polinayantsen.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutExpressions {

    @Pointcut("execution(* com.polinayantsen.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.polinayantsen.aopdemo.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("execution(* com.polinayantsen.aopdemo.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterNoSetter() {}
}
