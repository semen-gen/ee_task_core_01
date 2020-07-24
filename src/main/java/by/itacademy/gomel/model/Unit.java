package by.itacademy.gomel.model;

import java.lang.reflect.Array;
import java.util.Arrays;

public enum Unit {
    MS("ms"),
    KMH("kmh"),
    MPH("mph"),
    KN("kn");

    private final String VAL;

    Unit(String unit) {
        VAL = unit;
    }

    public String getVAL() {
        return VAL;
    }

    public static Unit getByValue(String unit) {
        return Arrays.stream(values()).filter(e -> e.getVAL().equals(unit)).findFirst().get();
    }
}
