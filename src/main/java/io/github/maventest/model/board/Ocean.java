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
        this.generateCell(shipLength, shipCells, horizontal);

        for (Cell cell : shipCells) {
            boardCells[cell.getCoordinateX()][cell.getCoordinateY()] = 1;
        }

        System.out.println(ship.toString());
        System.out.println(shipCells.toString());


        if (boats.isEmpty()) {
            boats.put(shipCells, ship);
            return;
        }

    }

    private void generateCell(int shipLength, CellSet<Cell> cells, boolean horizontal) throws StackOverflowError {
        int randomW = randomGenerator.nextInt(SIZE_W);
        int randomH = randomGenerator.nextInt(SIZE_H);
            //trying to create iterative realisation
          //  for (int i = 0; i < shipLength; i++) {
           while(shipLength>0){
               Cell cell = new Cell(randomW, randomH);

               if (!isOccupied(cells))
               {
                   if (horizontal) {
                       System.out.println("horizontal ");
                       cell.updateCoordinates(randomH, randomW);
                       randomH++;
                   } else {
                       System.out.println("vertical ");
                       cell.updateCoordinates(randomH, randomW);
                       randomW++;
                   }

               } else
               {continue;}
               shipLength=shipLength-1;
           }



            /*
            if (isOccupied(cells)) {
                this.generateCell(shipLength, cells, horizontal);
            } else {

                if (horizontal) {
                    System.out.println("horizontal ");
                    cell.updateCoordinates(randomH, randomW);
                    randomH++;
                } else {
                    System.out.println("vertical ");
                    cell.updateCoordinates(randomH, randomW);
                    randomW++;
                }
//                TODO: Проверка на горизонтальность
                cells.add(cell);
            }
        //*///}
    }




    private boolean isOccupied(CellSet<Cell> cells) throws StackOverflowError {
        boolean status=false;
        try {
            for (Map.Entry<CellSet<Cell>, Unit> item : boats.entrySet()) {

                try{
                    if (!cells.contains(item.getKey())) {
                    status = true;
                    break;
                }
                } catch ( StackOverflowError t) {
                   // System.out.println("Error: " + t.getMessage());
                  //  t.printStackTrace();
                }
            }
        }//try
        catch (StackOverflowError e){
          //  System.out.println("Error: " + e.getMessage());
           // System.out.println("Error: " + e.getStackTrace());
            throw e;
        }
        return status;
    }


    public void printUnits() {
        //units.forEach(System.out::print);
        for (Unit unit : units) {
            System.out.print(unit);
        }

    }


}








