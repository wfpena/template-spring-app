package com.shopapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shopapp.model.Order;

@RestController()
@RequestMapping("/orders")
public class OrderController extends BaseController<Order> {
}
