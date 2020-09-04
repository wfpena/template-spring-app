package com.shopapp.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.shopapp.model.Product;

@RestController()
@RequestMapping("/products")
public class ProductController extends BaseController<Product> {
}
