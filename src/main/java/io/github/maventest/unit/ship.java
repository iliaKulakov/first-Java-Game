package io.github.maventest.unit;

public class ship extends unit implements Iunit {

    ship(){
    super.life = life;
    super.shipSize = shipSize;
    super.hit = hit;
    super.numOfHits = numOfHits;
    }

    public boolean getIsAlive() {
        if ((this.life - this.numOfHits) == 0) {
            this.isAlive = false;
        }
        return this.isAlive;
    }

    void addHits() {
        this.numOfHits += 1;
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
