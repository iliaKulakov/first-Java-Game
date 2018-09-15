package io.github.maventest.model.board;

import io.github.maventest.model.unit.Ship;

public interface Board {

    void init();

    void print();

    void placeUnit();

    void placeTwoUnit();

    boolean isOccupied(Ship boat);


}
