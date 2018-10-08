package io.github.maventest.factory;

import io.github.maventest.model.unit.*;

public class NewShipFactory {

    private static NewShipFactory NewShipFactory;

    private NewShipFactory() {
    }

    public static NewShipFactory getInstance() {
        if (NewShipFactory == null) {
            NewShipFactory = new NewShipFactory();
        }
        return NewShipFactory;
    }

    public Ship getNewShip(String shipName) {
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
