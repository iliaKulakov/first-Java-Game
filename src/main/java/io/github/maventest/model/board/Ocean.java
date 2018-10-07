package io.github.maventest.model.board;

import io.github.maventest.factory.ShipFactory;
import io.github.maventest.model.unit.Ship;
import io.github.maventest.model.unit.Unit;

import java.util.*;

public class Ocean implements Board {
    private final int SIZE_W = 10;
    private final int SIZE_H = 10;
    private final Random randomGenerator = new Random();
    private final ShipFactory shipFactory;
    private int boardCells[][] = new int[SIZE_W][SIZE_H];
    private List<Unit> units = new ArrayList<>();
    private Map<CellSet<Cell>, Unit> boats = new HashMap<>();

    public Ocean() {
        shipFactory = ShipFactory.getInstance();
    }

    @Override
    public void init() {

        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                boardCells[i][j] = 0;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                System.out.print(boardCells[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    @Override
    public void placeUnit(String shipType) throws ArrayIndexOutOfBoundsException {

        Ship ship = this.shipFactory.getShip(shipType);
        boolean horizontal = randomGenerator.nextBoolean();
        int shipLength = ship.getSize();
        CellSet<Cell> shipCells = new CellSet<>();

//      TODO: Сформировать координаты отностительно занятости и позции
        shipCells = this.generateCell(shipLength, horizontal);

        try {
            for (Cell cell : shipCells) {
                boardCells[cell.getCoordinateX()][cell.getCoordinateY()] = 1;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }

        ship.setPosition(horizontal, shipCells.toArray(new Cell[shipCells.size()]));

        boats.put(shipCells, ship);

    }

    private CellSet<Cell> generateCell(int shipLength, boolean horizontal) {

        CellSet<Cell> localCells = getRandomCells(shipLength, horizontal);

        if (isOccupied(localCells)) {
            generateCell(shipLength, horizontal);
        }

        return localCells;

    }

    private CellSet<Cell> getRandomCells(int shipLength, boolean horizontal) {
        CellSet<Cell> cells = new CellSet<>();
        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_H - 1);


        if (okPlaceToShip(randomW,randomW,shipLength,horizontal)) {
            for (int i = 0; i < shipLength; i++) {

                Cell cell = new Cell(randomW, randomH);

                if (horizontal) {
                    System.out.println("horizontal ");
                    cell.updateCoordinates(randomH, randomW);
                    randomH++;
                } else {
                    System.out.println("vertical ");
                    cell.updateCoordinates(randomH, randomW);
                    randomW++;
                }
                cells.add(cell);
            }
        } else {
            getRandomCells(shipLength,horizontal);
        }

            //return cells;

     return cells;
    }

    private boolean isOccupied(CellSet<Cell> cells) throws StackOverflowError {
        boolean status = false;
        for (Map.Entry<CellSet<Cell>, Unit> item : boats.entrySet()) {
            if (cells.contains(item.getKey())) {
                status = true;
                break;
            }
        }

        return status;
    }


    public void printUnits() {
        for (Unit unit : units) {
            System.out.print(unit);
        }
    }

    private boolean okPlaceToShip(int randomW ,int randomH, int shipLength,boolean horizontal ){
        int H = randomH;
        int W = randomW;
        int shipLengthVar = shipLength;
        boolean horizontalVar = horizontal;


        if(horizontal){

           // if(W - shipLengthVar == 0||W - shipLengthVar > 0){
            if ((W + shipLengthVar) > SIZE_W - 1 ){
                return true;
            } else {return  false;}

        } else

      //  if(H - shipLengthVar == 0||H - shipLengthVar > 0){
            if ((H + shipLengthVar) > SIZE_H - 1 ){
            return true;
        } else {return  false;}
    }

}








