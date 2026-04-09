import java.util.*;

public class TrainConsistApp {

    public static void main(String[] args) {

        // ===== UC1: Initialization =====
        System.out.println("=== Train Consist Management App ===");

        List<String> trainConsist = new ArrayList<>();
        System.out.println("Initial bogie count: " + trainConsist.size());

        // ===== UC2: List Operations =====
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

        // ===== UC3: Unique Bogie IDs using HashSet =====
        System.out.println("\n--- UC3: Unique Bogie IDs ---");

        Set<String> bogieIDs = new HashSet<>();

        // Adding bogie IDs (with duplicates)
        bogieIDs.add("B1");
        bogieIDs.add("B2");
        bogieIDs.add("B3");
        bogieIDs.add("B1"); // duplicate
        bogieIDs.add("B2"); // duplicate

        System.out.println("Unique Bogie IDs: " + bogieIDs);

        System.out.println("\nProgram continues...");
    }
}