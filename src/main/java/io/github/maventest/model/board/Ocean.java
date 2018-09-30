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
    public void placeUnit(String shipType) {

        Ship ship = this.shipFactory.getShip(shipType);

        boolean horizontal = randomGenerator.nextBoolean();

        int shipLength = ship.getSize();
        CellSet<Cell> shipCells = new CellSet<>();

//      TODO: Сформировать координаты отностительно занятости и позции
        // this.generateCell(shipLength, shipCells, horizontal)
        this.generateCell(shipLength, shipCells, horizontal);

        System.out.println(ship.toString());
        System.out.println(shipCells.toString());


        if (boats.isEmpty()) {
            boats.put(shipCells, ship);
            return;
        }
        /*} else{

          boats.containsKey(shipCells)



        }*/
        //System.out.println(boats.containsKey(),boats.containsValue());


    }

    public void afterInit(int w, int h) {
        int randomW11 = w;
        int randomH11 = h;
        int randomW = 1;
        int randomH = 1;

        int random[][] = new int[10][10];
        random[randomW][randomH] = 1;

        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                if (boardCells[i][j] == random[randomW][randomH]) {
                    boardCells[i][j] = 1;
                    this.print();
                }
            }
        }

    }


    private void generateCell(int shipLength, CellSet<Cell> cells, boolean horizontal) {
        // private CellSet<Cell>  generateCell(int shipLength, CellSet<Cell> cells, boolean horizontal) {
        int randomW = randomGenerator.nextInt(SIZE_W);
        int randomH = randomGenerator.nextInt(SIZE_H);


        for (int i = 0; i < shipLength; i++) {
            Cell cell = new Cell(randomW, randomH);
            if (isOccupied(cells)) {
                this.generateCell(shipLength, cells, horizontal);
            } else {

                if (horizontal) {
                    System.out.println("true ");
                    cell.setCoordinateX(randomW);
                    cell.setCoordinateY(randomH);
                    randomH++;
                    System.out.print(cell.getCoordinateX());
                    System.out.print(cell.getCoordinateY());
                } else {
                    System.out.println("false ");
                    cell.setCoordinateX(randomW);
                    cell.setCoordinateY(randomH);
                    randomW++;
                    System.out.print(cell.getCoordinateX());
                    System.out.print(cell.getCoordinateY());
                }
//                TODO: Проверка на горизонтальность
                //        int x = cellsArray[0].getCoordinateX();
//        int y = cellsArray[0].getCoordinateY();
//
//        if (horizontal) {
//            cellsArray[1] = new Cell(x, y + 1);
//        } else {
//            cellsArray[1] = new Cell(x + 1, y);
//        }

                cells.add(cell);
                this.afterInit(randomW, randomH);
            }
        }
        //return cells;
    }

    private boolean isOccupied(CellSet<Cell> cells) {
        boolean status = false;
        for (Map.Entry<CellSet<Cell>, Unit> item : boats.entrySet()) {
            if (!cells.contains(item.getKey())) {
                status = true;
                break;
            }
        }
        return status;
    }


//    public boolean isOccupied(Ship Boat) {
//        if (this.units.contains(Boat)) {
//            System.out.println("Cells with ships");
//            return true;
//
//        } else {
//            System.out.println("Cells without ships");
//            return false;
//
//        }
//    }

    public void printUnits() {
        //units.forEach(System.out::print);
        for (Unit unit : units) {
            System.out.print(unit);
        }

    }


}








