import java.util.*;

class Validation {
    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static Node buildTree() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the root node value: ");
            int value = sc.nextInt();
            Node root = new Node(value);

            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node current = q.poll();

                System.out.print("Enter left child of " + current.data + " (-1 for no child): ");
                value = sc.nextInt();
                if (value != -1) {
                    current.left = new Node(value);
                    q.add(current.left);
                }

                System.out.print("Enter right child of " + current.data + " (-1 for no child): ");
                value = sc.nextInt();
                if (value != -1) {
                    current.right = new Node(value);
                    q.add(current.right);
                }
            }

            return root;
        }
    }

    static boolean inorderTraversal(Node root, int[] prevValue) {
        if (root == null) {
            return true;
        }

        if (!inorderTraversal(root.left, prevValue)) {
            return false;
        }

        if (root.data <= prevValue[0]) {
            return false;
        }

        prevValue[0] = root.data;

        return inorderTraversal(root.right, prevValue);
    }

    static boolean isBST(Node root) {
        int[] prevValue = new int[]{Integer.MIN_VALUE};
        return inorderTraversal(root, prevValue);
    }

    public static void main(String[] args) {
        Node root = buildTree();

        if (isBST(root)) {
            System.out.println("The tree is a valid Binary Search Tree (BST).");
        } else {
            System.out.println("The tree is NOT a valid Binary Search Tree (BST).");
        }
    }
}
