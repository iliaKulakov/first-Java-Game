package io.github.maventest.model.board;

import io.github.maventest.factory.ShipFactory;
import io.github.maventest.model.ShipPrinter;
import io.github.maventest.model.unit.Ship;
import io.github.maventest.model.unit.Unit;

import java.util.*;

public class Ocean implements Board {
    private final int SIZE_W = 10;
    private final int SIZE_H = 10;
    private static final int BOAT = 4;
    private static final int TWO_DECK_SHIP = 3;
    private static final int KARAS = 2;
    private static final int BOMBER = 1;
    private final Random randomGenerator = new Random();
    private final ShipFactory shipFactory;
    private int boardCells[][] = new int[SIZE_W][SIZE_H];
    private List<Unit> units = new ArrayList<>();
    private Map<CellSet<Cell>, Unit> boats = new HashMap<>();
    private CellSet<Cell> occupiedCells = new CellSet<>();
    private final ShipPrinter PRINTER = new ShipPrinter();

    public Ocean() {
        shipFactory = ShipFactory.getInstance();
    }

    public void buildAllShips(){
        for (int i = 0; i < BOAT; i++) {
            placeUnit("Boat");

        }
        for (int i = 0; i < TWO_DECK_SHIP; i++) {
            placeUnit("TwoDeckShip");

        }
        for (int i = 0; i < KARAS; i++) {
            placeUnit("Karas");

        }
        for (int i = 0; i < BOMBER; i++) {
            placeUnit("Bomber");

        }
    }

    @Override
    public void init() {

        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                boardCells[i][j] = 0;
            }
        }
        buildAllShips();
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

                boardCells[cell.getCoordinateX()][cell.getCoordinateY()] = shipLength;

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }

        ship.setPosition(horizontal, shipCells.toArray(new Cell[shipCells.size()]));

        occupiedCells.addAll(shipCells);
        boats.put(shipCells, ship);
        PRINTER.printShip(ship);

    }

    private CellSet<Cell> generateCell(int shipLength, boolean horizontal) {

        CellSet<Cell> cells = new CellSet<>();

        CellSet<Cell> localCells = getRandomCells(shipLength, horizontal, cells);

        if (isOccupied(localCells) && isOccupiedCells(localCells)) {
            generateCell(shipLength, horizontal);
        }

        return localCells;
    }

    private CellSet<Cell> getRandomCells(int shipLength, boolean horizontal, CellSet<Cell> cells) throws ArrayIndexOutOfBoundsException {

        int randomW = randomGenerator.nextInt(SIZE_W - 1);
        int randomH = randomGenerator.nextInt(SIZE_H - 1);

        if (okPlaceToShip(randomW, randomH, shipLength, horizontal)) {
            for (int i = 0; i < shipLength; i++) {

                Cell cell = new Cell(randomW, randomH);

                if (horizontal) {
//                    System.out.println("horizontal ");
                    cell.updateCoordinates(randomW, randomH);

                    randomW++;

                } else {
//                    System.out.println("vertical ");
                    cell.updateCoordinates(randomW, randomH);

                    randomH++;
                }
                cells.add(cell);
            }//for
            //return cells;
        } else {
            getRandomCells(shipLength, horizontal, cells);

        }
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

    private boolean isOccupiedCells(CellSet<Cell> cells) {
        boolean status = false;
        if (occupiedCells.contains(cells)) {
            status = true;
        }
        return status;
    }


    public void printUnits() {
        for (Unit unit : units) {
            System.out.print(unit);
        }
    }

    private boolean okPlaceToShip(int randomW, int randomH, int shipLength, boolean horizontal) {
        int H = randomH;
        int W = randomW;
        int shipLengthVar = shipLength;
        boolean horizontalVar = horizontal;

        if (horizontal) {
            if (W <= shipLengthVar) {
                return true;
            } else {
                return false;
            }

        } else if (H <= shipLengthVar) {
            return true;
        } else {
            return false;
        }
    }
}








