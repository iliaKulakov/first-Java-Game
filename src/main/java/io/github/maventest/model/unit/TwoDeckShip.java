package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.Arrays;

public class TwoDeckShip implements Ship{


    @Override
    public String toString() {
        return "TwoDeckShip{" +
                "cellsArray=" + Arrays.toString(cellsArray) +
                '}';
    }

    private Cell[] cellsArray= new Cell[2];
    public int numOfHits;
    public int maxHitAllowed;
    public boolean isAlive = true;


    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 2;
    }

    @Override
    public void setPosition(Cell... cells) {

        this.cellsArray = cells;

    }

    @Override
    public Cell getCell() {
        return null;
    }

    public Cell[] getCellsArray() {
        return cellsArray;
    }
}
