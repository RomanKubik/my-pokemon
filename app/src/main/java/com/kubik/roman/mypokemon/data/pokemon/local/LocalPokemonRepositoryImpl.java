package com.kubik.roman.mypokemon.data.pokemon.local;

import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonPojo;
import com.kubik.roman.mypokemon.domain.pokemon.LocalPokemonRepository;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by kubik on 2/20/18.
 */

public class LocalPokemonRepositoryImpl implements LocalPokemonRepository {

    private PokemonDao pokemonDao;
    private PokemonEntityMapper pokemonEntityMapper;

    public LocalPokemonRepositoryImpl(PokemonDao pokemonDao, PokemonEntityMapper pokemonEntityMapper) {
        this.pokemonDao = pokemonDao;
        this.pokemonEntityMapper = pokemonEntityMapper;
    }

    @Override
    public Single<List<Pokemon>> getAll() {
        return pokemonDao.getAll()
                .map(this::mapPokemonEntities);
    }

    @Override
    public Completable insertAll(List<Pokemon> pokemonList) {
        return Completable.fromAction(() -> pokemonDao.insertAll(mapPokemons(pokemonList)));
    }

    @Override
    public Completable deleteAll() {
        return Completable.fromAction(() -> pokemonDao.deleteAll());
    }

    private List<Pokemon> mapPokemonEntities(List<PokemonEntity> pokemonEntities) {
        List<Pokemon> pokemons = new ArrayList<>();
        for (PokemonEntity entity : pokemonEntities) {
            pokemons.add(pokemonEntityMapper.fromEntity(entity));
        }
        return pokemons;
    }

    private List<PokemonEntity> mapPokemons(List<Pokemon> pokemons) {
        List<PokemonEntity> entities = new ArrayList<>();
        for (Pokemon pokemon : pokemons) {
            entities.add(pokemonEntityMapper.toEntity(pokemon));
        }
        return entities;
    }
}
