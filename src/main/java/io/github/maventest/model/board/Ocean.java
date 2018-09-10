package io.github.maventest.model.board;

import io.github.maventest.model.unit.Boat;
import io.github.maventest.model.unit.Ship;
import io.github.maventest.model.unit.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ocean implements Board {
    private final int SIZE_W = 10;
    private final int SIZE_H = 10;
    private final Random randomGenerator = new Random();

    private int cells[][] = new int[SIZE_W][SIZE_H];
    private List<Unit> units = new ArrayList<>();

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
    public void placeUnit() {
        Ship boat = new Boat();

        int randomW = randomGenerator.nextInt(SIZE_W);
        int randomH = randomGenerator.nextInt(SIZE_H);

        Cell cell = new Cell(randomW, randomH);

        boat.setPosition(cell);

        units.add(boat);
    }


   // @Override
   // public boolean isOccupied(int i,int j) {
     //   this.cells[i][j]

       // units.
 //               units.contains()
///
   //     return (this.units[i][j] instanceof Cell);
    //}//


    public boolean isOccupied(Ship boat) {
        if(this.units.contains(boat))
        {  System.out.println("Cells with ships");
            return true;

        }
        else
        {System.out.println("Cells without ships");
            return false;

        }
    }

    public void printUnits() {
        units.forEach(System.out::print);
    }
}
