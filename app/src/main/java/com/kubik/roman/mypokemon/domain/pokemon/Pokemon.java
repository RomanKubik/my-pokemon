package com.kubik.roman.mypokemon.domain.pokemon;

/**
 * Represents Pokemon data model
 * Created by kubik on 2/18/18.
 */

public class Pokemon {

    private String id;
    private String name;
    private String url;

    public Pokemon(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}
