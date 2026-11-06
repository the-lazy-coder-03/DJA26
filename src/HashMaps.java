import java.util.HashMap;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, String> containers = new HashMap<>();

        containers.put("RP-114982", "Yard A-Slip12");
        containers.put("RP-114983", "Yard B-Slip5");
        containers.put("RP-114984", "Yard C-Slip8");
        containers.put("RP-114985", "Yard A-Slip20");

        String newID = "RP-114982";

        if (containers.containsKey(newID)) {
            System.out.println("Error: Container already exists!");
        } else {
            containers.put(newID, "Yard B - Slot 10");
            System.out.println("Container registered.");
        }

        String searchID = "RP-999999";

        if (containers.containsKey(searchID)) {
            String position = containers.get(searchID);
            System.out.println("Yard Position: " + position);
        } else {
            System.out.println("Error: Container not found!");
        }
    }
}
