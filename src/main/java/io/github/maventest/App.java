package io.github.maventest;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

public class App {
    public static void main(String[] args) {
        Board board = new Ocean();
       // board.init();
       ((Ocean) board).newInit();

       /* board.placeUnit("Boat");
        board.placeUnit("Boat");
        board.placeUnit("Boat");
        board.placeUnit("Boat");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("Karas");
        board.placeUnit("Karas");
        board.placeUnit("Bomber");*/

        ((Ocean) board).printUnits();
        board.print();
    }

}




