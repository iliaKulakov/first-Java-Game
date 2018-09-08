package io.github.maventest.unit;

public class mainShip <A,B,C,D> extends unit {

        private   A life;
        private   B hit;
        private   C isAlive;
        private   D numOfHits;

    public mainShip(A a, B b, C c, D d){
        this.life =a;
        this.hit=b;
        this.isAlive=c;
        this.numOfHits=d;

    }

    public A getLife() {
        return life;
    }

    public B getHit() {
        return hit;
    }

    public C getIsAlive() {
        return isAlive;
    }

    public D getNumOfHits() {
        return numOfHits;
    }

    @Override
    public String toString() {
        return "mainShip{" +
                "life=" + life +
                ", hit=" + hit +
                ", isAlive=" + isAlive +
                ", numOfHits=" + numOfHits +
                '}';
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

    public static void main (String[] args){

        mainShip<Integer,Integer,Boolean,Integer> twoSizeShip = new mainShip(2,0,true,20);
        System.out.println(twoSizeShip.toString());
        System.out.println(twoSizeShip.getLife());

    }

}






