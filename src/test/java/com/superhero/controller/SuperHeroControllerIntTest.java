package com.superhero.controller;

import com.superhero.domain.Ally;
import com.superhero.domain.Skill;
import com.superhero.domain.SuperHero;
import com.superhero.dto.AllyDTO;
import com.superhero.dto.SkillDTO;
import com.superhero.dto.SuperHeroDTO;
import com.superhero.repository.SuperHeroRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SuperHeroControllerIntTest {

    @Autowired
    private SuperHeroRepository superHeroRepository;

    @Before
    public void setUp() {
        superHeroRepository.deleteAll();
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void find_all_superHeroes() {
        SuperHero superHero1 = superHeroRepository.save(createSuperHeroWithAllFields());
        SuperHero superHero2 = superHeroRepository.save(createSuperHeroWithAllFields());

        String body = this.restTemplate.getForObject("/superhero", String.class);
        assert body.contains(superHero1.getId()) && body.contains(superHero2.getId());
    }

    @Test
    public void find_superHeroes_by_id() {
        SuperHero superHero1 = superHeroRepository.save(createSuperHeroWithAllFields());

        String body = this.restTemplate.getForObject("/superhero/" + superHero1.getId(), String.class);
        assert body.contains(superHero1.getId());
    }

    @Test
    public void register_superhero() {
        SuperHeroDTO superHeroDTO = createSuperHeroDTO();

        this.restTemplate.postForEntity("/superhero", superHeroDTO, String.class);

        String body = this.restTemplate.getForObject("/superhero", String.class);
        assert body.contains(superHeroDTO.getName()) &&
               body.contains(superHeroDTO.getPseudonym()) &&
               body.contains(superHeroDTO.getPublisher());
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

    private SuperHeroDTO createSuperHeroDTO() {
        SuperHeroDTO superHeroDTO = new SuperHeroDTO();
        superHeroDTO.setName("Bruce Wayne Test Register");
        superHeroDTO.setPseudonym("Batman Test Register");
        superHeroDTO.setPublisher("DC Test Register");

        List<SkillDTO> skillsDTO = new ArrayList<>();
        skillsDTO.add(new SkillDTO("power"));
        skillsDTO.add(new SkillDTO("speed"));

        superHeroDTO.setSkillsDTO(skillsDTO);

        List<AllyDTO> alliesDTO = new ArrayList<>();
        alliesDTO.add(new AllyDTO("Robin"));
        alliesDTO.add(new AllyDTO("Bat Girl"));

        superHeroDTO.setAlliesDTO(alliesDTO);

        superHeroDTO.setDateFirstAppearance("2015-05-10");

        return superHeroDTO;
    }

}
