package com.superhero.service.impl;

import com.superhero.domain.Ally;
import com.superhero.domain.Skill;
import com.superhero.domain.SuperHero;
import com.superhero.exception.ValidationException;
import com.superhero.repository.SuperHeroRepository;
import com.superhero.service.SuperHeroService;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.mock;

public class SuperHeroServiceUnitTest {

    private SuperHeroService superHeroService;
    private SuperHeroRepository superHeroRepository;
    private SuperHero superHero;

    @Before
    public void setUp() {
        superHero = createSuperHeroWithAllFields();

        superHeroRepository = mock(SuperHeroRepository.class);

        superHeroService = new SuperHeroServiceImpl(superHeroRepository);
    }

    @Test
    public void save_superhero_with_success(){
        superHeroService.save(superHero);
    }

    @Test(expected = ValidationException.class)
    public void save_superhero_without_name(){
        superHero.setName("");

        superHeroService.save(superHero);
    }

    @Test(expected = ValidationException.class)
    public void save_superhero_without_pseudonym(){
        superHero.setPseudonym("");

        superHeroService.save(superHero);
    }

    @Test(expected = ValidationException.class)
    public void save_superhero_without_publisher(){
        superHero.setPublisher("");

        superHeroService.save(superHero);
    }

    private SuperHero createSuperHeroWithAllFields() {
        SuperHero superHero = new SuperHero();
        superHero.setName("Bruce Wayne");
        superHero.setPseudonym("Batman");
        superHero.setPublisher("DC");

        List<Skill> skills = new ArrayList<>();
        skills.add(new Skill("power"));
        skills.add(new Skill("speed"));

        superHero.setSkills(skills);

        List<Ally> allies = new ArrayList<>();
        allies.add(new Ally("Robin"));
        allies.add(new Ally("Bat Girl"));

        superHero.setAllies(allies);

        superHero.setDateFirstAppearance(new Date());

        return superHero;
    }
}
