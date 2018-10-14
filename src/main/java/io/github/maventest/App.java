package io.github.maventest;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        Board board = new Ocean();
        board.init();
        ((Ocean) board).printUnits();
         int SIZE_W = 10;
         int SIZE_H = 10;
        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                board.shotAtTheEnemyShip(i, j);

                }

        }
        if (board.isGameOver()) {
            System.out.println("The Current Game is Over = TRUE");
        }
        board.print();
        System.out.println("The Current Game is Over: " + board.isGameOver());

    }

}




