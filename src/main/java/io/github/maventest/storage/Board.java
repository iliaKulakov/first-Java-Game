package io.github.maventest.storage;
import io.github.maventest.Cell;

import java.util.Arrays;
import java.util.stream.Stream;


public class Board {

   static Cell[] board = new Cell[3];
   static Cell[][] multiDimensionalBoard= new Cell[3][3];

    public static void main (String[] args){

          // multiDimensionalBoard[0][0]  = new Cell(1,0,false);
          //  multiDimensionalBoard[0][1]  = new Cell(2,1,false);
          ///  multiDimensionalBoard[0][2]  = new Cell(3,2,false);
           // multiDimensionalBoard[1][0]  = new Cell(4,0,false);
           // multiDimensionalBoard[1][1]  = new Cell(5,1,false);
           // multiDimensionalBoard[1][2]  = new Cell(6,2,false);

            for (int i = 0; i<2; i++){
                for (int j = 0; j < 2; j++)
                    multiDimensionalBoard[i][j] = new Cell(1,1,false);
               // multiDimensionalBoard[i][j]
               // System.out.print(multiDimensionalBoard[i][j]);
                System.out.print("\n");
            }
      //   System.out.print(multiDimensionalBoard[i][j]);
       // System.out.print("\n");

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






