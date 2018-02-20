package com.kubik.roman.mypokemon.app.general;

import android.app.Application;

import com.kubik.roman.mypokemon.app.general.di.AppComponent;
import com.kubik.roman.mypokemon.app.general.di.AppModule;
import com.kubik.roman.mypokemon.app.general.di.DaggerAppComponent;

/**
 * Pokemon application class
 * Created by kubik on 2/18/18.
 */

public class PokemonApplication extends Application {

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        PokemonApplication.component = DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }
}
