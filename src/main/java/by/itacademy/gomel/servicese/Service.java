package by.itacademy.gomel.servicese;

import by.itacademy.gomel.model.Speed;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Service {

  protected File file;
  private final List<Speed> COLLECTION;

  {
    COLLECTION = new ArrayList<>();
  }

  public Service(String fileName) throws IOException {
    file = new File("src/main/resources/files/" + fileName);
    getFileCollection();
  }

  public void printIsInCollectionValue(double value, String unit) {
    System.out.println(
        COLLECTION.stream()
            .anyMatch(s -> s.getValue() == value && s.getUnit().equals(unit)) ? "yes" : "no");
    System.out.println();
  }

  public void printSortCollection(Comparator<Speed> comparator) {
    COLLECTION.sort(comparator);
    printCollection();
  }

  private void printCollection() {
    for (Speed item : COLLECTION) {
      System.out.println(item);
    }
    System.out.println();
  }

  public void printCollectionInMS() {
    for (Speed item : COLLECTION) {
      System.out.println(item + " = " + item.InMS());
    }
    System.out.println();
  }

  private void getFileCollection() throws IOException {
    Files.lines(file.toPath())
        .map(l -> l.split("\\s+", 2))
        .forEach(arr -> COLLECTION.add(new Speed(new Double(arr[0]), arr[1])));
  }
}
