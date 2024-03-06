package e2.model;

public enum GridConstants {
    SIZE(7),
    BOMBS_NUMBER(10);

    private final int value;

    private GridConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
