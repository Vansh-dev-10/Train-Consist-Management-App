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

        // ===== UC4: LinkedList Operations =====
        System.out.println("\n--- UC4: Train Consist using LinkedList ---");

        LinkedList<String> train = new LinkedList<>();

        // Add bogies
        train.add("Engine");
        train.add("Sleeper");
        train.add("AC");
        train.add("Cargo");
        train.add("Guard");

        System.out.println("Initial train: " + train);

        // Insert Pantry Car at position 2
        train.add(2, "Pantry Car");

        System.out.println("After adding Pantry Car: " + train);

        // Remove first and last bogie
        train.removeFirst();
        train.removeLast();

        // Final train
        System.out.println("Final train consist: " + train);

        System.out.println("\nProgram continues...");
    }
}