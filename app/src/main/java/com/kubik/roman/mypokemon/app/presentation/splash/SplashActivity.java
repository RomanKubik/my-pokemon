package com.kubik.roman.mypokemon.app.presentation.splash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kubik.roman.mypokemon.app.presentation.Navigate;

/**
 * Created by kubik on 2/20/18.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Navigate.toMainActivity(this);
    }
}
