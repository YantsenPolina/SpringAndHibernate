package com.polinayantsen.springbootcrud.service;

import com.polinayantsen.springbootcrud.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void deleteById(int id);
}
