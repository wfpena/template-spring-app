package com.brasilprev.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "CUSTOMER")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
    
    @NotNull
    private String individualTaxpayerRegistry;

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

}
