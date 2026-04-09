import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        // ===== UC1: Initialization =====
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ===== UC2: ArrayList Operations =====
        System.out.println("\n--- UC2: Bogie Operations ---");

        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        System.out.println("Bogies after addition: " + trainConsist);

        trainConsist.remove("AC Chair");

        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists.");
        }

        System.out.println("Final bogie list: " + trainConsist);

        // ===== UC3: HashSet =====
        System.out.println("\n--- UC3: Unique Bogie IDs ---");

        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B3");
        bogieIDs.add("B1");

        System.out.println("Unique Bogie IDs: " + bogieIDs);

        // ===== UC4: LinkedList =====
        System.out.println("\n--- UC4: LinkedList Train ---");

        LinkedList<String> train = new LinkedList<>();
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        train.add(2, "Pantry Car");
        train.removeFirst();
        train.removeLast();

        System.out.println("Final train consist: " + train);

        // ===== UC5: LinkedHashSet =====
        System.out.println("\n--- UC5: Ordered Unique Formation ---");

        LinkedHashSet<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper"); // duplicate

        System.out.println("Final Train Formation: " + formation);

        // ===== UC6: HashMap =====
        System.out.println("\n--- UC6: Bogie Capacity Mapping ---");

        HashMap<String, Integer> capacityMap = new HashMap<>();

        // Add bogie-capacity pairs
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 60);
        capacityMap.put("First Class", 40);

        // Display using entrySet
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> Capacity: " + entry.getValue());
        }

        System.out.println("\nProgram continues...");
    }
}