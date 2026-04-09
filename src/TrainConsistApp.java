import java.util.ArrayList;
import java.util.List;

public class TrainConsistApp {

    public static void main(String[] args) {

        // ===== UC1: Initialization =====
        System.out.println("=== Train Consist Management App ===");

        // Initialize empty list
        List<String> trainConsist = new ArrayList<>();

        // Display initial bogie count
        System.out.println("Initial bogie count: " + trainConsist.size());

        System.out.println("\n--- UC2: Bogie Operations ---");

        // ===== UC2: Add bogies =====
        trainConsist.add("Sleeper");
        trainConsist.add("AC Chair");
        trainConsist.add("First Class");

        // Display after adding
        System.out.println("Bogies after addition: " + trainConsist);

        // Remove a bogie
        trainConsist.remove("AC Chair");

        // Check existence
        if (trainConsist.contains("Sleeper")) {
            System.out.println("Sleeper bogie exists.");
        } else {
            System.out.println("Sleeper bogie not found.");
        }

        // Final list
        System.out.println("Final bogie list: " + trainConsist);

        System.out.println("\nProgram continues...");
    }
}