package com.company.ships.types;

public enum Size {
    SMALL(10),MEDIUM(50), LARGE(100);

    private int value;
    Size(int value) {
        this.value=value;
    }

    public int getValue(){
        return value;
    }
}
