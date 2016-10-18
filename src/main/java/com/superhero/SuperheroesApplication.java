package com.superhero;

import com.superhero.repository.SuperHeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SuperheroesApplication {

	@Autowired
	private SuperHeroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(SuperheroesApplication.class, args);
	}

}
