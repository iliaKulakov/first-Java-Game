package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.List;

public interface Unit {

    boolean shot();

    int getSize();

    void setPosition(Boolean horizontal, Cell... cells);

    List<Cell> getCells();

    String getShipType();

    boolean getIsHorizontal();

  //  boolean shotAtTheEnemyShip(int weight, int height);

    void toRegisterTheShot();

    public boolean checkIsAlive();

}
