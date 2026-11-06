import java.util.HashMap;

public class RiverTrackClients {

    static class Client {
        int id;
        String name;
        int deliveries;

        Client(int id, String name) {
            this.id = id;
            this.name = name;
            this.deliveries = 0;
        }
    }

    static class ClientHashTable {
        HashMap<String, Client> clients = new HashMap<>();
        int nextId = 1;

        void addClient(String name) {
            if (!clients.containsKey(name)) {
                Client client = new Client(nextId, name);
                clients.put(name, client);
                nextId = nextId + 1;
            }
        }

        boolean findClient(String name) {
            return clients.containsKey(name);
        }

        void recordDelivery(String name) {
            Client client = clients.get(name);

            if (client != null) {
                client.deliveries = client.deliveries + 1;
            } else {
                System.out.println("Client not found: " + name);
            }
        }

        void showDeliveries(String name) {
            Client client = clients.get(name);

            if (client != null) {
                System.out.println(name + ": "
                        + client.deliveries + " deliveries");
            } else {
                System.out.println("Client not found: " + name);
            }
        }
    }

    public static void main(String[] args) {

        ClientHashTable hashTable = new ClientHashTable();

        String[] companies = {
                "A", "B", "C", "D", "E", "F", "G", "H"};

        for (int i = 0; i < companies.length; i++) {
            String company = companies[i];
            hashTable.addClient(company);
        }

        hashTable.recordDelivery("A");
        hashTable.recordDelivery("A");
        hashTable.recordDelivery("B");
        hashTable.recordDelivery("C");

        hashTable.showDeliveries("A");
        hashTable.showDeliveries("B");
        hashTable.showDeliveries("C");
        hashTable.showDeliveries("D");
        hashTable.showDeliveries("Z");
    }
}
