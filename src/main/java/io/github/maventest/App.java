package io.github.maventest;


import io.github.maventest.menu.DemoExamples;
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

        Menu mainMenu = new MainMenu();
        mainMenu.interactWithMenu();

    }

}




