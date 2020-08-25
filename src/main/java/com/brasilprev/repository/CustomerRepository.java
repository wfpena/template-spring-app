package com.brasilprev.repository;

import com.brasilprev.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
