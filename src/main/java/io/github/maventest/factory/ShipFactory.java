package io.github.maventest.factory;

import io.github.maventest.model.unit.Boat;
import io.github.maventest.model.unit.TwoDeckShip;

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
    public Boat getShip(String name) {
        switch (name) {
            case "Boat":
                return new Boat();

            case "TwoDeckShip":
                return new TwoDeckShip();

            default:
                return new Boat(); //need to fix


        }

    }
}


