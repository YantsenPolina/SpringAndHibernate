package com.polinayantsen.springdemo.service;

import com.polinayantsen.springdemo.entity.User;
import com.polinayantsen.springdemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(CrmUser crmUser);
}
