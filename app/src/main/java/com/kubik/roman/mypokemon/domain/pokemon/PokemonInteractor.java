package com.kubik.roman.mypokemon.domain.pokemon;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by kubik on 2/18/18.
 */

public class PokemonInteractor {

    private PokemonRepository pokemonRepository;

    public PokemonInteractor(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Single<List<Pokemon>> getAll() {
        return pokemonRepository.getAll();
    }
}
