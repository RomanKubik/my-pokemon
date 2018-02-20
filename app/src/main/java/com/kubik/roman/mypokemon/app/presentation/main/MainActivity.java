package com.kubik.roman.mypokemon.app.presentation.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kubik.roman.mypokemon.app.presentation.main.di.MainModule;

import static com.kubik.roman.mypokemon.app.general.PokemonApplication.component;

/**
 * Created by kubik on 2/20/18.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component.getMainComponent(new MainModule(this)).inject(this);
    }
}
