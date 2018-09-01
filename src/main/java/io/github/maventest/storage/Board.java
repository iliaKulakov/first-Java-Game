package io.github.maventest.storage;
import io.github.maventest.Cell;

import java.util.Arrays;
import java.util.stream.Stream;


public class Board {

   static Cell[][] multiDimensionalBoard= new Cell[3][3];

    public static void main (String[] args) throws Exception{

            multiDimensionalBoard[0][0]  = new Cell(0,0,true);
            multiDimensionalBoard[0][1]  = new Cell(2,1,true);
            multiDimensionalBoard[0][2]  = new Cell(3,2,true);
            multiDimensionalBoard[1][0]  = new Cell(4,0,true);
            multiDimensionalBoard[1][1]  = new Cell(5,1,true);
            multiDimensionalBoard[1][2]  = new Cell(6,2,true);

            for (int i = 0; i<=multiDimensionalBoard.length-1; i++){
                for (int j = 0; j <= multiDimensionalBoard.length-1; j++)


                System.out.println(multiDimensionalBoard[i][j].toString());
                System.out.print("\n");
            }


         int[][] massiv = new int[3][3];

        massiv[0][0] = 1;
        massiv[0][1] = 2;
        massiv[1][0] = 1;
        massiv[1][1] = 2;
        //massiv[0][0] =
        //massiv[0][0] =
        //massiv[0][0] =

        for (int i = 0; i<massiv.length; i++) {
            for (int j = 0; j < massiv.length; j++)


                System.out.print(massiv[i][j]);
           // System.out.print("\n");
        }



     //   final Stream<String> streamFromArrays = Arrays.stream(massiv);
       // streamFromArrays.forEach(()-> {
         //   return System.out.print("test");
       // });




}}






