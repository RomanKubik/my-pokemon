package com.kubik.roman.mypokemon.domain.pokemon;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by kubik on 2/18/18.
 */

public interface LocalPokemonRepository {

    Single<List<Pokemon>> getAll();

    Completable insertAll(List<Pokemon> pokemonList);

    Completable deleteAll();
}
