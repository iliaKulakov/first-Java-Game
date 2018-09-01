package io.github.maventest.unit;

import static io.github.maventest.unit.Iunit.sizeOfShips.singleDeckShip;

public class ship extends unit implements Iunit {

    ship(){
    super.life = life;
   // super.shipSize = shipSize;
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

    //placeShipOnBoard(int shipSize,int life){
    //placeShipOnBoard(){

        enum sizeOfShips {

            singleDeckShip {
                int  life = 1;
                int  numOfHits =0;

                public static int getLife() {
                    return this.life;
                }

                public int getNumOfHits() {
                    return this.numOfHits;
                }
            }

            //twoDeckShip,
            //threeDeckShip,
            //fourDeckShip

        }

  //  }

    public static void main (String[] args){


        System.out.println(sizeOfShips.singleDeckShip);
    }


}
