package io.github.maventest.model.unit;

public enum FlyType implements UnitType<FlyType> {
    BOMBER("Bomber");

    private String type;

    FlyType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public FlyType valueOf() {
        return null;
    }
}
