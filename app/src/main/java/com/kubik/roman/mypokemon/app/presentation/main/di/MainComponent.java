package com.kubik.roman.mypokemon.app.presentation.main.di;

import com.kubik.roman.mypokemon.app.general.di.ActivityScope;
import com.kubik.roman.mypokemon.app.presentation.main.MainActivity;

import dagger.Subcomponent;

/**
 * Created by kubik on 2/20/18.
 */
@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent {

    void inject(MainActivity mainActivity);
}
