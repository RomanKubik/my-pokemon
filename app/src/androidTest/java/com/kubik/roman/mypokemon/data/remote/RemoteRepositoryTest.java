package com.kubik.roman.mypokemon.data.remote;

import android.content.Context;
import android.support.test.runner.AndroidJUnit4;

import com.kubik.roman.mypokemon.data.pokemon.remote.PokemonPojoMapper;
import com.kubik.roman.mypokemon.data.pokemon.remote.RemotePokemonRepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

/**
 * Created by kubik on 2/20/18.
 */

@RunWith(AndroidJUnit4.class)
public class RemoteRepositoryTest {

    RemotePokemonRepositoryImpl remotePokemonRepository;
    PokemonPojoMapper pokemonPojoMapper;

    @Mock
    Context context;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getAllDataFromApi() throws Exception {
    
    }
}
