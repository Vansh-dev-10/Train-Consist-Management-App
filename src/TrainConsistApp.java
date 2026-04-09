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

        // ===== UC3: HashSet (Unique IDs) =====
        System.out.println("\n--- UC3: Unique Bogie IDs ---");

        Set<String> bogieIDs = new HashSet<>();
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B3");
        bogieIDs.add("B1"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIDs);

        // ===== UC4: LinkedList =====
        System.out.println("\n--- UC4: Train Consist using LinkedList ---");

        LinkedList<String> train = new LinkedList<>();

        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial train: " + train);

        train.add(2, "Pantry Car");
        System.out.println("After adding Pantry Car: " + train);

        train.removeFirst();
        train.removeLast();

        System.out.println("Final train consist: " + train);

        // ===== UC5: LinkedHashSet (Ordered + Unique) =====
        System.out.println("\n--- UC5: Ordered Unique Train Formation ---");

        LinkedHashSet<String> formation = new LinkedHashSet<>();

        // Add bogies
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Add duplicate
        formation.add("Sleeper"); // ignored

        // Display final formation
        System.out.println("Final Train Formation: " + formation);

        System.out.println("\nProgram continues...");
    }
}