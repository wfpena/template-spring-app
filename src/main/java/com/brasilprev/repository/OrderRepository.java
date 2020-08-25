package com.brasilprev.repository;

import com.brasilprev.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
