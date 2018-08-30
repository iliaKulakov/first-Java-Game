package io.github.maventest.storage;
import io.github.maventest.Cell;

import java.util.Arrays;


public class Board {

   static Cell[] board = new Cell[3];
   static Cell[][] multiDimensionalBoard= new Cell[3][3];

    public static void main (String[] args){

            multiDimensionalBoard[0][0]  = new Cell(0,0,false);
            multiDimensionalBoard[0][1]  = new Cell(0,1,false);
            multiDimensionalBoard[0][2]  = new Cell(0,2,false);
            multiDimensionalBoard[1][0]  = new Cell(1,0,false);
            multiDimensionalBoard[1][1]  = new Cell(1,1,false);
            multiDimensionalBoard[1][2]  = new Cell(1,2,false);

            for (int i = 0; i<3; i++){
                for (int j = 0; j < 3; j++)

                System.out.print(multiDimensionalBoard[i][j].getCoordinateX());
            }
        System.out.println();


    }






