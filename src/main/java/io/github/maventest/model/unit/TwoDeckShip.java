package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;
import java.util.Arrays;
import java.util.List;

public class TwoDeckShip implements Ship{

    Cell[] cellsArray= new Cell[2];
    public int numOfHits;
    public int maxHitAllowed;
    public boolean isAlive = true;
    boolean horizontal = true;

    @Override
    public void setPosition(Cell... cells) {
        this.cellsArray[0] = cells[0];
        int x = cellsArray[0].getCoordinateX();
        int y = cellsArray[0].getCoordinateY();

        cellsArray[1] = new Cell(x,y+1);}

       /* for (int i = 0; i < 2; i++) {
            if (horizontal) {
                i++;
            //    cellsArray1[1].setCoordinateX( cellsArray[1].getCoordinateX()+1);
            } else {
                //grid[row + i][column] = this;
            }
        }*/

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
        return 0;
    }

    @Override
    public String toString() {
        return "TwoDeckShip{" +
                "cellsArray=" + Arrays.toString(cellsArray) +
                '}';
    }
}








