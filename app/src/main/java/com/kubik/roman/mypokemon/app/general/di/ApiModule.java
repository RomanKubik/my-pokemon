package com.kubik.roman.mypokemon.app.general.di;

import com.kubik.roman.mypokemon.BuildConfig;
import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonApi;
import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonPojoMapper;
import com.kubik.roman.mypokemon.data.pokemon.remote.RemotePokemonRepositoryImpl;
import com.kubik.roman.mypokemon.domain.pokemon.RemotePokemonRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kubik on 2/20/18.
 */
@Module
public class ApiModule {

    @Provides
    @Singleton
    public PokemonPojoMapper getPokemonPojoMapper() {
        return new PokemonPojoMapper();
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL)
                .build();
    }

    @Provides
    @Singleton
    public PokemonApi getPokemonApi(Retrofit retrofit) {
        return retrofit.create(PokemonApi.class);
    }

    @Provides
    @Singleton
    public RemotePokemonRepository getRemotePokemonRepository(PokemonApi pokemonApi, PokemonPojoMapper pokemonPojoMapper) {
        return new RemotePokemonRepositoryImpl(pokemonApi, pokemonPojoMapper);
    }
}
