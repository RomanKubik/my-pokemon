package com.kubik.roman.mypokemon.domain.pokemon;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by kubik on 2/20/18.
 */

public interface RemotePokemonRepository {

    Single<List<Pokemon>> getAll();


}
