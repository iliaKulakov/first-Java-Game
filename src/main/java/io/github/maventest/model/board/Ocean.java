package io.github.maventest.model.board;

import io.github.maventest.factory.ShipFactory;
import io.github.maventest.model.unit.Boat;
import io.github.maventest.model.unit.Ship;
import io.github.maventest.model.unit.TwoDeckShip;
import io.github.maventest.model.unit.Unit;
import java.util.*;

public class Ocean implements Board {
    private final int SIZE_W = 10;
    private final int SIZE_H = 10;
    private final Random randomGenerator = new Random();
    private int cells[][] = new int[SIZE_W][SIZE_H];
    private List<Unit> units = new ArrayList<>();
    private Map<CellSet<Cell>, Unit> boats = new HashMap<>();
    private final ShipFactory shipFactory;

    public Ocean(){
        shipFactory = ShipFactory.getInstance();
    }

    @Override
    public void init() {

        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                cells[i][j] = 0;
            }
        }
    }

    @Override
    public void print() {
        for (int i = 0; i < SIZE_H; i++) {
            for (int j = 0; j < SIZE_W; j++) {
                System.out.print(cells[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }

    @Override
    public void placeUnit(String shipType) {

        Ship ship = this.shipFactory.getShip(shipType);

        int shipLength = ship.getSize();
       // boolean horizontal = ship.getIsHorizontal();
       // boolean horizontal = randomGenerator.nextBoolean();
        boolean horizontal = false;
        int randomW = randomGenerator.nextInt(SIZE_W);
        int randomH = randomGenerator.nextInt(SIZE_H);
        CellSet<Cell> cells = new CellSet<>();

        for (int i = 0; i < shipLength; i++) {
            /* problem with if - else workin only for Y
            */
             */
            if (horizontal) {
            Cell cell = new Cell(randomW, randomH+1);
                cells.add(cell);
                ship.setPosition(cell);
            } else {
            Cell cell = new Cell(randomW+1, randomH);
                cells.add(cell);
                ship.setPosition(cell);
            }
        }

        System.out.println(ship.toString());

        if (boats.isEmpty()) {
            boats.put(cells,ship);
            return;
        }

        for (Map.Entry<CellSet<Cell>, Unit> item : boats.entrySet()) {
            if (cells.contains(item.getKey())) {
                System.out.println("Cells without ships");
                boats.put(cells, ship);
            } else {
                System.out.println("Cells with ships. Need to repeat place unit again");
            }
        }

    }

    public boolean isOccupied(Ship Boat) {
        if (this.units.contains(Boat)) {
            System.out.println("Cells with ships");
            return true;

        } else {
            System.out.println("Cells without ships");
            return false;

        }
    }

    public void printUnits() {
        units.forEach(System.out::print);
    }


}








