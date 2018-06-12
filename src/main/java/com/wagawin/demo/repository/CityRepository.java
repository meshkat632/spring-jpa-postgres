package com.wagawin.demo.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.wagawin.demo.model.City;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {

	List<City> findByName(String name);

}