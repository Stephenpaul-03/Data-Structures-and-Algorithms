from collections import deque

class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.right = None

def top_view(root):
    if not root:
        return []
    queue = deque([(root, 0)])
    hd_map = {}
    while queue:
        node, hd = queue.popleft()
        if hd not in hd_map:
            hd_map[hd] = node.data
        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))
    return [hd_map[hd] for hd in sorted(hd_map)]

def bottom_view(root):
    if not root:
        return []
    queue = deque([(root, 0)])
    hd_map = {}
    while queue:
        node, hd = queue.popleft()
        hd_map[hd] = node.data
        if node.left:
            queue.append((node.left, hd - 1))
        if node.right:
            queue.append((node.right, hd + 1))
    return [hd_map[hd] for hd in sorted(hd_map)]

def left_view(root):
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        result.append(queue[0].data)
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    return result

def right_view(root):
    if not root:
        return []
    result = []
    queue = deque([root])
    while queue:
        result.append(queue[-1].data)
        for _ in range(len(queue)):
            node = queue.popleft()
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
    return result

def build():
    print("Enter the root node value:")
    root_value = int(input())
    root = Node(root_value)
    queue = deque([root])
    
    while queue:
        current = queue.popleft()
        print(f"Enter left child of {current.data} (or -1 for no left child):")
        left_value = int(input())
        if left_value != -1:
            current.left = Node(left_value)
            queue.append(current.left)
        
        print(f"Enter right child of {current.data} (or -1 for no right child):")
        right_value = int(input())
        if right_value != -1:
            current.right = Node(right_value)
            queue.append(current.right)
    
    return root

# Main function
def main():
    print("Build the binary tree:")
    root = build()

    while True:
        print("\nTree View Operations:")
        print("1. Top View")
        print("2. Bottom View")
        print("3. Left View")
        print("4. Right View")
        print("5. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            print("Top View:", top_view(root))
        elif choice == 2:
            print("Bottom View:", bottom_view(root))
        elif choice == 3:
            print("Left View:", left_view(root))
        elif choice == 4:
            print("Right View:", right_view(root))
        elif choice == 5:
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
