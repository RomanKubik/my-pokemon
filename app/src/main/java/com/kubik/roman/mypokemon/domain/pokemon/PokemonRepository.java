package com.kubik.roman.mypokemon.domain.pokemon;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by kubik on 2/18/18.
 */

public interface PokemonRepository {

    Single<List<Pokemon>> getAll();
}
