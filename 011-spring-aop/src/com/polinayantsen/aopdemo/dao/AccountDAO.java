package com.polinayantsen.aopdemo.dao;

import com.polinayantsen.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public String getName() {
        System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

    public void addAccount() {
        System.out.println(getClass() + ": ADDING AN ACCOUNT");
    }

    public void addAccount(Account account) {
        System.out.println(getClass() + ": ADDING AN ACCOUNT (WITH PARAMETER)");
    }

    public void addAccount(Account account, boolean vip) {
        System.out.println(getClass() + ": ADDING AN ACCOUNT (WITH TWO PARAMETERS)");
    }

    public List<Account> findAccounts(boolean throwException) {
        if (throwException) {
            throw new RuntimeException("Error in searching for accounts!");
        }
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("name01", "level01"));
        accounts.add(new Account("name02", "level02"));
        accounts.add(new Account("name03", "level03"));
        return accounts;
    }
}
