package com.kubik.roman.mypokemon.data.local;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.kubik.roman.mypokemon.data.pokemon.local.LocalPokemonRepositoryImpl;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonDao;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntity;
import com.kubik.roman.mypokemon.data.pokemon.local.PokemonEntityMapper;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.Collections;

/**
 * Created by kubik on 2/20/18.
 */

@RunWith(AndroidJUnit4.class)
public class LocalRepositoryTest {

    private LocalPokemonRepositoryImpl localPokemonRepository;
    private PokemonDao pokemonDao;
    private AppDatabase database;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        database = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        pokemonDao = database.pokemonDao();
        localPokemonRepository = new LocalPokemonRepositoryImpl(pokemonDao, new PokemonEntityMapper());
    }

    @After
    public void closeDb() throws IOException {
        database.close();
    }

    @Test
    public void writePokemonAndReadInList() throws Exception {
        Pokemon pokemon = new Pokemon("id", "name", "url");
        localPokemonRepository.insertAll(Collections.singletonList(pokemon))
                .subscribe(() -> {
                    localPokemonRepository.getAll()
                            .subscribe(l -> {
                                Assert.assertEquals(l.size(), 1);
                                Pokemon result = l.get(0);
                                Assert.assertEquals(result.getId(), pokemon.getId());
                                Assert.assertEquals(result.getUrl(), pokemon.getUrl());
                                Assert.assertEquals(result.getName(), pokemon.getName());
                            });
                });
    }

    @Test
    public void writePokemonAndClearList() throws Exception {
        Pokemon pokemon = new Pokemon("id", "name", "url");
        localPokemonRepository.insertAll(Collections.singletonList(pokemon))
                .subscribe(() -> {
                    localPokemonRepository.getAll()
                            .subscribe(l -> {
                                Assert.assertEquals(l.size(), 1);
                                localPokemonRepository.deleteAll().subscribe(() -> {
                                    localPokemonRepository.getAll()
                                            .subscribe(ll -> Assert.assertEquals(ll.size(), 0));
                                });
                            });
                });

    }

}
