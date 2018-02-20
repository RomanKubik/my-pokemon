package com.kubik.roman.mypokemon.app.presentation.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kubik.roman.mypokemon.R;
import com.kubik.roman.mypokemon.app.presentation.main.di.MainModule;
import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.kubik.roman.mypokemon.app.general.PokemonApplication.component;

/**
 * Created by kubik on 2/20/18.
 */

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @Inject
    MainContract.Presenter presenter;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        component.getMainComponent(new MainModule(this)).inject(this);
        presenter.getPokemons(false);
    }

    @Override
    public void onPokemonsFetched(List<Pokemon> pokemonList) {

    }

    @Override
    public void showError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
