package com.shopapp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @JsonIgnoreProperties("orders")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return customer;
    }
        
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }    

}
