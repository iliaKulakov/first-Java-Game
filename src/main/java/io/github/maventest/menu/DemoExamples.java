package io.github.maventest.menu;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

public class DemoExamples {

    public static void showDemoGame() {
        Board board = new Ocean();
        board.init();
        ((Ocean) board).printUnits();
        int SIZE_X = 10;
        int SIZE_Y = 10;
        for (int i = 0; i < SIZE_X; i++) {
            for (int j = 0; j < SIZE_Y; j++) {
                board.shotAtTheEnemyShip(i, j);
            }
        }
        board.print();
        System.out.println("The Current Game is Over: " + board.isGameOver());
    }

}
