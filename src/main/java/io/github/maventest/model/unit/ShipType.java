package io.github.maventest.model.unit;

public enum ShipType implements UnitType<ShipType> {
    Boat("Boat"),
    Karas("Karas"),
    Bomber("Bomber"),
    TwoDeckShip("TwoDeckShip");

    private String type;

    ShipType(String type) {
        this.type = type;
    }

    public ShipType valueOf() {
        return valueOf(name());
    }

    public String getType() {
        return this.type;
    }
}
