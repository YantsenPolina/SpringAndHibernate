package com.polinayantsen.springbootcrud.dao;

import com.polinayantsen.springbootcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
