package com.polinayantsen.springbootcrud.dao;

import com.polinayantsen.springbootcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
