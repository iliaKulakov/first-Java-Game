package io.github.maventest.model.board;

import io.github.maventest.model.unit.UnitType;

public class Sky implements Board {

    @Override
    public void init() {

    }

    @Override
    public void print() {

    }

    @Override
    public void placeUnit(UnitType unitType) {

    }

    @Override
    public void shotAtTheEnemyShip(int weight, int height) {
    }

    public boolean shotAtTheEnemyShipBoolean(int weight, int height) { return true;
    }

    public boolean isGameOver() {
        return true;
    }

}

