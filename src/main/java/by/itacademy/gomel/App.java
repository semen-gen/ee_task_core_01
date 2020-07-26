package by.itacademy.gomel;

import by.itacademy.gomel.comporators.SpeedASC;
import by.itacademy.gomel.comporators.SpeedUnitAndValueDESC;
import by.itacademy.gomel.servicese.Service;

public class App {

  public static void main(String[] args) {
    Service service = new Service(args[0]);
    service.printCollectionInMS();
    service.printSortCollection(new SpeedASC());
    service.printIsInCollectionValue(2.0, "kmh");
    service.printSortCollection(new SpeedUnitAndValueDESC());
  }
}
