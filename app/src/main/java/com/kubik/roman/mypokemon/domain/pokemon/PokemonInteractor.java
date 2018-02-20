package com.kubik.roman.mypokemon.domain.pokemon;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by kubik on 2/18/18.
 */

public class PokemonInteractor {

    private LocalPokemonRepository localPokemonRepository;
    private RemotePokemonRepository remotePokemonRepository;

    public PokemonInteractor(LocalPokemonRepository localPokemonRepository, RemotePokemonRepository remotePokemonRepository) {
        this.localPokemonRepository = localPokemonRepository;
        this.remotePokemonRepository = remotePokemonRepository;
    }

    public Single<List<Pokemon>> getAll(boolean forceUpdate) {
        if (forceUpdate) {
            return localPokemonRepository.deleteAll()
                    .andThen(fetchFromRemote());
        }
        return localPokemonRepository.getAll()
                .flatMap(l -> l.isEmpty() ? fetchFromRemote() : Single.fromObservable(Observable.just(l)));
    }

    private Single<List<Pokemon>> fetchFromRemote() {
        return remotePokemonRepository.getAll()
                .flatMap(r -> localPokemonRepository.insertAll(r)
                        .andThen(localPokemonRepository.getAll()));
    }
}
