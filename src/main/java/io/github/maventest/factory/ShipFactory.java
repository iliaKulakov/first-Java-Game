package io.github.maventest.factory;

import io.github.maventest.model.unit.*;

public class ShipFactory {

    private static ShipFactory shipFactory;

    private ShipFactory() {
    }

    public static ShipFactory getInstance() {
        if (shipFactory == null) {
            shipFactory = new ShipFactory();
        }
        return shipFactory;
    }

    // public Boat getShip(String name) {
    public Ship getShip(String shipName) {
        switch (shipName) {
            case "Boat":
                return new Boat();

            case "TwoDeckShip":
                return new TwoDeckShip();

            case "Karas":
                return new Karas();

            case "Bomber":
                return new Bomber();

            default:
                return new Boat(); //need to fix


        }

    }
}


