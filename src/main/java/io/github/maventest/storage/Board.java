package io.github.maventest.storage;
import io.github.maventest.Cell;


public class Board {

   public  static Cell[][] multiDimensionalBoard= new Cell[3][3];

    public static void main (String[] args) throws Exception{

            multiDimensionalBoard[0][0]  = new Cell(0,0,true);
            multiDimensionalBoard[0][1]  = new Cell(0,1,false);
            multiDimensionalBoard[0][2]  = new Cell(0,2,false);
            multiDimensionalBoard[1][0]  = new Cell(1,0,false);
            multiDimensionalBoard[1][1]  = new Cell(1,1,false);
            multiDimensionalBoard[1][2]  = new Cell(1,2,false);
            multiDimensionalBoard[2][0]  = new Cell(2,0,false);
            multiDimensionalBoard[2][1]  = new Cell(2,1,false);
            multiDimensionalBoard[2][2]  = new Cell(2,2,false);

            for (int i = 0; i<=multiDimensionalBoard.length-1; i++){
                for (int j = 0; j <= multiDimensionalBoard.length-1; j++)
                System.out.println(multiDimensionalBoard[i][j].toString());
                System.out.print("\n");

            }

            multiDimensionalBoard[0][0] = new Cell(0,0,true);
            System.out.println(multiDimensionalBoard[0][0].get2SizeShip().toString());


    /*    int n =3;
                int mas[][];
        mas=new int [3][3];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++)
                System.out.print(mas[i][j] + "\t");
            System.out.println('\n');
}*/

}}






