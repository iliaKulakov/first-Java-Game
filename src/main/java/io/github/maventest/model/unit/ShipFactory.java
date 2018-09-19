package io.github.maventest.model.unit;

public class ShipFactory {

        private static ShipFactory shipFactory;

        private ShipFactory() {
            // Empty private constructor;
        }

        public static ShipFactory getInstance() {
            if (shipFactory == null) {
                shipFactory = new ShipFactory();
            }
            return shipFactory;
        }

      //  public Ship getShip(String name) {
        //    switch (name) {

          //  }
        }



