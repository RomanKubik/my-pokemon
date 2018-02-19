package com.kubik.roman.mypokemon.data.pokemon.remote;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonPojo {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public PokemonPojo(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
