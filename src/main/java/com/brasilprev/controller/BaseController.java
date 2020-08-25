package com.brasilprev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

@RequestMapping()
public class BaseController <T> {

	@Autowired
	private CrudRepository<T, Long> repo;
	
    @RequestMapping
    public @ResponseBody List<T> listAll() {
        return (List<T>) this.repo.findAll();
    }

	@PostMapping()
	T create(@RequestBody T newEntity) {
		return this.repo.save(newEntity);
	}
}
