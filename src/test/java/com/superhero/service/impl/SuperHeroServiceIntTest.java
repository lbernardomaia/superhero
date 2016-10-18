package com.superhero.service.impl;

import com.superhero.domain.Ally;
import com.superhero.domain.Skill;
import com.superhero.domain.SuperHero;
import com.superhero.repository.SuperHeroRepository;
import com.superhero.service.SuperHeroService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SuperHeroServiceIntTest {

    @Autowired
    private SuperHeroService superHeroService;

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Before
    public void setUp() {
        superHeroRepository.deleteAll();
    }

    @Test
    public void save_superhero_with_success(){
        SuperHero superHero = createSuperHeroWithAllFields();
        superHeroService.save(superHero);
    }

    @Test
    public void find_all_superheroes(){
        SuperHero superHero1 = createSuperHeroWithAllFields();
        superHero1.setName("Bruce Wayne_1");
        superHeroService.save(superHero1);

        SuperHero superHero2 = createSuperHeroWithAllFields();
        superHero2.setName("Bruce Wayne_2");
        superHeroService.save(superHero2);

        List<SuperHero> superHeroes = superHeroService.findAll();
        assert superHeroes.size() == 2;
    }

    @Test
    public void find_one_superheroes(){
        SuperHero superHeroExpected = createSuperHeroWithAllFields();
        superHeroService.save(superHeroExpected);

        SuperHero superHero2 = createSuperHeroWithAllFields();
        superHero2.setName("Bruce Wayne_2");
        superHeroService.save(superHero2);

        SuperHero superHeroRecover = superHeroService.findOne(superHeroExpected.getId());

        assert superHeroRecover.getId().equals(superHeroExpected.getId());
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
