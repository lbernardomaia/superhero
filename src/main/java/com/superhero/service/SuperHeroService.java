package com.superhero.service;

import com.superhero.domain.SuperHero;

import java.util.List;

public interface SuperHeroService {
    SuperHero save(SuperHero superHero);
    List<SuperHero> findAll();
    SuperHero findOne(String id);
}
