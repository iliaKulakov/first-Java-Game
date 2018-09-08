package io.github.maventest;

public class Cell {

    private int coordinateX = 0;
    private int coordinateY = 0;
    private boolean shipInCell= false;

    public Cell(int coordinateX, int coordinateY, boolean shipInCell) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.shipInCell = shipInCell;
    }

    public boolean isShipInCell() {
        return shipInCell;
    }

    public void setShipInCell(boolean shipInCell) {
        this.shipInCell = shipInCell;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                ", shipInCell=" + shipInCell +
                '}';
    }

    public  void showElements(){
        System.out.println(getCoordinateX());
        System.out.println(getCoordinateY());
        System.out.println(isShipInCell());
    }



}
