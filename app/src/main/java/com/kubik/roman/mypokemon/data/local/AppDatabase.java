package com.kubik.roman.mypokemon.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.kubik.roman.mypokemon.data.pokemon.local.PokemonDao;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntity;

/**
 * Created by kubik on 2/20/18.
 */
@Database(entities = PokemonEntity.class, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract PokemonDao pokemonDao();
}
