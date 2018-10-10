package io.github.maventest.model.board;

public interface Board {

    void init();

    void print();

    void placeUnit(String shipType);


//    boolean isOccupied(Ship Boat);

    void shotAtTheEnemyShip();


}
