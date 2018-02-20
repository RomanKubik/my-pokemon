package com.kubik.roman.mypokemon.app.presentation.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kubik.roman.mypokemon.domain.pokemon.Pokemon;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kubik on 2/20/18.
 */

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonHolder> {

    private List<Pokemon> pokemonList = new ArrayList<>();

    @Inject
    public PokemonAdapter() {
    }

    @Override
    public PokemonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(PokemonHolder holder, int position) {
        holder.setPokemon(pokemonList.get(position));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public void clear() {
        this.pokemonList.clear();
        notifyDataSetChanged();
    }

    public void setData(List<Pokemon> pokemonList) {
        this.pokemonList.clear();
        this.pokemonList.addAll(pokemonList);
        notifyDataSetChanged();
    }

    static class PokemonHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1)
        TextView name;

        public PokemonHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setPokemon(Pokemon pokemon) {
            name.setText(pokemon.getName());
        }
    }
}
