package io.github.maventest.model.board;

import io.github.maventest.factory.ShipFactory;
import io.github.maventest.model.ShipPrinter;
import io.github.maventest.model.unit.Ship;
import io.github.maventest.model.unit.ShipType;
import io.github.maventest.model.unit.Unit;
import io.github.maventest.model.unit.UnitType;

import java.util.*;

public class Ocean implements Board {
    private static final int BOAT = 4;
    private static final int TWO_DECK_SHIP = 3;
    private static final int KARAS = 2;
    private static final int BOMBER = 1;
    private static final int TOTAL_SHIPS = 10;
    private final int SIZE_W = 10;
    private final int SIZE_H = 10;
    private final Random randomGenerator = new Random();
    private final ShipFactory shipFactory;
    private final ShipPrinter PRINTER = new ShipPrinter();
    private int shipsDestroyed = 0;
    private int[][] boardCells = new int[SIZE_W][SIZE_H];
    private List<Unit> units = new ArrayList<>();
    private Map<CellSet<Cell>, Unit> boats = new HashMap<>();
    private CellSet<Cell> occupiedCells = new CellSet<>();

    public Ocean() {
        shipFactory = ShipFactory.getInstance();
    }

    public void setShipsDestroyed(int newShipsDestroyed) {
        shipsDestroyed = shipsDestroyed + newShipsDestroyed;
    }

    private void createShip(int shipCount, UnitType<ShipType> shipType) {
        for (int i = 0; i < shipCount; i++) {
            placeUnit(shipType);
        }
    }

    public void buildAllShips() {
        createShip(BOAT, ShipType.Boat);
        createShip(TWO_DECK_SHIP, ShipType.TwoDeckShip);
        createShip(KARAS, ShipType.Karas);
        createShip(BOMBER, ShipType.Bomber);
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

    public void printUnits() {
        for (Unit unit : units) {
            System.out.print(unit);
        }
    }

    @Override
    public void placeUnit(UnitType unitType) throws ArrayIndexOutOfBoundsException {

        Ship ship = this.shipFactory.getShip(unitType);
        boolean horizontal = randomGenerator.nextBoolean();
        int shipLength = ship.getSize();
        new CellSet<>();
        CellSet<Cell> shipCells;
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
                    cell.updateCoordinates(randomW, randomH);

                    randomW++;

                } else {

                    cell.updateCoordinates(randomW, randomH);

                    randomH++;
                }
                cells.add(cell);
            }
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

    private boolean okPlaceToShip(int randomW, int randomH, int shipLength, boolean horizontal) {
        int H = randomH;
        int W = randomW;
        int shipLengthVar = shipLength;

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

    @Override
    public void shotAtTheEnemyShip(int weight, int height) {

        if (this.boardCells[weight][height] != 0) {
            Cell cellVar = new Cell(weight, height);
            for (Map.Entry<CellSet<Cell>, Unit> item : boats.entrySet()) {

                if (item.getKey().contains(cellVar)) {
                    item.getValue().toRegisterTheShot();
                    if (!item.getValue().checkIsAlive()) {
                        shipsDestroyed = shipsDestroyed + 1;
                    }
                    boardCells[weight][height] = 99;
                }
            }
        }
    }

    public boolean isGameOver() {
        return (this.shipsDestroyed == TOTAL_SHIPS);

    }

}








