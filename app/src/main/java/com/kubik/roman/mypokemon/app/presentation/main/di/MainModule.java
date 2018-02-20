package com.kubik.roman.mypokemon.app.presentation.main.di;

import com.kubik.roman.mypokemon.app.general.di.ActivityScope;
import com.kubik.roman.mypokemon.app.presentation.main.MainActivity;
import com.kubik.roman.mypokemon.app.presentation.main.MainContract;
import com.kubik.roman.mypokemon.app.presentation.main.MainPresenter;
import com.kubik.roman.mypokemon.domain.pokemon.PokemonInteractor;

import dagger.Module;
import dagger.Provides;

/**
 * Created by kubik on 2/20/18.
 */
@Module
public class MainModule {

    private MainActivity activity;

    public MainModule(MainActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    public MainContract.View getView() {
        return activity;
    }

    @Provides
    @ActivityScope
    public MainContract.Presenter getPresenter(PokemonInteractor pokemonInteractor) {
        return new MainPresenter(activity, pokemonInteractor);
    }
}
