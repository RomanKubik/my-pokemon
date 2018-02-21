package com.kubik.roman.mypokemon.data.remote;

import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntity;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntityMapper;
import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonPojo;
import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonPojoMapper;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonPojoMapperTest {

    public PokemonPojoMapper pokemonPojoMapper;

    @Before
    public void setup() {
        pokemonPojoMapper = new PokemonPojoMapper();
    }

    @Test
    public void fromPojoTest() throws Exception {
        PokemonPojo pokemonPojo = new PokemonPojo("name", "url");
        Pokemon pokemon = pokemonPojoMapper.fromEntity(pokemonPojo);
        Assert.assertEquals(pokemonPojo.getName(), pokemon.getName());
        Assert.assertEquals(pokemonPojo.getUrl(), pokemon.getUrl());
    }

    @Test
    public void toPojoTest() throws Exception {
        Pokemon pokemon = new Pokemon("id", "name", "url");
        PokemonPojo pokemonPojo = pokemonPojoMapper.toEntity(pokemon);
        Assert.assertEquals(pokemon.getName(), pokemonPojo.getName());
        Assert.assertEquals(pokemon.getUrl(), pokemonPojo.getUrl());
    }
}
