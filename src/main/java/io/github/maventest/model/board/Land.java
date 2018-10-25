package io.github.maventest.model.board;

import io.github.maventest.model.unit.UnitType;

public class Land implements Board {
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

    public boolean shotAtTheEnemyShipBoolean(int weight, int height) {
        return true;
    }

    public boolean isGameOver() {
        return true;
    }

    public void setCoordinates(int x, int y) {
    }

    public int getShipsDestroyed() {
        return 1;
    }


    public int[][] getBoardCells() {

        int[][] temple = new int[10][10];
        return temple;
    }

}



