package io.github.maventest;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

public class App {
    public static void main(String[] args) {
        Board board = new Ocean();
       board.init();


        ((Ocean) board).printUnits();
        board.print();
        board.shotAtTheEnemyShip(0,0);
        board.shotAtTheEnemyShip(0,1);
        board.shotAtTheEnemyShip(1,2);
    }

}




