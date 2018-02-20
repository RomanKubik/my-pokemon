package com.kubik.roman.mypokemon.app.presentation.main;

import javax.inject.Inject;

/**
 * Created by kubik on 2/20/18.
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getPokemons(boolean force) {

    }
}
