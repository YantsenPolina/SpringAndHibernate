package com.polinayantsen.springdemo.dao;

import com.polinayantsen.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> getCustomers(int sortField);
    void saveCustomer(Customer customer);
    Customer getCustomer(int id);
    void deleteCustomer(int id);
    List<Customer> searchCustomers(String searchName);
}
