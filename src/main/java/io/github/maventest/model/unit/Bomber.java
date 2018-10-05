package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.List;

public class Bomber implements Airplane {

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setPosition(Boolean horizontal, Cell... cells) {

    }

    @Override
    public List<Cell> getCell() {
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
