package io.github.maventest.menu;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

import java.util.Random;

public class DemoExamples {
    private static final int SIZE_W = 10;
    private static final int SIZE_H = 10;
    private static final Random randomGenerator = new Random();
    private static Board aiPlayerOneBoard = new Ocean();
    private static Board aiPlayerTwoBoard = new Ocean();

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

    public static void playerMakesMove() {
        Board playersBoard = new Ocean();
        playersBoard.init();
        playersBoard.print();
    }

    public static void aiPlayerOneMakesMove() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        aiPlayerOneBoard.init();
        aiPlayerOneBoard.print();
        aiPlayerTwoBoard.shotAtTheEnemyShip(randomH, randomH);
    }

    public static void aiPlayerTwoMakesMove() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        aiPlayerTwoBoard.init();
        aiPlayerTwoBoard.print();
        aiPlayerOneBoard.shotAtTheEnemyShip(randomH, randomH);
    }

    public static void startGameBetweenTwoAiPlayers() {
        aiPlayerOneMakesMove();
        aiPlayerTwoMakesMove();
    }

}
