import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}

class BST_Views {

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(Node root) {
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            if (!hdMap.containsKey(pair.hd)) {
                hdMap.put(pair.hd, pair.node.data);
            }
            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.hd - 1));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.hd + 1));
            }
        }
        return new ArrayList<>(hdMap.values());
    }

    public static List<Integer> bottomView(Node root) {
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            hdMap.put(pair.hd, pair.node.data);
            if (pair.node.left != null) {
                queue.add(new Pair(pair.node.left, pair.hd - 1));
            }
            if (pair.node.right != null) {
                queue.add(new Pair(pair.node.right, pair.hd + 1));
            }
        }
        return new ArrayList<>(hdMap.values());
    }

    public static List<Integer> leftView(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(queue.peek().data);
            for (int i = 0, n = queue.size(); i < n; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            result.add(queue.peek().data);
            for (int i = 0, n = queue.size(); i < n; i++) {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return result;
    }

    public static Node buildTree() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the root node value: ");
            int value = sc.nextInt();
            Node root = new Node(value);

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node current = queue.poll();

                System.out.print("Enter left child of " + current.data + " (-1 for no child): ");
                int leftValue = sc.nextInt();
                if (leftValue != -1) {
                    current.left = new Node(leftValue);
                    queue.add(current.left);
                }

                System.out.print("Enter right child of " + current.data + " (-1 for no child): ");
                int rightValue = sc.nextInt();
                if (rightValue != -1) {
                    current.right = new Node(rightValue);
                    queue.add(current.right);
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Build the binary tree:");
            Node root = buildTree();

            while (true) {
                System.out.println("\nChoose the view to display:");
                System.out.println("1. Top View");
                System.out.println("2. Bottom View");
                System.out.println("3. Left View");
                System.out.println("4. Right View");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> System.out.println("Top View: " + topView(root));
                    case 2 -> System.out.println("Bottom View: " + bottomView(root));
                    case 3 -> System.out.println("Left View: " + leftView(root));
                    case 4 -> System.out.println("Right View: " + rightView(root));
                    case 5 -> {
                        System.out.println("Exiting program.");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
