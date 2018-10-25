package io.github.maventest.model.board;

import io.github.maventest.model.unit.UnitType;

public interface Board<T> {

    void init();

    void print();

    void placeUnit(UnitType<T> unitType);

    void shotAtTheEnemyShip(int weight, int height);

    boolean shotAtTheEnemyShipBoolean(int weight, int height);

    boolean isGameOver();

    void setCoordinates(int x, int y);

    int getShipsDestroyed();



}
