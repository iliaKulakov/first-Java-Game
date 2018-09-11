package io.github.maventest.model.board;

import java.util.Objects;

public final class Cell implements Comparable {
    private final int coordinateX;
    private final int coordinateY;

    public Cell(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
    }

    public int getCoordinateX() {
        return coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return getCoordinateX() == cell.getCoordinateX() &&
                getCoordinateY() == cell.getCoordinateY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCoordinateX(), getCoordinateY());
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinateX=" + coordinateX +
                ", coordinateY=" + coordinateY +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        if (o == null || getClass() != o.getClass()) return 1;
        Cell cell = (Cell) o;
        int result = getCoordinateX() == cell.getCoordinateX() &&
                getCoordinateY() == cell.getCoordinateY() ? 0 : 1;

        return result;
    }
}
