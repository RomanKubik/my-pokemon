package com.kubik.roman.mypokemon.data.pokemon.remote;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonResponcePojo {

    @SerializedName("count")
    private int count;
    @SerializedName("results")
    private List<PokemonPojo> pokemons = new ArrayList<>();

    public PokemonResponcePojo(int count, List<PokemonPojo> pokemons) {
        this.count = count;
        this.pokemons = pokemons;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<PokemonPojo> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<PokemonPojo> pokemons) {
        this.pokemons = pokemons;
    }
}
