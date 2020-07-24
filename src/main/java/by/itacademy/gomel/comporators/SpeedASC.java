package by.itacademy.gomel.comporators;

import by.itacademy.gomel.model.Speed;
import java.util.Comparator;

public class SpeedASC implements Comparator<Speed> {
    @Override
    public int compare(Speed o1, Speed o2) {
        return Double.compare(o1.getInMS(), o2.getInMS());
    }
}
