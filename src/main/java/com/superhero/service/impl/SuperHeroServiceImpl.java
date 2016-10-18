package com.superhero.service.impl;

import com.superhero.domain.SuperHero;
import com.superhero.exception.ValidationException;
import com.superhero.repository.SuperHeroRepository;
import com.superhero.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SuperHeroServiceImpl implements SuperHeroService {

    private SuperHeroRepository repository;

    @Autowired
    public SuperHeroServiceImpl(SuperHeroRepository repository){
        this.repository = repository;
    }

    @Override
    public SuperHero save(SuperHero superHero) {
        validateFields(superHero);
        return repository.save(superHero);
    }

    private void validateFields(SuperHero superHero) {
        validateName(superHero.getName());
        validatePseudonym(superHero.getPseudonym());
        validatePublisher(superHero.getPublisher());
    }

    private void validatePublisher(String publisher) {
        if (StringUtils.isEmpty(publisher)){
            throw new ValidationException();
        }
    }

    private void validatePseudonym(String pseudonym) {
        if (StringUtils.isEmpty(pseudonym)){
            throw new ValidationException();
        }
    }

    private void validateName(String name) {
        if (StringUtils.isEmpty(name)){
            throw new ValidationException();
        }
    }

    @Override
    public List<SuperHero> findAll() {
        return repository.findAll();
    }

    @Override
    public SuperHero findOne(String id) {
        return repository.findOne(id);
    }
}
