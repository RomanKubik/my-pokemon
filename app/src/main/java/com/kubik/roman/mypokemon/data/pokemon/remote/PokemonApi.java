package com.kubik.roman.mypokemon.data.pokemon.remote;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by kubik on 2/20/18.
 */

public interface PokemonApi {

    @GET("/api/v2/pokemon")
    Single<PokemonResponcePojo> getPokemons(@Query("limit") int limit);

}
