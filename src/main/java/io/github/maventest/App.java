package io.github.maventest;


import io.github.maventest.menu.MainMenu;
import io.github.maventest.menu.Menu;
import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;
import io.github.maventest.model.board.PlayersThread;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class App {
    public static void main(String[] args) {

        Runnable hello = ()->{
        Menu mainMenu = new MainMenu();
        mainMenu.interactWithMenu();
        };

        Runnable boardThread = ()->{
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
        };



      Executor executor = Executors.newCachedThreadPool();
      executor.execute(hello);
     // executor.execute(boardThread);

    }

}




