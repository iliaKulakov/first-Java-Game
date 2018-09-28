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
        //boolean horizontal = randomGenerator.nextBoolean();
        boolean horizontal = false;
        int shipLength = ship.getSize();
        CellSet<Cell> shipCells = new CellSet<>();

//      TODO: Сформировать координаты отностительно занятости и позции
        this.generateCell(shipLength, shipCells, horizontal);

        System.out.println(ship.toString());

        if (boats.isEmpty()) {
            boats.put(shipCells, ship);
            return;
        }

    }

    private void generateCell(int shipLength, CellSet<Cell> cells, boolean horizontal) {
        int randomW = randomGenerator.nextInt(SIZE_W);
        int randomH = randomGenerator.nextInt(SIZE_H);

        for (int i = 0; i < shipLength; i++) {
            Cell cell = new Cell(randomW, randomH);
            if (isOccupied(cells)) {
                this.generateCell(shipLength, cells, horizontal);
            } else {

                        if (horizontal){
                                System.out.println("true");
                                    for(int j = 0; j < shipLength; j++){
                                cell.setCoordinateX(randomW);
                                cell.setCoordinateY(randomH);
                                randomH = randomH + 1;}
                        } else {
                                System.out.println("false");
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
            }
        }
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
        units.forEach(System.out::print);
    }


}








