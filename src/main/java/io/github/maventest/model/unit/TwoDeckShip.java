package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDeckShip implements Ship {
    int size = 2;
    private int lifeTwoDeckShip = 2;
    private boolean isAlive = true;
    private List<Cell> cellsArray = new ArrayList<>();
    private boolean isHorizontal = true;

    @Override
    public void toRegisterTheShot() {
        this.lifeTwoDeckShip = lifeTwoDeckShip - 1;
    }

    @Override
    public boolean checkIsAlive() {
        if (this.lifeTwoDeckShip > 0) {
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
        return isAlive;
    }

    @Override
    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    @Override
    public UnitType getShipType() {
        return ShipType.TwoDeckShip;
    }

    @Override
    public void setPosition(Boolean horizontal, Cell... cells) {
        this.isHorizontal = horizontal;
        this.cellsArray.addAll(Arrays.asList(cells));
    }

    @Override
    public List<Cell> getCells() {
        return this.cellsArray;
    }

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String cells = cellsArray.stream().map(e -> e.toString()).reduce(" ", String::concat);

        return "TwoDeckShip{" +
                "size=" + size +
                ", cellsArray=" + cells +
                ", isHorizontal=" + isHorizontal +
                '}';
    }
}








