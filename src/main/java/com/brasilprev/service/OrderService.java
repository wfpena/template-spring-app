package com.brasilprev.service;

import com.brasilprev.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderService extends CrudRepository<Order, Long> {
}
