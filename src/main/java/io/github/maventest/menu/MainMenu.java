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

                    PlayerVsBotNonStaticExample playerVsBot = new PlayerVsBotNonStaticExample();
                    System.out.println("Инициализация и заполнение кораблями игрового поля - Бота");
                    playerVsBot.startBotBoardInitialization_NonStatic();
                    System.out.println("Инициализация и заполнение кораблями игрового поля - Игрока");
                    playerVsBot.startPlayerBoardInitialization_NonStatic();

                    while (!(playerVsBot.checkStatusForPlayerBoard_NonStatic() || playerVsBot.checkStatusForBotBoard_NonStatic())) {
                        System.out.println("Игрок делает ход");
                        playerVsBot.playerMakesMove_NonStatic();
                        System.out.println("Доска бота. После выстрела игрока");
                        playerVsBot.toPrintBotBoard_NonStatic();
                        System.out.println("Кораблей бота уничтожено - " + playerVsBot.getShipsDestroyedBot());

                        System.out.println("Бот делает ход");
                        playerVsBot.botMakesMove_NonStatic();
                        System.out.println("Доска игрока. После выстрела бота");
                        playerVsBot.toPrintPlayerBoard_NonStatic();
                        System.out.println("Кораблей игрока уничтожено - " + playerVsBot.getShipsDestroyedplayerBoard());
                    }

                    exit = false;
                    break;
                case 2:
                    System.out.println("Вы ввели число 2 - Игра ботов между собой ");

                    PlayerVsBotNonStaticExample botVsBot = new PlayerVsBotNonStaticExample();
                    System.out.println("Инициализация и заполнение кораблями игрового поля - Бота");
                    botVsBot.startAnotherBotBoardInitialization_NonStatic();
                    System.out.println("Инициализация и заполнение кораблями игрового поля - Другого Бота");
                    botVsBot.startwoAnotherBotBoardInitialisation();
                    /*
                    while (!(botVsBot.checkStatusForAnotherBotBoard_NonStatic() || botVsBot.checkStatusForTwoAnotherBotBoard_NonStatic())) {
                        System.out.println("Бот делает ход");
                        botVsBot.anotherBotMakesMove_NonStatic();
                        System.out.println("Доска второго бота. После выстрела первого");
                        botVsBot.toPrintTwoAnotherBotBoard();

                        System.out.println("Второй Бот делает ход");
                        botVsBot.twoAnotherBotMakesMove();
                        System.out.println("Доска первого бота после выстрела первого. ");
                        botVsBot.toPrintAnotherBotBoard_NonStatic();
                       // botVsBot.checkStatusForTwoAnotherBotBoard_NonStatic()
                    }*/

                    while (!(botVsBot.checkStatusForTwoAnotherBotBoard_NonStatic())) {
                        System.out.println("Бот делает ход");
                        botVsBot.anotherBotMakesMove_NonStatic();
                        System.out.println("Доска второго бота. После выстрела первого");

                        botVsBot.toPrintTwoAnotherBotBoard();
                        System.out.println("Кораблей второго бота уничтожено - " + botVsBot.getShipsDestroyedTwoAnotherBot());
                    }

                    exit = false;
                    break;
                case 3:
                    System.out.println("Вы ввели число 3 - Автоматическое демо игры. Сам с собой ");
                    Runnable boardThread = DemoExamples::showDemoGame;
                    executor.execute(boardThread);

                    exit = false;
                    break;
                case 4:
                    System.out.println("Игра закончена. Выход  ");
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


