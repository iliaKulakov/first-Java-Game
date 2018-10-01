package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

public interface Unit {

    boolean shot();

    int getSize();

    void setPosition(Boolean horizontal, Cell... cells);

    public Cell getCell();

    public String getShipType();

    boolean getIsHorizontal();

}
