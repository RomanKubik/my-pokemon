package com.kubik.roman.mypokemon.domain;

/**
 * Data mapper used to map database or api entities to model classes and vice versa.
 * Created by kubik on 2/18/18.
 */

public interface EntityModelMapper<E, M> {

    M fromEntity(E from);

    E toEntity(M from);
}
