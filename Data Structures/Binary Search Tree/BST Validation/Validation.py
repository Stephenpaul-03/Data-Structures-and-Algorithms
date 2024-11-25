class Node:
    def __init__(self, value):
        self.data = value
        self.left = None
        self.right = None

def buildTree():
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

def inorderTraversal(root, prevValue):
    if root is None:
        return True

    if not inorderTraversal(root.left, prevValue):
        return False

    if root.data <= prevValue[0]:
        return False

    prevValue[0] = root.data

    return inorderTraversal(root.right, prevValue)

def isBST(root):
    prevValue = [float('-inf')]
    return inorderTraversal(root, prevValue)

if __name__ == "__main__":
    root = buildTree()

    if isBST(root):
        print("The tree is a valid Binary Search Tree (BST).")
    else:
        print("The tree is NOT a valid Binary Search Tree (BST).")
