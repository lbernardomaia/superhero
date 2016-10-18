package com.superhero.converter.impl;

import com.superhero.converter.SuperHeroConverter;
import com.superhero.domain.Ally;
import com.superhero.domain.Skill;
import com.superhero.domain.SuperHero;
import com.superhero.dto.AllyDTO;
import com.superhero.dto.SkillDTO;
import com.superhero.dto.SuperHeroDTO;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SuperHeroConverterImpl implements SuperHeroConverter {

    @Override
    public SuperHero convertToSuperHero(SuperHeroDTO superHeroDTO) {
        SuperHero superHero = new SuperHero();
        superHero.setId(superHeroDTO.getId());
        superHero.setName(superHeroDTO.getName());
        superHero.setPseudonym(superHeroDTO.getPseudonym());
        superHero.setPublisher(superHeroDTO.getPublisher());

        if (superHeroDTO.getSkillsDTO()!= null && !superHeroDTO.getSkillsDTO().isEmpty()){
            List<Skill> skills = superHeroDTO.getSkillsDTO().stream().map(skillDTO -> new Skill(skillDTO.getName())).collect(Collectors.toList());

            superHero.setSkills(skills);
        }

        if (superHeroDTO.getAlliesDTO()!= null && !superHeroDTO.getAlliesDTO().isEmpty()){
            List<Ally> allies = superHeroDTO.getAlliesDTO().stream().map(allyDTO -> new Ally(allyDTO.getName())).collect(Collectors.toList());

            superHero.setAllies(allies);
        }

        if (!StringUtils.isEmpty(superHeroDTO.getDateFirstAppearance())) {
            String dateSplit[] = superHeroDTO.getDateFirstAppearance().split("-");
            int year = Integer.parseInt(dateSplit[0]);
            int month = Integer.parseInt(dateSplit[1]);
            int day = Integer.parseInt(dateSplit[2]);

            DateTime dateFirstAppearance = new DateTime(year, month, day, 0, 0, 0, 0);

            superHero.setDateFirstAppearance(dateFirstAppearance.toDate());
        }

        return superHero;
    }

    @Override
    public SuperHeroDTO convertToSuperHeroDTO(SuperHero superHero) {
        SuperHeroDTO superHeroDTO = new SuperHeroDTO();
        superHeroDTO.setId(superHero.getId());
        superHeroDTO.setName(superHero.getName());
        superHeroDTO.setPseudonym(superHero.getPseudonym());
        superHeroDTO.setPublisher(superHero.getPublisher());

        if (superHero.getSkills()!= null && !superHero.getSkills().isEmpty()){
            List<SkillDTO> skillsDTO = superHero.getSkills().stream().map(skill -> new SkillDTO(skill.getName())).collect(Collectors.toList());

            superHeroDTO.setSkillsDTO(skillsDTO);
        }

        if (superHero.getAllies()!= null && !superHero.getAllies().isEmpty()){
            List<AllyDTO> alliesDTO = superHero.getAllies().stream().map(ally -> new AllyDTO(ally.getName())).collect(Collectors.toList());

            superHeroDTO.setAlliesDTO(alliesDTO);
        }

        if (superHero.getDateFirstAppearance() != null) {
            DateTime dateFirstAppearance = new DateTime(superHero.getDateFirstAppearance());

            String month = dateFirstAppearance.getMonthOfYear() <= 9 ? "0" + dateFirstAppearance.getMonthOfYear() : String.valueOf(dateFirstAppearance.getMonthOfYear());
            String day = dateFirstAppearance.getDayOfMonth() <= 9 ? "0" + dateFirstAppearance.getDayOfMonth() : String.valueOf(dateFirstAppearance.getDayOfMonth());

            String date = dateFirstAppearance.getYear() + "-" + month + "-" + day;

            superHeroDTO.setDateFirstAppearance(date);
        }

        return superHeroDTO;
    }

    @Override
    public List<SuperHeroDTO> convertToSuperHeroDTO(List<SuperHero> superHeroList) {
        List<SuperHeroDTO> superHeroesDTO = superHeroList.stream().map(this::convertToSuperHeroDTO).collect(Collectors.toList());

        return superHeroesDTO;
    }
}
