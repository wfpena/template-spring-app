package com.brasilprev.service;

import com.brasilprev.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerService extends CrudRepository<Customer, Long> {
}
