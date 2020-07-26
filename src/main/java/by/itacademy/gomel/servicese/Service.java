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
  private List<Speed> collection;

  public Service(String fileName) throws IOException {
    file = new File("src/main/resources/files/" + fileName);
    collection = getFileCollection();
  }

  public void printIsInCollectionValue(double value, String unit) {
    System.out.println(
        collection.stream()
            .anyMatch(s -> s.getValue() == value && s.getUnit().equals(unit)) ? "yes" : "no");
    System.out.println();
  }

  public void printSortCollection(Comparator<Speed> comparator) {
    collection.sort(comparator);
    printCollection();
  }

  private void printCollection() {
    for (Speed item : collection) {
      System.out.println(item);
    }
    System.out.println();
  }

  public void printCollectionInMS() {
    for (Speed item : collection) {
      System.out.println(item + " = " + item.InMS());
    }
    System.out.println();
  }

  public List<Speed> getFileCollection() throws IOException {
    List<Speed> collection = new ArrayList<>();

    Files.lines(file.toPath())
        .map(l -> l.split("\\s+", 2))
        .forEach(arr -> collection.add(new Speed(new Double(arr[0]), arr[1])));

    return collection;
  }
}
