package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Boat 1 size
public class Boat implements Ship {
    private int lifeBoat = 1;
    private List<Cell> cell = new ArrayList<>();
    boolean isAlive = true;

    @Override
    public void shotAtTheEnemyShip(int weight, int height){

        int weight=0;
        int height=0;
    }

    Override
    public void toRegisterTheShot();
    this.lifeBoat = lifeBoat - 1;

    public boolean checlIsAlive


    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 1;
    }

    public List<Cell> getCells() {
        return cell;
    }

    @Override
    public String toString() {
        String cells = cell.stream().map(e -> e.toString()).reduce(" ", String::concat);

        return "Boat{" +
                "cell=" + cells +
                '}';
    }

    @Override
    public String getShipType() {
        return null;
    }

    @Override
    public boolean getIsHorizontal() {
        return false;
    }

    @Override
    public void setPosition(Boolean horizontal, Cell... cells) {
        this.cell.addAll(Arrays.asList(cells));
    }
}
