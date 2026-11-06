import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> containers = new HashMap<>();

        containers.put("RP-114982", "Yard A-Slip12");
        containers.put("RP-114983", "Yard B-Slip5");
        containers.put("RP-114984", "Yard C-Slip8");
        containers.put("RP-114985", "Yard A-Slip20");

        String search = "RP-114982";

        if (containers.containsKey(search)) {
            String position = containers.get(search);
            System.out.println("Container ID: " + search);
            System.out.println("Yard Position: " + position);
        } else {
            System.out.println("Container not found.");
        }
    }
}
