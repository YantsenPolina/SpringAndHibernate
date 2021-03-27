package com.polinayantsen.aopdemo.aspect;

import com.polinayantsen.aopdemo.Account;
import com.polinayantsen.aopdemo.MainApp;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(1)
public class LoggingAspect {

    private static Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    //@Before("execution(public void addAccount())")
    //@Before("execution(public void com.polinayantsen.aopdemo.dao.AccountDAO.addAccount())")
    //@Before("execution(public void add*())")
    //@Before("execution(void add*())")
    //@Before("execution(* add*())")
    //@Before("execution(* add*(com.polinayantsen.aopdemo.Account))")
    //@Before("execution(* add*(com.polinayantsen.aopdemo.Account, ..))")
    //@Before("execution(* add*(..))")
    //@Before("execution(* com.polinayantsen.aopdemo.dao.*.*(..))")
    //@Before("forDaoPackage()")
    @Before("com.polinayantsen.aopdemo.aspect.PointcutExpressions.forDaoPackageNoGetterNoSetter()")
    public void beforeAdvice(JoinPoint joinPoint) {
        System.out.println("====> Executing @Before advice on method");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: " + signature);

        Object[] arguments = joinPoint.getArgs();
        for (Object arg : arguments) {
            System.out.println(arg);
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("Account name: " + account.getName());
                System.out.println("Account level: " + account.getLevel());
            }
        }
    }

    @AfterReturning(pointcut = "execution(* com.polinayantsen.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result")
    public void afterReturningAdvice(JoinPoint joinPoint, List<Account> result) {
        System.out.println("====> Executing @AfterReturning advice on method: " +
                joinPoint.getSignature().toShortString());
        System.out.println("====> Result: " + result);

        Account account = result.get(0);
        account.setName("changedName");
    }

    @AfterThrowing(pointcut = "execution(* com.polinayantsen.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exception")
    public void afterThrowingAdvice(JoinPoint joinPoint, Throwable exception) {
        System.out.println("====> Executing @AfterThrowing advice on method: " +
                joinPoint.getSignature().toShortString());
        System.out.println("====> Exception: " + exception.getMessage());
    }

    @After("execution(* com.polinayantsen.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        System.out.println("====> Executing @After advice on method: " +
                joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.polinayantsen.aopdemo.service.*.getFortune(..))")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("====> Executing @Around advice on method: " +
                proceedingJoinPoint.getSignature().toShortString());
        long begin = System.currentTimeMillis();
        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Exception e) {
            logger.warning("Exception is caught: " + e.getMessage());
            result = "Default fortune";
            // throw e
        }
        long end = System.currentTimeMillis();
        logger.info("====> Duration: " + (end - begin)/1000 + " seconds");
        return result;
    }
}
