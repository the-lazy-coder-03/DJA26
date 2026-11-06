public class BSTFixed {

    static class Node {
        String name;
        Node left;
        Node right;

        Node(String name) {
            this.name = name;
        }
    }

    Node root;

    void insert(String name) {
        root = insertNode(root, name);
    }

    Node insertNode(Node current, String name) {
        if (current == null) {
            return new Node(name);
        }

        if (name.compareTo(current.name) < 0) {
            current.left = insertNode(current.left, name);
        } else if (name.compareTo(current.name) > 0) {
            current.right = insertNode(current.right, name);
        }

        return current;
    }

    boolean search(String name) {
        return searchNode(root, name);
    }

    boolean searchNode(Node current, String name) {
        if (current == null) {
            return false;
        }

        if (current.name.equals(name)) {
            return true;
        }

        if (name.compareTo(current.name) < 0) {
            return searchNode(current.left, name);
        } else {
            return searchNode(current.right, name);
        }
    }

    void printClients(Node current) {
        if (current != null) {
            printClients(current.left);
            System.out.println(current.name);
            printClients(current.right);
        }
    }

    public static void main(String[] args) {

        BSTFixed clients = new BSTFixed();

        String searchClient = "B";

        if (clients.root == null) {
            System.out.println("Error: Client index is empty!");
        } else if (clients.search(searchClient)) {
            System.out.println("Client found: " + searchClient);
        } else {
            System.out.println("Client not found.");
        }

        clients.insert("D");
        clients.insert("B");
        clients.insert("C");
        clients.insert("A");

        if (clients.search(searchClient)) {
            System.out.println("Client found: " + searchClient);
        } else {
            System.out.println("Client not found.");
        }

        System.out.println("Client List:");
        clients.printClients(clients.root);
    }
}
