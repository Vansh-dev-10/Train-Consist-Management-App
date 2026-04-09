import java.util.*;

class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString for printing
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class TrainConsistApp {

    public static void main(String[] args) {

        // ===== UC1: Initialization =====
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ===== UC2 =====
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");
        trainConsist.remove("AC Chair");

        // ===== UC3 =====
        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B1");

        // ===== UC4 =====
        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");
        train.add(2, "Pantry Car");
        train.removeFirst();
        train.removeLast();

        // ===== UC5 =====
        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        // ===== UC6 =====
        HashMap<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        // ===== UC7: Comparator Sorting =====
        System.out.println("\n--- UC7: Sort Bogies by Capacity ---");

        List<Bogie> bogieList = new ArrayList<>();

        // Add bogie objects
        bogieList.add(new Bogie("Sleeper", 72));
        bogieList.add(new Bogie("AC Chair", 60));
        bogieList.add(new Bogie("First Class", 40));

        // Sort using Comparator + Lambda
        bogieList.sort(Comparator.comparingInt(b -> b.capacity));

        // Display sorted bogies
        for (Bogie b : bogieList) {
            System.out.println(b);
        }

        System.out.println("\nProgram continues...");
    }
}