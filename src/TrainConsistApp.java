import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("\n=== UC1: Initialization ===");
        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ===== UC2 =====
        System.out.println("\n=== UC2: ArrayList Operations ===");
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        System.out.println("After adding: " + trainConsist);

        trainConsist.remove("AC Chair");
        System.out.println("After removal: " + trainConsist);

        System.out.println("Contains Sleeper? " + trainConsist.contains("Sleeper"));

        // ===== UC3 =====
        System.out.println("\n=== UC3: HashSet (Unique IDs) ===");
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B3");
        bogieIDs.add("B1"); // duplicate
        System.out.println("Unique Bogie IDs: " + bogieIDs);

        // ===== UC4 =====
        System.out.println("\n=== UC4: LinkedList Operations ===");
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial train: " + train);

        train.add(2, "Pantry Car");
        System.out.println("After insertion: " + train);

        train.removeFirst();
        train.removeLast();
        System.out.println("After removing first & last: " + train);

        // ===== UC5 =====
        System.out.println("\n=== UC5: LinkedHashSet (Ordered Unique) ===");
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Final Formation: " + formation);

        // ===== UC6 =====
        System.out.println("\n=== UC6: HashMap (Bogie Capacity) ===");
        HashMap<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ===== UC7 =====
        System.out.println("\n=== UC7: Sorting using Comparator ===");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));

        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        // ===== UC8 =====
        System.out.println("\n=== UC8: Stream Filter (capacity > 60) ===");
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        filtered.forEach(System.out::println);

        // ===== UC9 =====
        System.out.println("\n=== UC9: Grouping Bogies ===");
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // ===== UC10 =====
        System.out.println("\n=== UC10: Total Capacity ===");
        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        System.out.println("Total Seating Capacity: " + total);

        System.out.println("\n=== END OF PROGRAM ===");
    }
}