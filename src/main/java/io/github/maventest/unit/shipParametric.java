package io.github.maventest.unit;

public class  shipParametric <T>  extends unit implements Iunit {

    enum sizeOfShips {
        singleDeckShip, twoDeckShip, threeDeckShip, fourDeckShip
    }

    shipParametric(T t)
        {
        System.out.println("test");
        }

    public static void main (String[] args){


        shipParametric<sizeOfShips> shipParametric =
                new shipParametric<sizeOfShips>(sizeOfShips.singleDeckShip)

        }

}
