package com.kubik.roman.mypokemon.app.general.di;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.kubik.roman.mypokemon.data.local.AppDatabase;
import com.kubik.roman.mypokemon.data.pokemon.local.LocalPokemonRepositoryImpl;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonDao;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntityMapper;
import com.kubik.roman.mypokemon.domain.pokemon.LocalPokemonRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kubik on 2/20/18.
 */
@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public PokemonEntityMapper getPokemonEntityMapper() {
        return new PokemonEntityMapper();
    }

    @Provides
    @Singleton
    public AppDatabase geAppDatabase(Context context) {
        return Room
                .databaseBuilder(context, AppDatabase.class, "poke")
                .build();
    }

    @Provides
    @Singleton
    public PokemonDao getPokemonDao(AppDatabase appDatabase) {
        return appDatabase.pokemonDao();
    }

    @Provides
    @Singleton
    public LocalPokemonRepository getLocalPokemonRepository(PokemonDao pokemonDao, PokemonEntityMapper pokemonEntityMapper) {
        return new LocalPokemonRepositoryImpl(pokemonDao, pokemonEntityMapper);
    }
}
