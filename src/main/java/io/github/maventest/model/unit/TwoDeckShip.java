package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TwoDeckShip extends Boat implements Ship {

    public int numOfHits;
    public int maxHitAllowed;
    public boolean isAlive = true;
    private List<Cell> cellsArray = new ArrayList<>();
    private boolean isHorizontal = true;


    @Override
    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    @Override
    public String getShipType() {
        return "TwoDeckShip";
    }

    @Override
    public void setPosition(Boolean horizontal, Cell... cells) {
        this.isHorizontal = horizontal;
        this.cellsArray.addAll(Arrays.asList(cells));
    }

    @Override
    public Cell getCell() {
        return null;
    }

    public List<Cell>[] getCellsArray() {
        return cellsArray;
    }

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public String toString() {
        return "TwoDeckShip{" +
                "cellsArray=" + Arrays.toString(cellsArray) +
                '}';
    }

}








