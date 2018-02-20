package com.kubik.roman.mypokemon.data.local;

import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntity;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntityMapper;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonEntityMapperTest {

    public PokemonEntityMapper pokemonEntityMapper;

    @Before
    public void setup() {
        pokemonEntityMapper = new PokemonEntityMapper();
    }

    @Test
    public void fromEntityTest() throws Exception {
        PokemonEntity pokemonEntity = new PokemonEntity("id", "name", "url");
        Pokemon pokemon = pokemonEntityMapper.fromEntity(pokemonEntity);
        Assert.assertEquals(pokemonEntity.getId(), pokemon.getId());
        Assert.assertEquals(pokemonEntity.getName(), pokemon.getName());
        Assert.assertEquals(pokemonEntity.getUrl(), pokemon.getUrl());
    }

    @Test
    public void toEntityTest() throws Exception {
        Pokemon pokemon = new Pokemon("id", "name", "url");
        PokemonEntity pokemonEntity = pokemonEntityMapper.toEntity(pokemon);
        Assert.assertEquals(pokemon.getId(), pokemonEntity.getId());
        Assert.assertEquals(pokemon.getName(), pokemonEntity.getName());
        Assert.assertEquals(pokemon.getUrl(), pokemonEntity.getUrl());
    }
}
