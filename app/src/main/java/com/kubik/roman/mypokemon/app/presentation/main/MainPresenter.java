package com.kubik.roman.mypokemon.app.presentation.main;

import android.util.Log;

import com.kubik.roman.mypokemon.domain.pokemon.PokemonInteractor;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kubik on 2/20/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;
    private PokemonInteractor pokemonInteractor;
    private Disposable disposable;

    @Inject
    public MainPresenter(MainContract.View view, PokemonInteractor pokemonInteractor) {
        this.view = view;
        this.pokemonInteractor = pokemonInteractor;
    }

    @Override
    public void getPokemons(boolean force) {
        if (isRequestProcessing()) return;
        view.showProgress(true);
        disposable = pokemonInteractor
                .getAll(force)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally(() -> view.showProgress(false))
                .subscribe(view::onPokemonsFetched, t -> view.showError(t.getMessage()));
    }

    @Override
    public void onDestroy() {
        if (disposable != null)
            disposable.dispose();
    }

    private boolean isRequestProcessing() {
        return disposable != null && !disposable.isDisposed();
    }
}
