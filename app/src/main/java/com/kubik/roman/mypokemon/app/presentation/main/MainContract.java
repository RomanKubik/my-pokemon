package com.kubik.roman.mypokemon.app.presentation.main;

import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import java.util.List;

/**
 * Created by kubik on 2/20/18.
 */

public interface MainContract {

    interface View {
        void onPokemonsFetched(List<Pokemon> pokemonList);

        void showError(String msg);

        void showProgress(boolean show);
    }

    interface Presenter {
        void getPokemons(boolean force);

        void onDestroy();
    }
}
