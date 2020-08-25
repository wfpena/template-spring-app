package com.brasilprev.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.brasilprev.model.Customer;

@RestController()
@RequestMapping("/customers")
public class CustomerController extends BaseController<Customer> {
}