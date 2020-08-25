package com.brasilprev.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RequestMapping()
public class BaseController <T> {

	@Autowired
	private CrudRepository<T, Long> repo;
	
    @RequestMapping
    @ResponseBody List<T> listAll() {
        return (List<T>) this.repo.findAll();
    }
    
    @SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	T getById(@PathVariable Long id){
	    return (T) this.repo.findById(id);
	}

	@PostMapping()
	@ResponseBody ResponseEntity<Object> create(@Valid @RequestBody T newEntity, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity
					.status(HttpStatus.BAD_REQUEST)
					.body(errors.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(this.repo.save(newEntity));
	}
	 
	@DeleteMapping("/{id}")
	Long delete(@PathVariable Long id){
	    this.repo.deleteById(id);
	    return id;
	}
}
