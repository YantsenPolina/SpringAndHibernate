package com.polinayantsen.springdemo.dao;

import com.polinayantsen.springdemo.entity.User;

public interface UserDao {
    User findByUserName(String userName);
    void save(User user);
}
