package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

public class Karas implements Submarine {

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setPosition(Cell... cells) {

    }

    @Override
    public Cell getCell() {
        return null;
    }

    @Override
    public String getShipType() {
        return null;
    }

    @Override
    public boolean getIsHorizontal() {
        return false;
    }
}
