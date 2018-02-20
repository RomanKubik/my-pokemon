package com.kubik.roman.mypokemon.app.general.di;

import com.kubik.roman.mypokemon.domain.pokemon.LocalPokemonRepository;
import com.kubik.roman.mypokemon.domain.pokemon.PokemonInteractor;
import com.kubik.roman.mypokemon.domain.pokemon.RemotePokemonRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kubik on 2/20/18.
 */
@Module
public class InteractorModule {

    @Provides
    @Singleton
    public PokemonInteractor getPokemonInteractor(LocalPokemonRepository localPokemonRepository, RemotePokemonRepository remotePokemonRepository) {
        return new PokemonInteractor(localPokemonRepository, remotePokemonRepository);
    }
}
