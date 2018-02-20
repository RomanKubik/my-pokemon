package com.kubik.roman.mypokemon.app.general.di;

import android.content.Context;

import com.kubik.roman.mypokemon.app.presentation.main.di.MainComponent;
import com.kubik.roman.mypokemon.app.presentation.main.di.MainModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by kubik on 2/20/18.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    Context getApplicationContex();

    MainComponent getMainComponent(MainModule module);
}
