package model;

public enum Coin {
    TWO_RUPEE(2),
    FIVE_RUPEE(5),
    TEN_RUPEE(10);

    private int value;

    private Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
