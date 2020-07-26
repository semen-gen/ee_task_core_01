package by.itacademy.gomel;

import by.itacademy.gomel.comporators.SpeedASC;
import by.itacademy.gomel.comporators.SpeedUnitAndValueDESC;
import by.itacademy.gomel.servicese.Service;
import java.io.IOException;

public class App {

  public static void main(String[] args) {
    try {
      Service service = new Service(args[0]);
      service.printCollectionInMS();
      service.printSortCollection(new SpeedASC());
      service.printIsInCollectionValue(2.0, "kmh");
      service.printSortCollection(new SpeedUnitAndValueDESC());
    } catch (IOException e) {
      System.out.println("Такого файла " + e.getMessage() + " не существует!");
    } catch (Exception ignored) {

    }
  }
}
