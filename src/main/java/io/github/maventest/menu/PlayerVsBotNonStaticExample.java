package io.github.maventest.menu;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

import java.util.Random;
import java.util.Scanner;

public class PlayerVsBotNonStaticExample {

    private  Board botBoard = new Ocean();
    private  Board anotherBotBoard = new Ocean();
    private  Board playerBoard = new Ocean();
    private  Board twoAnotherBotBoard = new Ocean();
    private  final Random randomGenerator = new Random();
    private  final int SIZE_W = 10;
    private  final int SIZE_H = 10;
    private static int xCoordinateFromKeyBoard;
    private static int yCoordinateFromKeyBoard;

    public void startAnotherBotBoardInitialization_NonStatic(){
        anotherBotBoard.init();
        anotherBotBoard.print();
    }

    public  void startBotBoardInitialization_NonStatic(){
        botBoard.init();
        botBoard.print();
    }

    public  void startPlayerBoardInitialization_NonStatic(){
        playerBoard.init();
        playerBoard.print();
    }

    public void startwoAnotherBotBoardInitialisation(){
        twoAnotherBotBoard.init();
        twoAnotherBotBoard.print();
    }

    public  void toPrintBotBoard_NonStatic(){
        System.out.println("Поле с кораблями бота :");
        botBoard.print();
    }

    public  void toPrintPlayerBoard_NonStatic(){
        System.out.println("Поле с кораблями игрока человека :");
        playerBoard.print();
    }

    public  void toPrintAnotherBotBoard_NonStatic(){
        System.out.println("Поле с кораблями другого бота :");
        anotherBotBoard.print();
    }

    public void toPrintTwoAnotherBotBoard(){
        System.out.println("Поле с кораблями другого второго бота :");
        twoAnotherBotBoard.print();
    }

    public  void playerMakesMove_NonStatic() {

        if(botBoard.shotAtTheEnemyShipBoolean(PlayerVsBotNonStaticExample.shootFromKeyBoardCoordinateX_NonStatic(),
                PlayerVsBotNonStaticExample.shootFromKeyBoardCoordinateY_NonStatic()))
        {System.out.println("Удачный выстрел игрока. Есть попадание");
            botBoard.setCoordinates(xCoordinateFromKeyBoard, yCoordinateFromKeyBoard);
        } else
        { System.out.println("Игрок сделал неудачный выстрел. ");}

    }

    public  void botMakesMove_NonStatic() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        if(playerBoard.shotAtTheEnemyShipBoolean(randomW,randomH))
        {System.out.println("Удачный выстрел бота. Есть попадание");
            playerBoard.setCoordinates(randomW,randomH);
        } else
        { System.out.println("Бот сделал ход. Неудачный выстрел.");}
    }

    public  void anotherBotMakesMove_NonStatic() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        if(twoAnotherBotBoard.shotAtTheEnemyShipBoolean(randomW,randomH))
        {System.out.println("Другой бот Удачный выстрел. Есть попадание");
            twoAnotherBotBoard.setCoordinates(randomW,randomH);
        } else
        { System.out.println("Другой бот сделал ход. Неудачный выстрел.");}
    }

    public  void twoAnotherBotMakesMove() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        if(anotherBotBoard.shotAtTheEnemyShipBoolean(randomW,randomH))
        {System.out.println("Другой второй бот Удачный выстрел. Есть попадание");
            anotherBotBoard.setCoordinates(randomW,randomH);
        } else
        { System.out.println("Другой второй бот сделал ход. Неудачный выстрел.");}
    }


    public static int shootFromKeyBoardCoordinateX_NonStatic() {
        Scanner scX = new Scanner(System.in);
        System.out.println("Введите координату Х (строка): ");
        xCoordinateFromKeyBoard = scX.nextInt();
        return xCoordinateFromKeyBoard;
    }

    public static int shootFromKeyBoardCoordinateY_NonStatic() {
        Scanner scY = new Scanner(System.in);
        System.out.println("Введите координату Y (колонка): ");
        yCoordinateFromKeyBoard = scY.nextInt();
        return yCoordinateFromKeyBoard;
    }

    public  boolean checkStatusForBotBoard_NonStatic(){
        if (botBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

    public  boolean checkStatusForPlayerBoard_NonStatic(){
        if (playerBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

    public  boolean checkStatusForAnotherBotBoard_NonStatic(){
        if (anotherBotBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

    public  boolean checkStatusForTwoAnotherBotBoard_NonStatic(){
        if (twoAnotherBotBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

}
