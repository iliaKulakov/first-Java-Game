package io.github.maventest.menu;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainMenu extends AbstractMenu {

    Executor executor = Executors.newCachedThreadPool();

    public MainMenu() {
        super();
        initMenuItems();
    }

    private void initMenuItems() {
        this.items.add("Игра с компьютерным противником (ботом): ");
        this.items.add("Игра ботов между собой: ");
        this.items.add("Демо игры. Сам с собой: ");
        this.items.add("Выход:");
    }

    @Override
    public void interactWithMenu() {
        boolean exit;
        do {
            printMenu(); //вызываю печать меню от menu.AbstractMenu
            Scanner sc = new Scanner(System.in);
            int command;
            do {
                System.out.println("Введите номер: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Введен не номер режима игры. Попробуйте еще раз");
                    sc.next();
                }
                command = sc.nextInt();
            } while (command <= 0);
            switch (command) {
                case 1:
                    System.out.println("Вы ввели число 1 - Игра с компьютерным противником (ботом) ");
                    PlayerVsBot.startBotBoardInitialization();
                    PlayerVsBot.startPlayerBoardInitialization();

                  //  while (!PlayerVsBot.checkStatusForPlayerBoard()) {
                    PlayerVsBot.playerMakesMove();
                    PlayerVsBot.toPrintBotBoard();
                    PlayerVsBot.botMakesMove();
                  /*  if(PlayerVsBot.checkStatusForBotBoard()) {
                        PlayerVsBot.botMakesMove();
                        if(PlayerVsBot.checkStatusForPlayerBoard())
                            {System.out.println("Игрок проиграл, выиграл бот");
                            } else {
                         break;
                        }

                    }

                    }*/

                    exit = false;
                    break;
                case 2:
                    System.out.println("Вы ввели число 2 - Игра ботов между собой ");

                    DemoExamples.aiPlayerOneMakesMove();

                    exit = false;
                    break;
                case 3:
                    System.out.println("Вы ввели число 3 - Автоматическое демо игры. Сам с собой ");
                    // I will use separate thread for each item menu

                    Runnable boardThread = DemoExamples::showDemoGame;
                    executor.execute(boardThread);

                    exit = false;
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Ошибка! Попробуйте еще раз:  ");
                    exit = false;
                    break;

            } // end switch

        } while (!exit);

    }
}


