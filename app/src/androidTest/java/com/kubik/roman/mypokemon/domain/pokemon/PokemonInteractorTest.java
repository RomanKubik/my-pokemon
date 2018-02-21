package com.kubik.roman.mypokemon.domain.pokemon;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;

import com.kubik.roman.mypokemon.data.local.AppDatabase;
import com.kubik.roman.mypokemon.data.pokemon.local.LocalPokemonRepositoryImpl;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonDao;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntity;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntityMapper;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.reactivex.Single;

/**
 * Created by kubik on 2/21/18.
 */

public class PokemonInteractorTest {

    private PokemonInteractor pokemonInteractor;
    private PokemonDao pokemonDao;
    private AppDatabase database;

    private Pokemon testPokemon = new Pokemon("id", "name", "url");

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        pokemonDao = database.pokemonDao();
        LocalPokemonRepository localPokemonRepository = new LocalPokemonRepositoryImpl(pokemonDao, new PokemonEntityMapper());
        RemotePokemonRepository remotePokemonRepository = () -> Single.just(Collections.singletonList(testPokemon));
        pokemonInteractor = new PokemonInteractor(localPokemonRepository, remotePokemonRepository);
    }

    @After
    public void closeDb() throws IOException {
        database.close();
    }

    @Test
    public void emptyDatabaseTest() throws Exception {
        pokemonInteractor.getAll(false)
                .subscribe(r -> {
                    Assert.assertEquals(1, r.size());
                    Assert.assertEquals(testPokemon.getId(), r.get(0).getId());
                });
    }

    @Test
    public void nonEmptyDatabaseTest() throws Exception {
        PokemonEntity pokemonEntity = new PokemonEntity("local_id", "local_name", "local_url");
        pokemonDao.insertAll(Collections.singletonList(pokemonEntity));
        pokemonInteractor.getAll(false)
                .subscribe(r -> {
                    Assert.assertEquals(1, r.size());
                    Assert.assertEquals(pokemonEntity.getId(), r.get(0).getId());
                    Assert.assertNotEquals(testPokemon.getId(), r.get(0).getId());
                });
    }

    @Test
    public void forceUpdateTest() throws Exception {
        PokemonEntity pokemonEntity = new PokemonEntity("local_id", "local_name", "local_url");
        pokemonDao.insertAll(Collections.singletonList(pokemonEntity));
        pokemonInteractor.getAll(true)
                .subscribe(r -> {
                    Assert.assertEquals(1, r.size());
                    Assert.assertNotEquals(pokemonEntity.getId(), r.get(0).getId());
                    Assert.assertEquals(testPokemon.getId(), r.get(0).getId());
                });
    }

}
