package com.vijay.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vijay.springdemo.entity.Customer;
import com.vijay.springdemo.service.CustomerService;

@Controller
public class CustomerController {
	// Need to inject the customer DAO        SO HERE INSTED OF DIRECTLY COMMUNICATING WITH CUSTOMEDAO ,WILL COMMUNICATE WITH CUSTOMERSERVICE
	
	//@Autowired
	//private CustomerDAO customerDAO;
	@Autowired
	private CustomerService customerService;
	

	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customer from the dao
		//Now get customr from service
		List<Customer> theCustomers=customerService.getCustomers();
		
		//Add those customer to Spring mvc Model
		theModel.addAttribute("customers",theCustomers);
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		
		//Create a model attribute to bind a form data
		
		Customer theCustomer=new Customer();
		
		//Here 'customer' is a Attribute name and 'theCustomer' is the Attribute value.
		theModel.addAttribute("customer",theCustomer);
		return"customer-form";
	}
	
	
	
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		
		// Save the message using our service
		customerService.saveCustomer(theCustomer);
		
		return"redirect:/list";
	}
	
	
	
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("cusid") int theId, Model theModel)
	{
		//get the customer from the database
		Customer theCustomer=customerService.getCustomer(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("customer", theCustomer);
		//send over to our form
		return "customer-form";
		
	}
	
	
	@GetMapping("/showFormForDelete")
		public String showFormForDelete(@RequestParam("cusid") int theId)
		{
			
		
		//delete the customer
		// Here showForDeleteCustomeris a method defined in the CustomerService Interface
		customerService.showFormForDeleteCustomer(theId);
		return "redirect:/list";
		}
	}
	 
	
	


