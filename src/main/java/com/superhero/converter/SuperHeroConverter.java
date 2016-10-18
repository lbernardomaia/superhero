package com.superhero.converter;

import com.superhero.domain.SuperHero;
import com.superhero.dto.SuperHeroDTO;

import java.util.List;

public interface SuperHeroConverter {
    SuperHero convertToSuperHero(SuperHeroDTO superHeroDTO);

    SuperHeroDTO convertToSuperHeroDTO(SuperHero superHero);

    List<SuperHeroDTO> convertToSuperHeroDTO(List<SuperHero> superHeroList);
}
