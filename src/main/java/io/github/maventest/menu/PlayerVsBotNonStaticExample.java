package io.github.maventest.menu;

import io.github.maventest.model.board.Board;
import io.github.maventest.model.board.Ocean;

import java.util.Random;
import java.util.Scanner;

public class PlayerVsBotNonStaticExample {

    private  Board BotBoard = new Ocean();
    private  Board PlayerBoard = new Ocean();
    private  final Random randomGenerator = new Random();
    private  final int SIZE_W = 10;
    private  final int SIZE_H = 10;
    private  int xCoordinateFromKeyBoard;
    private  int yCoordinateFromKeyBoard;

    public  void startBotBoardInitialization_NonStatic(){
        BotBoard.init();
        BotBoard.print();
    }

    public  void startPlayerBoardInitialization_NonStatic(){
        PlayerBoard.init();
        PlayerBoard.print();
    }

    public  void toPrintBotBoard_NonStatic(){
        System.out.println("Поле с кораблями бота :");
        BotBoard.print();
    }

    public  void toPrintPlayerBoard_NonStatic(){
        System.out.println("Поле с кораблями игрока человека :");
        PlayerBoard.print();
    }

    public  void playerMakesMove_NonStatic() {
        //поменял
        if(BotBoard.shotAtTheEnemyShipBoolean(PlayerVsBot.shootFromKeyBoardCoordinateX(),PlayerVsBot.shootFromKeyBoardCoordinateY()))
        {System.out.println("Удачный выстрел. Есть попадание");
        BotBoard.setCoordinates(PlayerVsBot.shootFromKeyBoardCoordinateX(),PlayerVsBot.shootFromKeyBoardCoordinateY());
        } else
        { System.out.println("Удачный выстрел. Есть попадание");}

    }

    public  void botMakesMove_NonStatic() {
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_W - 1);
        if(PlayerBoard.shotAtTheEnemyShipBoolean(randomW,randomH))
        {System.out.println("Удачный выстрел. Есть попадание");
        } else
        { System.out.println("Бот сделал ход. Неудачный выстрел.");}
    }

    public  int shootFromKeyBoardCoordinateX_NonStatic() {
        Scanner scX = new Scanner(System.in);
        System.out.println("Введите координату Х: ");
        xCoordinateFromKeyBoard = scX.nextInt();
        return xCoordinateFromKeyBoard;
    }

    public  int shootFromKeyBoardCoordinateY_NonStatic() {
        Scanner scY = new Scanner(System.in);
        System.out.println("Введите координату Y: ");
        yCoordinateFromKeyBoard = scY.nextInt();
        return yCoordinateFromKeyBoard;
    }

    public  boolean checkStatusForBotBoard_NonStatic(){
        if (BotBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }

    public  boolean checkStatusForPlayerBoard_NonStatic(){
        if (PlayerBoard.isGameOver()){
            return true;
        } else {
            return false;
        }
    }




}
