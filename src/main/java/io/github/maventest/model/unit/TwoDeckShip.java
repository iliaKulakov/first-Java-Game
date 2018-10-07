package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoDeckShip implements Ship {

    int size = 2;
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








