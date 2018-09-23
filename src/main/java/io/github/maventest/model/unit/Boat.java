package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.List;

public class Boat implements Ship {



    private Cell cell;

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public void setPosition(Cell... cells) {

        this.cell = cells[0];
    }

    public Cell getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return "Boat{" +
                "cell=" + cell +
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
}
