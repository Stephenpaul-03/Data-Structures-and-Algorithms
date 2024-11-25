class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

class BST:

    def __init__(self):
        self.root = None

    # Insert function
    def insert(self, root, value):
        if root is None:
            return Node(value)

        if value < root.data:
            root.left = self.insert(root.left, value)
        elif value > root.data:
            root.right = self.insert(root.right, value)

        return root

    # Search function
    def search(self, root, target):
        if root is None:
            return False

        if root.data == target:
            return True
        elif target < root.data:
            return self.search(root.left, target)
        else:
            return self.search(root.right, target)

    # In-order Traversal
    def inOrder(self, root):
        if root is not None:
            self.inOrder(root.left)
            print(root.data, end=" ")
            self.inOrder(root.right)

# Main function
def main():
    tree = BST()

    while True:
        print("\nBinary Search Tree Operations:")
        print("1. Insert")
        print("2. Search")
        print("3. Display In-Order Traversal")
        print("4. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            value = int(input("Enter value to insert: "))
            tree.root = tree.insert(tree.root, value)
            print(f"Value {value} inserted.")
        elif choice == 2:
            target = int(input("Enter value to search: "))
            if tree.search(tree.root, target):
                print(f"Value {target} found in the tree.")
            else:
                print(f"Value {target} not found in the tree.")
        elif choice == 3:
            print("In-Order Traversal:")
            tree.inOrder(tree.root)
            print()
        elif choice == 4:
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
