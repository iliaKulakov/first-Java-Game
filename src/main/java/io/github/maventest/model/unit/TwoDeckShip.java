package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;
import java.util.Arrays;
import java.util.List;

public class TwoDeckShip extends Boat implements Ship {

    Cell[] cellsArray= new Cell[2];
    public int numOfHits;
    public int maxHitAllowed;
    public boolean isAlive = true;
    private boolean isHorizontal = true;

    @Override
    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    public void setHorizontal(boolean horizontal) {
        isHorizontal = horizontal;
    }

    @Override
    public String getShipType() {
        return "TwoDeckShip";
    }

    @Override
    public void setPosition(Cell... cells) {
        this.cellsArray[0] = cells[0];
        int x = cellsArray[0].getCoordinateX();
        int y = cellsArray[0].getCoordinateY();
        cellsArray[1] = new Cell(x,y+1);}

    @Override
    public Cell getCell() {
        return null;
    }

    public Cell[] getCellsArray() {
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








