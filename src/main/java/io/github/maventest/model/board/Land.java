package io.github.maventest.model.board;

import io.github.maventest.model.unit.Ship;

public class Land implements Board {
    @Override
    public void init() {

    }

    @Override
    public void print() {

    }

    @Override
    public void placeUnit() {


    }

    @Override
    public boolean isOccupied(Ship boat) {
        return false;
    }
}
