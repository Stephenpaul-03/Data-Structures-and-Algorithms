import java.util.Scanner;

public class BST_Scratch {

    // Node structure
    static class Node {
        int data;
        Node left, right;

        Node(int value) {
            data = value;
            left = null;
            right = null;
        }
    }

    Node root;

    BST_Scratch() {
        root = null;
    }

    // Insert function
    Node insert(Node root, int value) {
        if (root == null)
            return new Node(value);

        if (value < root.data)
            root.left = insert(root.left, value);
        else if (value > root.data)
            root.right = insert(root.right, value);

        return root;
    }

    // Search function
    boolean search(Node root, int target) {
        if (root == null)
            return false;

        if (root.data == target)
            return true;
        else if (target < root.data)
            return search(root.left, target);
        else
            return search(root.right, target);
    }

    // In-order Traversal
    void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    public static void main(String[] args) {
        BST_Scratch tree = new BST_Scratch();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBinary Search Tree Operations:");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Display In-Order Traversal");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter value to insert: ");
                    int value = scanner.nextInt();
                    tree.root = tree.insert(tree.root, value);
                    System.out.println("Value inserted.");
                }
                case 2 -> {
                    System.out.print("Enter value to search: ");
                    int target = scanner.nextInt();
                    if (tree.search(tree.root, target))
                        System.out.println("Value found in the tree.");
                    else
                        System.out.println("Value not found in the tree.");
                }
                case 3 -> {
                    System.out.println("In-Order Traversal:");
                    tree.inOrder(tree.root);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
