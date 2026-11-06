import java.util.HashMap;
import java.util.Scanner;

public class clients {

    static class ClientHashTable {
        HashMap<String, Integer> clients = new HashMap<>();
        int nextId = 1;

        void addClient(String name) {
            if (!clients.containsKey(name)) {
                clients.put(name, nextId);
                nextId = nextId + 1;
            }
        }

        boolean findClient(String name) {
            return clients.containsKey(name);
        }
    }

    static class BST {

        static class Node {
            String name;
            Node left;
            Node right;

            Node(String name) {
                this.name = name;
            }
        }

        Node root;

        void addClient(String name) {
            root = insert(root, name);
        }

        Node insert(Node node, String name) {
            if (node == null) {
                return new Node(name);
            }

            if (name.compareTo(node.name) < 0) {
                node.left = insert(node.left, name);
            } else if (name.compareTo(node.name) > 0) {
                node.right = insert(node.right, name);
            }

            return node;
        }

        boolean findClient(String name) {
            return search(root, name);
        }

        boolean search(Node node, String name) {
            if (node == null) {
                return false;
            }

            if (node.name.equals(name)) {
                return true;
            }

            if (name.compareTo(node.name) < 0) {
                return search(node.left, name);
            }

            return search(node.right, name);
        }

        void printAlphabetical() {
            inOrder(root);
        }

        void inOrder(Node node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);
            System.out.println(node.name);
            inOrder(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClientHashTable hashTable = new ClientHashTable();
        BST bst = new BST();

        String[] companies = {
                "A", "E", "F", "G", "H", "B", "C", "D"
        };

        for (int i = 0; i < companies.length; i++) {
            String company = companies[i];
            hashTable.addClient(company);
            bst.addClient(company);
        }

        while (true) {
            System.out.println("\n1. Add Company");
            System.out.println("2. Find Company");
            System.out.println("3. Display Companies Alphabetically");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                System.out.print("Enter company name: ");
                String name = scanner.nextLine().trim();

                hashTable.addClient(name);
                bst.addClient(name);

                System.out.println("Company added: " + name);

            } else if (option == 2) {
                System.out.print("Enter company to find: ");
                String name = scanner.nextLine().trim();

                System.out.println("Hash Table: "
                        + hashTable.findClient(name));
                System.out.println("BST: "
                        + bst.findClient(name));

            } else if (option == 3) {
                System.out.println("Companies in alphabetical order:");
                bst.printAlphabetical();

            } else if (option == 4) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
