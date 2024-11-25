import java.util.Scanner;
import java.util.TreeSet;

public class BST_Aided {
    public static void main(String[] args) {
        TreeSet<Integer> bst = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTreeSet Operations:");
            System.out.println("1. Insert Element");
            System.out.println("2. Display Elements (In-order Traversal)");
            System.out.println("3. Search for an Element");
            System.out.println("4. Perform Range Query");
            System.out.println("5. Remove an Element");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter element to insert: ");
                    int insertElement = scanner.nextInt();
                    bst.add(insertElement);
                    System.out.println("Element inserted.");
                }

                case 2 -> System.out.println("Elements in TreeSet (sorted): " + bst);

                case 3 -> {
                    System.out.print("Enter element to search: ");
                    int searchElement = scanner.nextInt();
                    if (bst.contains(searchElement)) {
                        System.out.println("Element found in TreeSet.");
                    } else {
                        System.out.println("Element not found in TreeSet.");
                    }
                }

                case 4 -> {
                    System.out.print("Enter lower bound (inclusive): ");
                    int lowerBound = scanner.nextInt();
                    System.out.print("Enter upper bound (exclusive): ");
                    int upperBound = scanner.nextInt();
                    System.out.println("Elements in range [" + lowerBound + ", " + upperBound + "): " + bst.subSet(lowerBound, upperBound));
                }

                case 5 -> {
                    System.out.print("Enter element to remove: ");
                    int removeElement = scanner.nextInt();
                    if (bst.remove(removeElement)) {
                        System.out.println("Element removed.");
                    } else {
                        System.out.println("Element not found in TreeSet.");
                    }
                }

                case 6 -> {
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
