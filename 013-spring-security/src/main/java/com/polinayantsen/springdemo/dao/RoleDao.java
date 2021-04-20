package com.polinayantsen.springdemo.dao;

import com.polinayantsen.springdemo.entity.Role;

public interface RoleDao {
	Role findRoleByName(String theRoleName);
}
