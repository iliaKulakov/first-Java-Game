package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

public interface Unit {

    boolean shot();

    int getSize();

    void setPosition(Cell... cells);

    public Cell getCell();

}
