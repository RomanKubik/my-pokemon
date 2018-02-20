package com.kubik.roman.mypokemon.app.presentation.main;

import com.kubik.roman.mypokemon.domain.pokemon.PokemonInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kubik on 2/20/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private PokemonInteractor pokemonInteractor;

    @Inject
    public MainPresenter(MainContract.View view, PokemonInteractor pokemonInteractor) {
        this.view = view;
        this.pokemonInteractor = pokemonInteractor;
    }

    @Override
    public void getPokemons(boolean force) {
        view.showProgress(true);
        pokemonInteractor
                .getAll(force)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> view.showProgress(false))
                .subscribe(view::onPokemonsFetched, t -> view.showError(t.getMessage()));
    }
}
