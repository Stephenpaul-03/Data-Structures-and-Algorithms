import java.util.*;

class Conversion {
    static class Node {
        int data;
        Node left, right;
        Node(int value) {
            data = value;
            left = right = null;
        }
    }

    static void inorderTraversal(Node root, List<Integer> values) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, values);
        values.add(root.data);
        inorderTraversal(root.right, values);
    }

    static void assignInorder(Node root, List<Integer> values, int[] index) {
        if (root == null) {
            return;
        }
        assignInorder(root.left, values, index);
        root.data = values.get(index[0]);
        index[0]++;
        assignInorder(root.right, values, index);
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

    static void convert(Node root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);
        Collections.sort(values);

        int[] index = {0};
        assignInorder(root, values, index);
    }

    static void inorderPrint(Node root) {
        if (root == null) {
            return;
        }
        inorderPrint(root.left);
        System.out.print(root.data + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {
        Node root = buildTree();

        System.out.print("In-order traversal of original tree: ");
        inorderPrint(root);
        System.out.println();

        convert(root);

        System.out.print("In-order traversal of the converted BST: ");
        inorderPrint(root);
        System.out.println();
    }
}
