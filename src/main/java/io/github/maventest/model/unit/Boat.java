package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Boat 1 size
public class Boat implements Ship {
    private int lifeBoat = 1;
    private List<Cell> cell = new ArrayList<>();
    private boolean isAlive = true;

    @Override
    public void toRegisterTheShot() {
        this.lifeBoat = lifeBoat - 1;
    }

    @Override
    public boolean checkIsAlive() {
        if (this.lifeBoat > 0) {
            this.isAlive = true;
            return true;
        } else {
            this.isAlive = false;
            return false;
        }

    }

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
    public UnitType getShipType() {
        return ShipType.Boat;
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
