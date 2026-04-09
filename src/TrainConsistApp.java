import java.util.*;
import java.util.stream.Collectors;
import java.util.regex.*;

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
class GoodsBogie {
    String type;
    String cargo;
    GoodsBogie(String type, String cargo) {
        this.type = type;
        this.cargo = cargo;
    }
    public String toString() {
        return type + " -> " + cargo;
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
        System.out.println("\n=== UC3: HashSet ===");
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B1");
        System.out.println("Unique IDs: " + bogieIDs);

        // ===== UC4 =====
        System.out.println("\n=== UC4: LinkedList ===");
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");
        train.add(2, "Pantry Car");
        train.removeFirst();
        train.removeLast();
        System.out.println("Train: " + train);

        // ===== UC5 =====
        System.out.println("\n=== UC5: LinkedHashSet ===");
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");
        System.out.println("Formation: " + formation);

        // ===== UC6 =====
        System.out.println("\n=== UC6: HashMap ===");
        HashMap<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);
        capacityMap.forEach((k, v) -> System.out.println(k + " -> " + v));

        // ===== UC7 =====
        System.out.println("\n=== UC7: Sorting ===");
        List<Bogie> bogieList = new ArrayList<>();
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));
        bogieList.forEach(System.out::println);

        // ===== UC8 =====
        System.out.println("\n=== UC8: Filter ===");
        List<Bogie> filtered = bogieList.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        filtered.forEach(System.out::println);

        // ===== UC9 =====
        System.out.println("\n=== UC9: Grouping ===");
        Map<String, List<Bogie>> grouped = bogieList.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        grouped.forEach((k, v) -> System.out.println(k + " -> " + v));

        // ===== UC10 =====
        System.out.println("\n=== UC10: Total Capacity ===");
        int total = bogieList.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);
        System.out.println("Total Capacity: " + total);

        // ===== UC11: Regex Validation =====
        System.out.println("\n=== UC11: Regex Validation ===");

        String trainID = "TRN-1234";      // change to test
        String cargoCode = "PET-AB";      // change to test

        // Define regex
        Pattern trainPattern = Pattern.compile("TRN-\\d{4}");
        Pattern cargoPattern = Pattern.compile("PET-[A-Z]{2}");

        // Match input
        Matcher trainMatcher = trainPattern.matcher(trainID);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // Validate
        if (trainMatcher.matches()) {
            System.out.println("Valid Train ID: " + trainID);
        } else {
            System.out.println("Invalid Train ID: " + trainID);
        }

        if (cargoMatcher.matches()) {
            System.out.println("Valid Cargo Code: " + cargoCode);
        } else {
            System.out.println("Invalid Cargo Code: " + cargoCode);
        }
        // ===== UC12: Safety Validation =====
        System.out.println("\n=== UC12: Safety Validation ===");
        List<GoodsBogie> goodsList = new ArrayList<>();
        goodsList.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsList.add(new GoodsBogie("Box", "Coal"));
        goodsList.add(new GoodsBogie("Flat", "Steel"));
        // Rule:
        // Cylindrical → only Petroleum allowed
        boolean isSafe = goodsList.stream()
                .allMatch(b ->
                        (b.type.equals("Cylindrical") && b.cargo.equals("Petroleum"))
                                || (!b.type.equals("Cylindrical"))
                );
        // Display result
        goodsList.forEach(System.out::println);
        if (isSafe) {
            System.out.println("Train is SAFETY COMPLIANT ✅");
        } else {
            System.out.println("Train is NOT SAFE ❌");
        }
        // ===== UC13 =====
        System.out.println("\n=== UC13: Loop vs Stream Performance Comparison ===");

// Create dataset
        List<Bogie> performanceList = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            performanceList.add(new Bogie("Bogie" + i, i % 100));
        }

// ----- Loop-based filtering -----
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : performanceList) {
            if (b.capacity > 50) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

// ----- Stream-based filtering -----
        long startStream = System.nanoTime();

        List<Bogie> streamResult = performanceList.stream()
                .filter(b -> b.capacity > 50)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

// Output
        System.out.println("Loop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);
        System.out.println("\n=== END OF PROGRAM ===");
    }
}
