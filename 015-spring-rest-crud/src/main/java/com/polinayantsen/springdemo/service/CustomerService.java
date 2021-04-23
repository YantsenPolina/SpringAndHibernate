package com.polinayantsen.springdemo.service;

import java.util.List;

import com.polinayantsen.springdemo.entity.Customer;

public interface CustomerService {

	List<Customer> getCustomers();
	void saveCustomer(Customer customer);
	Customer getCustomer(int customerId);
	void deleteCustomer(int customerId);
}
