package io.github.maventest;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

public class App {
    public static void main(String[] args) {
        Board board = new Ocean();
        board.init();

        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
        board.placeUnit("TwoDeckShip");
//          board.placeUnit("TwoDeckShip");
//          board.placeUnit("TwoDeckShip");
//          board.placeUnit("TwoDeckShip");
//          board.placeUnit("TwoDeckShip");
//          board.placeUnit("TwoDeckShip");

        ((Ocean) board).printUnits();
        board.print();


    }

}




