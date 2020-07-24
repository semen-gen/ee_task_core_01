package by.itacademy.gomel;

import by.itacademy.gomel.comporators.SpeedASC;
import by.itacademy.gomel.comporators.SpeedUnitAndValueDESC;
import by.itacademy.gomel.model.Speed;

import java.io.*;
import java.util.*;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Speed> collection = new ArrayList<>();

    public static void main(String[] args) {
        getFileCollection();
        printCollectionInMS();
        printSortCollection(new SpeedASC());
        printIsInCollectionValue(2.0, "kmh");
        printSortCollection(new SpeedUnitAndValueDESC());
    }

    private static void printIsInCollectionValue(double value, String unit) {
        System.out.println(collection.stream().anyMatch(s -> s.getValue() == value && s.getUnit().equals(unit)) ? "yes" : "no");
        System.out.println();
    }

    private static void printSortCollection(Comparator<Speed> comparator) {
        collection.sort(comparator);
        printCollection();
    }

    private static void printCollection() {
        for (Speed item : collection) {
            System.out.println(item);
        }
        System.out.println();
    }

    private static void printCollectionInMS() {
        for (Speed item : collection) {
            System.out.println(item + " = " + item.InMS());
        }
        System.out.println();
    }

    private static String getFileName() {
        String name = scanner.nextLine();
        scanner.close();
        return name;
    }

    private static File getFile() {
        return new File("src/main/resources/files/" + getFileName());
    }

    private static List<Speed> getFileCollection() {
        File file = getFile();
        try (FileReader fr = new FileReader(file)) {
            BufferedReader reader = new BufferedReader(fr);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("\\s+", 2);
                collection.add(new Speed(new Double(arr[0]), arr[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collection;
    }
}
