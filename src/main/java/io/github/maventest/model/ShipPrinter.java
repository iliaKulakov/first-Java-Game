package io.github.maventest.model;

import io.github.maventest.model.board.Cell;
import io.github.maventest.model.unit.Ship;

public final class ShipPrinter {

    public void printShip(Ship ship) {
        StringBuilder sb = new StringBuilder();

        sb.append(ship.getShipType()).append("\n");
        sb.append(ship.getSize()).append("\n");

        String cells = ship.getCells().stream().map(Cell::toString).reduce("", String::concat);

        sb.append(cells).append("\n");
        sb.append("____________________________");

        System.out.println(sb.toString());
    }
}
