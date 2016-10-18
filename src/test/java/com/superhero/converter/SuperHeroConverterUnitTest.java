package com.superhero.converter;

import com.superhero.converter.impl.SuperHeroConverterImpl;
import com.superhero.domain.Ally;
import com.superhero.domain.Skill;
import com.superhero.domain.SuperHero;
import com.superhero.dto.AllyDTO;
import com.superhero.dto.SkillDTO;
import com.superhero.dto.SuperHeroDTO;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperHeroConverterUnitTest {

    private SuperHeroConverterImpl superHeroConverterImpl;

    @Before
    public void setUp() {
        superHeroConverterImpl = new SuperHeroConverterImpl();
    }

    @Test
    public void convert_superHeroDTO_to_superHero(){
        SuperHeroDTO superHeroDTO = createSuperHeroDTO();

        SuperHero superHeroExpected = createSuperHero();

        SuperHero superHeroConverted = superHeroConverterImpl.convertToSuperHero(superHeroDTO);

        assert superHeroExpected.getId().equals(superHeroConverted.getId());
        assert superHeroExpected.getSkills().size() == superHeroConverted.getSkills().size();
        assert superHeroExpected.getAllies().size() == superHeroConverted.getAllies().size();
        assert superHeroExpected.getDateFirstAppearance().equals(superHeroConverted.getDateFirstAppearance());
    }

    @Test
    public void convert_superHero_to_superHeroDTO(){
        SuperHero superHero = createSuperHero();

        SuperHeroDTO superHeroDTOExpected = createSuperHeroDTO();

        SuperHeroDTO superHeroDTOConverted = superHeroConverterImpl.convertToSuperHeroDTO(superHero);

        assert superHeroDTOExpected.getId().equals(superHeroDTOConverted.getId());
        assert superHeroDTOExpected.getSkillsDTO().size() == superHeroDTOConverted.getSkillsDTO().size();
        assert superHeroDTOExpected.getAlliesDTO().size() == superHeroDTOConverted.getAlliesDTO().size();
        assert superHeroDTOExpected.getDateFirstAppearance().equals(superHeroDTOConverted.getDateFirstAppearance());
    }

    private SuperHeroDTO createSuperHeroDTO() {
        SuperHeroDTO superHeroDTO = new SuperHeroDTO();
        superHeroDTO.setId("5805401a61b93d11bc4e108d");
        superHeroDTO.setName("Bruce Wayne");
        superHeroDTO.setPseudonym("Batman");
        superHeroDTO.setPublisher("DC");

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

    private SuperHero createSuperHero() {
        SuperHero superHero = new SuperHero();
        superHero.setId("5805401a61b93d11bc4e108d");
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

        DateTime dateFirstAppearance = new DateTime(2015, 5, 10, 0, 0, 0, 0);

        superHero.setDateFirstAppearance(dateFirstAppearance.toDate());

        return superHero;
    }
}
