package com.superhero.repository;

import com.superhero.domain.SuperHero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SuperHeroRepository extends MongoRepository<SuperHero, String> {

}
