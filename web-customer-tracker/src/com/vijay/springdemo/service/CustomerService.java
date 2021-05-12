package com.vijay.springdemo.service;

import java.util.List;

import com.vijay.springdemo.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getCustomers();
	public void saveCustomer(Customer theCustomer);
	public Customer getCustomer(int theId);
	public void showFormForDeleteCustomer(int theId);

}
