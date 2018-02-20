package com.kubik.roman.mypokemon.data.pokemon.local;

import com.kubik.roman.mypokemon.domain.EntityModelMapper;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonEntityMapper implements EntityModelMapper<PokemonEntity, Pokemon> {
    @Override
    public Pokemon fromEntity(PokemonEntity from) {
        return new Pokemon(from.getId(), from.getName(), from.getUrl());
    }

    @Override
    public PokemonEntity toEntity(Pokemon from) {
        return new PokemonEntity(from.getId(), from.getName(), from.getUrl());
    }
}
