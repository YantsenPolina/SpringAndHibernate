package com.polinayantsen.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public boolean addAccount() {
        System.out.println(getClass() + ": ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
