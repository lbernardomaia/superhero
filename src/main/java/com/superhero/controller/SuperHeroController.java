package com.superhero.controller;

import com.superhero.converter.SuperHeroConverter;
import com.superhero.domain.SuperHero;
import com.superhero.dto.SuperHeroDTO;
import com.superhero.service.SuperHeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class SuperHeroController {

    private static final Logger LOGGER = Logger.getLogger(SuperHeroController.class.getName());

    @Autowired
    private SuperHeroService superHeroService;

    @Autowired
    private SuperHeroConverter superHeroConverter;

    @RequestMapping(method = RequestMethod.GET, value = {"/superhero"})
    public List<SuperHeroDTO> findAllSuperHeroes() throws Exception {
        List<SuperHeroDTO> superHeroDTOs;
        try{
            List<SuperHero> superHeroList = superHeroService.findAll();

            superHeroDTOs = superHeroConverter.convertToSuperHeroDTO(superHeroList);
        }catch (Exception e){
            LOGGER.severe(e.getMessage());
            throw e;
        }

        return superHeroDTOs;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/superhero/{id}"})
    public SuperHeroDTO findSuperHeroesByID(@PathVariable String id) throws Exception {
        SuperHeroDTO superHeroDTO;
        try{
            SuperHero superHero = superHeroService.findOne(id);
            superHeroDTO = superHeroConverter.convertToSuperHeroDTO(superHero);
        }catch (Exception e){
            LOGGER.severe(e.getMessage());
            throw e;
        }
        return superHeroDTO;
    }

    @RequestMapping(method = RequestMethod.POST, value = {"/superhero"})
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody SuperHeroDTO superHeroDTO) throws Exception {
        try{
            SuperHero superHeroConverted = superHeroConverter.convertToSuperHero(superHeroDTO);
            superHeroService.save(superHeroConverted);
        }catch (Exception e){
            LOGGER.severe(e.getMessage());
            throw e;
        }
    }
}
