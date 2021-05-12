package com.vijay.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vijay.springdemo.dao.CustomerDAO;
import com.vijay.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	//Need to inject Customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}
	
	
	
	@Transactional
	public void saveCustomer(Customer theCustomer)
	{
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {
		
		return customerDAO.getCustomer(theId);
	}



	@Override
	@Transactional
	public void showFormForDeleteCustomer(int theId) {
		customerDAO.showFormForDeleteCustomer(theId);
		// TODO Auto-generated method stub
		
	}
}