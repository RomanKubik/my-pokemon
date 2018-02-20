package com.kubik.roman.mypokemon.data.pokemon.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

/**
 * Created by kubik on 2/20/18.
 */
@Dao
public interface PokemonDao {

    @Query("SELECT * FROM pokemon")
    Single<List<PokemonEntity>> getAll();

    @Query("DELETE FROM pokemon")
    Completable deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertAll(List<PokemonEntity> pokemons);
}
