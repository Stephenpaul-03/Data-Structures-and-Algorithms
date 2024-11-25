class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

def inorderTraversal(root, values):
    if root is None:
        return
    inorderTraversal(root.left, values)
    values.append(root.data)
    inorderTraversal(root.right, values)

def assignInorder(root, values, index):
    if root is None:
        return
    assignInorder(root.left, values, index)
    root.data = values[index[0]]
    index[0] += 1
    assignInorder(root.right, values, index)

def build():
    value = int(input("Enter the root node value: "))
    root = Node(value)

    queue = [root]
    while queue:
        current = queue.pop(0)

        value = int(input(f"Enter left child of {current.data} (-1 for no child): "))
        if value != -1:
            current.left = Node(value)
            queue.append(current.left)

        value = int(input(f"Enter right child of {current.data} (-1 for no child): "))
        if value != -1:
            current.right = Node(value)
            queue.append(current.right)

    return root

def convert(root):
    values = []
    inorderTraversal(root, values)
    values.sort()

    index = [0]
    assignInorder(root, values, index)

def ioPrint(root):
    if root is None:
        return
    ioPrint(root.left)
    print(root.data, end=" ")
    ioPrint(root.right)

if __name__ == "__main__":
    root = build()

    print("In-order traversal of original tree: ", end="")
    ioPrint(root)
    print()

    convert(root)

    print("In-order traversal of the converted BST: ", end="")
    ioPrint(root)
    print()
