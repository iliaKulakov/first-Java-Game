package io.github.maventest.menu;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;
import java.util.Random;
import java.util.Scanner;

public class PlayerVsBot {

    private static Board BotBoard = new Ocean();
    private static Board PlayerBoard = new Ocean();
    private static final Random randomGenerator = new Random();
    private static final int SIZE_W = 10;
    private static final int SIZE_H = 10;
    private static int xCoordinateFromKeyBoard;
    private static int yCoordinateFromKeyBoard;

    public static void startBotBoardInitialization(){
        BotBoard.init();
        BotBoard.print();
    }

    public static void startPlayerBoardInitialization(){
        PlayerBoard.init();
        PlayerBoard.print();
    }

    public static void toPrintBotBoard(){
        System.out.println("Поле с кораблями бота :");
        BotBoard.print();
    }

    public static void toPrintPlayerBoard(){
        System.out.println("Поле с кораблями игрока человека :");
        PlayerBoard.print();
    }

    public static void playerMakesMove() {

        if(BotBoard.shotAtTheEnemyShipBoolean(PlayerVsBot.shootFromKeyBoardCoordinateX(),PlayerVsBot.shootFromKeyBoardCoordinateY()))
            {System.out.println("Удачный выстрел. Есть попадание");
        } else
            { System.out.println("Удачный выстрел. Есть попадание");}

    }

    public static void botMakesMove() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        if(PlayerBoard.shotAtTheEnemyShipBoolean(randomW,randomH))
            {System.out.println("Удачный выстрел. Есть попадание");
        } else
            { System.out.println("Бот сделал ход. Неудачный выстрел.");}
    }

    public static int shootFromKeyBoardCoordinateX() {
        Scanner scX = new Scanner(System.in);
        System.out.println("Введите координату Х: ");
        xCoordinateFromKeyBoard = scX.nextInt();
        return xCoordinateFromKeyBoard;
    }

    public static int shootFromKeyBoardCoordinateY() {
        Scanner scY = new Scanner(System.in);
        System.out.println("Введите координату Y: ");
        yCoordinateFromKeyBoard = scY.nextInt();
        return yCoordinateFromKeyBoard;
    }

    public static boolean checkStatusForBotBoard(){
        if (BotBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkStatusForPlayerBoard(){
        if (PlayerBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

}