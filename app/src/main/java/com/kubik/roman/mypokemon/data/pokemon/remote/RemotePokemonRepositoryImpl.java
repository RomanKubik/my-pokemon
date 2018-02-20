package com.kubik.roman.mypokemon.data.pokemon.remote;

import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;
import com.kubik.roman.mypokemon.domain.pokemon.RemotePokemonRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by kubik on 2/20/18.
 */

public class RemotePokemonRepositoryImpl implements RemotePokemonRepository {

    private PokemonApi pokemonApi;
    private PokemonPojoMapper pokemonPojoMapper;

    public RemotePokemonRepositoryImpl(PokemonApi pokemonApi, PokemonPojoMapper pokemonPojoMapper) {
        this.pokemonApi = pokemonApi;
        this.pokemonPojoMapper = pokemonPojoMapper;
    }

    @Override
    public Single<List<Pokemon>> getAll() {
        return pokemonApi.getPokemons()
                .map(PokemonResponcePojo::getPokemons)
                .map(this::mapPokemonPojos);
    }

    private List<Pokemon> mapPokemonPojos(List<PokemonPojo> pokemonPojos) {
        List<Pokemon> pokemons = new ArrayList<>();
        for (PokemonPojo pokemonPojo : pokemonPojos) {
            pokemons.add(pokemonPojoMapper.fromEntity(pokemonPojo));
        }
        return pokemons;
    }
}
