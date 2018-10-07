package io.github.maventest.model;

import io.github.maventest.model.unit.Ship;

public final class ShipPrinter {

    public void printShip(Ship ship) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(ship.getShipType()).append("\n");
        stringBuffer.append(ship.getSize()).append("\n");

        String cells = ship.getCells().stream().map(e -> e.toString()).reduce("", String::concat);

        stringBuffer.append(cells).append("\n");
        stringBuffer.append("____________________________");

        System.out.println(stringBuffer.toString());
    }
}
