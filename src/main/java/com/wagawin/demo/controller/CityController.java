package com.wagawin.demo.controller;

import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wagawin.demo.exception.ResourceNotFoundExcption;
import com.wagawin.demo.model.City;
import com.wagawin.demo.repository.CityRepository;


@RestController
public class CityController {
	
	private final static Logger LOGGER = Logger.getLogger(CityController.class.getName());

	private static final int PAGE_SIZE = 5;

	@Autowired
	CityRepository repository;
	
	 

	@GetMapping(path = "/city/all")
	public Iterable<City> getAll(@RequestParam("pageNumber") int pageNumber) {
		PageRequest request = PageRequest.of(pageNumber, PAGE_SIZE, Sort.Direction.DESC, "name");
		return repository.findAll(request);
	}
	
	@GetMapping(path = "/city/{id}/")
	public City getCityById(@PathVariable("id") Long id) {		
		Optional<City> person = repository.findById(id);
		if(person.isPresent()) return person.get();
		else {
			throw new ResourceNotFoundExcption("City with id: " + id + " not found");
		} 
	}	 

}
