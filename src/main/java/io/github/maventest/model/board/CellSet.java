package io.github.maventest.model.board;

import java.util.HashSet;

public class CellSet<Cell> extends HashSet<Cell> {

    @Override
    public boolean contains(Object o) {
        for (Cell cell : this) {
            if (cell.hashCode() == o.hashCode()) {
                return true;
            }
        }
        return false;
    }
}
