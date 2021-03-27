package com.polinayantsen.aopdemo;

import com.polinayantsen.aopdemo.dao.AccountDAO;
import com.polinayantsen.aopdemo.dao.MembershipDAO;
import com.polinayantsen.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.logging.Logger;

public class MainApp {

    private static Logger logger = Logger.getLogger(MainApp.class.getName());

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        accountDAO.addAccount();
        System.out.println();

        Account account = new Account("AccountName", "AccountLevel");
        accountDAO.addAccount(account);
        System.out.println();

        accountDAO.addAccount(account, false);
        System.out.println();

        accountDAO.setName("AccountName");
        System.out.println();

        accountDAO.setServiceCode("ServiceCode");
        System.out.println();

        accountDAO.getName();
        System.out.println();

        accountDAO.getServiceCode();
        System.out.println();

        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        membershipDAO.addAccount();
        System.out.println();

        List<Account> accounts = accountDAO.findAccounts(false);
        System.out.println("Accounts: " + accounts);

        try {
            accountDAO.findAccounts(true);
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }

        TrafficFortuneService trafficFortuneService =
                context.getBean("trafficFortuneService", TrafficFortuneService.class);
        logger.info("Calling TrafficFortuneService");
        String fortune = trafficFortuneService.getFortune(false);
        logger.info("Fortune: " + fortune);

        fortune = trafficFortuneService.getFortune(true);
        logger.info("Fortune: " + fortune);

        context.close();
    }
}
