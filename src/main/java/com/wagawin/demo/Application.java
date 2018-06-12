package com.wagawin.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.wagawin.demo.model.City;
import com.wagawin.demo.repository.CityRepository;

import io.bloco.faker.Faker;

@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);	

	@Value("${spring.application.name}")
	private String springApplicationName;	
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	@Bean
	public CommandLineRunner demo(CityRepository repository) {
		return (args) -> {
			System.out.println("springApplicationName:"+springApplicationName);
			repository.findAll().forEach(item -> {
				System.out.println(item.toString());
			});
		};
	}		
	 

	/* 
	@Bean
	public CommandLineRunner demo2(CityRepository repository) {
		return (args) -> {
			Faker faker = new Faker();			
			for (int i = 0; i < 10; i++) {				
				City city = new City();
				city.setName(faker.address.city());
				city.setPopulation(faker.number.between(50000, 200000));
				repository.save(city);
			}
			
		};
	}
	*/
	
	

}