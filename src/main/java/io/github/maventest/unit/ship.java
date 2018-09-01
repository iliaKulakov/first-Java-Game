package io.github.maventest.unit;

public class ship extends unit implements Iunit {

    ship(){
    super.life = life;
    super.shipSize = shipSize;

    }

    placeShipOnBoard(int shipSize,int life){

        this.life = life;
        this.shipSize = shipSize;

        if (shipSize<=4||shipSize!=0)
        {

        }else {

        }



    }


}
