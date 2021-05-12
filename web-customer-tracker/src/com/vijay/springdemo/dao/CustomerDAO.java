package com.vijay.springdemo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.vijay.springdemo.entity.Customer;

//@Repository
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);


	public Customer getCustomer(int theId);


	public void showFormForDeleteCustomer(int theId);
	
}
