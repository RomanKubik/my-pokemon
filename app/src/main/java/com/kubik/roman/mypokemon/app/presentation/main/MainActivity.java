package com.kubik.roman.mypokemon.app.presentation.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    @Inject
    PokemonAdapter pokemonAdapter;

    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.emptyState)
    TextView emptyState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        component.getMainComponent(new MainModule(this)).inject(this);
        init();
        presenter.getPokemons(false);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                pokemonAdapter.clear();
                presenter.getPokemons(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPokemonsFetched(List<Pokemon> pokemonList) {
        pokemonAdapter.setData(pokemonList);
        if (pokemonAdapter.getItemCount() == 0)
            emptyState.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String msg) {
        if (pokemonAdapter.getItemCount() == 0)
            emptyState.setVisibility(View.VISIBLE);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean show) {
        if (show)
            emptyState.setVisibility(View.GONE);
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(pokemonAdapter);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.pokemos);
        }
    }

}
