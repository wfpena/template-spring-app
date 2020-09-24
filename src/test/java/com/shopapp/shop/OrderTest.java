package com.shopapp.shop;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.shopapp.controller.OrderController;
import com.shopapp.model.Customer;
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
    
    @Test
    public void insertsOrderWithCustomer() throws Exception {
        final String baseUrl = "http://localhost:" + port;
        URI uri = new URI(baseUrl + "/customers");
        Customer customer = new Customer();
        customer.setName("Customer with Order");
        customer.setIndividualTaxpayerRegistry("09987602132");

        ResponseEntity<Customer> result = this.restTemplate
            .withBasicAuth("user", "pass")
            .postForEntity(uri, customer, Customer.class);

        assertThat(result.getBody().getName()).isEqualTo(customer.getName());

        JSONObject request = new JSONObject();
        request.put("description", "Order With Customer");
        request.put("customer", new JSONObject().put("id", result.getBody().getId()));

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request.toString(), headers);
        ResponseEntity<String> ordersResponse = restTemplate
            .withBasicAuth("user", "pass")
            .exchange(baseUrl + "/orders", HttpMethod.POST, entity, String.class);
        
        JSONObject createdOrder = new JSONObject(ordersResponse.getBody());
        assertThat(createdOrder.get("description")).isEqualTo("Order With Customer");
        
        // JSONObject referencedCustomer = (JSONObject) createdOrder.getJSONObject("customer");
        // System.out.println("HEREEEEEE");
        // System.out.println(referencedCustomer);
    }

}
