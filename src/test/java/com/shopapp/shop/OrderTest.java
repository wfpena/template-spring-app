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

import com.shopapp.controller.OrderController;
import com.shopapp.model.Order;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderTest {
    @LocalServerPort
    private int port;

    @Autowired
    private OrderController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contexLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void insertsOrder() throws Exception {
        final String baseUrl = "http://localhost:" + port + "/orders";
        URI uri = new URI(baseUrl);
        Order order = new Order();
        order.setDescription("Order Description 1");

        ResponseEntity<Order> result = this.restTemplate
            .withBasicAuth("user", "pass")
            .postForEntity(uri, order, Order.class);

        assertThat(result.getBody().getDescription()).isEqualTo(order.getDescription());
    }

}
