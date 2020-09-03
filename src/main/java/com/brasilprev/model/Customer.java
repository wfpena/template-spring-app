package com.brasilprev.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    
    @NotNull
    private String individualTaxpayerRegistry;

    @OneToMany(mappedBy = "customer")
    @JsonIgnoreProperties("customer")
    private Set<Order> orders;

	public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }
    
    public String getIndividualTaxpayerRegistry() {
		return individualTaxpayerRegistry;
	}

	public void setIndividualTaxpayerRegistry(String individualTaxpayerRegistry) {
		this.individualTaxpayerRegistry = individualTaxpayerRegistry;
    }
    
    public Set<Order> getOrders() {
        return orders;
    }
        
    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

}
