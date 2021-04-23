package com.polinayantsen.springdemo.dao;

import java.util.List;

import com.polinayantsen.springdemo.entity.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void deleteCustomer(int customerId);
}
