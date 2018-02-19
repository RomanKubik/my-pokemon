package com.kubik.roman.mypokemon.data.pokemon.remote;

import com.kubik.roman.mypokemon.domain.EntityModelMapper;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import java.util.UUID;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonPojoMapper implements EntityModelMapper<PokemonPojo, Pokemon> {
    @Override
    public Pokemon fromEntity(PokemonPojo from) {
        return new Pokemon(UUID.randomUUID().toString(), from.getName(), from.getUrl());
    }

    @Override
    public PokemonPojo toEntity(Pokemon from) {
        return new PokemonPojo(from.getName(), from.getUrl());
    }
}
