package io.github.maventest.model.unit;

import io.github.maventest.model.board.Cell;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bomber implements Ship {
    private int lifeBomber = 5;
    private boolean isAlive = true;
    int size = 5;
    private List<Cell> cellsArray = new ArrayList<>();
    private boolean isHorizontal = true;


    @Override
    public void toRegisterTheShot() {
        this.lifeBomber = lifeBomber - 1;
    }

    @Override
    public boolean checkIsAlive(){
        if(this.lifeBomber>0){
            this.isAlive=true;
        }else{
            this.isAlive=false;
        }
        return isAlive;
    }


    @Override
    public boolean getIsHorizontal() {
        return isHorizontal;
    }

    @Override
    public String getShipType() {
        return "Bomber";
    }

    @Override
    public void setPosition(Boolean horizontal, Cell... cells) {
        this.isHorizontal = horizontal;
        this.cellsArray.addAll(Arrays.asList(cells));
    }

    @Override
    public List<Cell> getCells() {
        return this.cellsArray;
    }

    @Override
    public boolean shot() {
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String cells = cellsArray.stream().map(e -> e.toString()).reduce(" ", String::concat);
        return "Bomber{" +
                "size=" + size +
                ", cellsArray=" + cells +
                ", isHorizontal=" + isHorizontal +
                '}';
    }
}
