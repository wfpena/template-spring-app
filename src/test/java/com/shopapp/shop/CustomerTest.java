package com.shopapp.shop;

import static org.assertj.core.api.Assertions.assertThat;


import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.shopapp.controller.CustomerController;
import com.shopapp.model.Customer;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerTest {

	@LocalServerPort
	private int port;
	
	@Autowired
	private CustomerController controller;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void contexLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
	
	@Test
	public void insertsCustomer() throws Exception {
		final String baseUrl = "http://localhost:" + port + "/customers";
		URI uri = new URI(baseUrl);
		Customer customer = new Customer();
		customer.setName("Jorge Leal");
		customer.setIndividualTaxpayerRegistry("09987602102");
		
		ResponseEntity<Customer> result = this.restTemplate.postForEntity(uri, customer, Customer.class);
		
		assertThat(result.getBody().getName()).isEqualTo(customer.getName());
	}
}
