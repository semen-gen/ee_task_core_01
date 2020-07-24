package by.itacademy.gomel.comporators;

import by.itacademy.gomel.model.Speed;
import by.itacademy.gomel.model.Unit;
import java.util.Comparator;


public class SpeedUnitAndValueDESC implements Comparator<Speed> {

    @Override
    public int compare(Speed o1, Speed o2) {
        int unitCompare = Integer.compare(Unit.getByValue(o1.getUnit()).getSORT(), Unit.getByValue(o2.getUnit()).getSORT());
        if (unitCompare == 0) {
            return Double.compare(o2.getValue(), o1.getValue());
        }
        return unitCompare;
    }
}
