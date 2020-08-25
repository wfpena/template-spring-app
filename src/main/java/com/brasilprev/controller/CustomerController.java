package com.brasilprev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.brasilprev.model.Customer;
import com.brasilprev.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

	@RequestMapping("/customers")
	public String index() {
		Customer newCustomer = new Customer();
		newCustomer.setName("Jorge");
		customerService.save(newCustomer);
		return "Number of customers " + customerService.count();
	}

}