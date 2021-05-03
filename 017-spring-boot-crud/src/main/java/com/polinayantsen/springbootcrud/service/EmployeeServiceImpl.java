package com.polinayantsen.springbootcrud.service;

import com.polinayantsen.springbootcrud.dao.EmployeeDAO;
import com.polinayantsen.springbootcrud.dao.EmployeeRepository;
import com.polinayantsen.springbootcrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    /* Hibernate or JPA implementation */
//    @Qualifier("employeeDAOJPAImpl")
//    @Autowired
//    private EmployeeDAO employeeDAO;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    //@Transactional
    public List<Employee> findAll() {
        //return employeeDAO.findAll();
        return employeeRepository.findAll();
    }

    @Override
    //@Transactional
    public Employee findById(int id) {
        //return employeeDAO.findById(id);
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Employee with id not found - " + id);
        }
    }

    @Override
    //@Transactional
    public void save(Employee employee) {
        //employeeDAO.save(employee);
        employeeRepository.save(employee);
    }

    @Override
    //@Transactional
    public void deleteById(int id) {
        //employeeDAO.deleteById(id);
        employeeRepository.deleteById(id);
    }
}
