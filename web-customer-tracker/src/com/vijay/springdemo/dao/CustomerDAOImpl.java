package com.vijay.springdemo.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vijay.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	//@Transactional
	public List<Customer> getCustomers() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
	//	Query<Customer> theQuery = 
				// (Query<Customer>) currentSession.createQuery("from Customer");
		
		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();
				
		// return the results		
		return customers;
	}

	
	//Code to save the customer record in the databse using hibernate
	
	@Override
	public void saveCustomer(Customer theCustomer) {
       //Get the current hibernate session object
		
		Session currentSession=sessionFactory.getCurrentSession();
		
		//Save the customer
		
		currentSession.saveOrUpdate(theCustomer);
		
		//First it was like   currentSession.save(theCustomer);  which is used to insert the record into databse 
		// Since hibernate has 2 methosd to insert record into database
		//1)save():  To insert a new record into database
		//2)saveOrUpdate(): To insert a new record if it is not in a database  And if it is in a databse then used for updating the existing record
		
	}


	@Transactional
	public Customer getCustomer(int theId) {
		//get the hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//Now retrive read from database using primary key
		Customer theCustomer=currentSession.get(Customer.class, theId);
		return theCustomer;
	}


	
	@Transactional
	public void showFormForDeleteCustomer(int theId) {
		// TODO Auto-generated method stub
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//Delete the object by primary key
		Query theQuery=currentSession.createQuery("delete from Customer where id=:cusid");
		theQuery.setParameter("cusid", theId);
		
		theQuery.executeUpdate();
		
	}

}






