package by.itacademy.gomel.model;

import java.util.Arrays;

public enum Unit {
    MS("ms", 4),
    KMH("kmh", 1),
    MPH("mph", 2),
    KN("kn", 3);

    private final String VAL;
    private final int SORT;

    Unit(String unit, int sort) {
        VAL = unit;
        SORT = sort;
    }

    public String getVAL() {
        return VAL;
    }

    public int getSORT() {
        return SORT;
    }

    public static Unit getByValue(String unit) {
        return Arrays.stream(values()).filter(e -> e.getVAL().equals(unit)).findFirst().get();
    }
}
