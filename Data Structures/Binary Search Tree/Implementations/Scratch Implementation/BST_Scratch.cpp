#include <iostream>
using namespace std;

// Node structure
struct Node {
    int data;
    Node* left;
    Node* right;

    Node(int value) {
        data = value;
        left = nullptr;
        right = nullptr;
    }
};

// BST class
class BST {
public:
    Node* root;

    BST() {
        root = nullptr;
    }

    // Insert function
    Node* insert(Node* root, int value) {
        if (root == nullptr)
            return new Node(value);

        if (value < root->data)
            root->left = insert(root->left, value);
        else if (value > root->data)
            root->right = insert(root->right, value);

        return root;
    }

    // Search function
    bool search(Node* root, int target) {
        if (root == nullptr)
            return false;

        if (root->data == target)
            return true;
        else if (target < root->data)
            return search(root->left, target);
        else
            return search(root->right, target);
    }

    // In-order Traversal
    void inOrder(Node* root) {
        if (root != nullptr) {
            inOrder(root->left);
            cout << root->data << " ";
            inOrder(root->right);
        }
    }
};

// Main function
int main() {
    BST tree;
    int choice, value;

    while (true) {
        cout << "\nBinary Search Tree Operations:\n";
        cout << "1. Insert\n";
        cout << "2. Search\n";
        cout << "3. Display In-Order Traversal\n";
        cout << "4. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter value to insert: ";
            cin >> value;
            tree.root = tree.insert(tree.root, value);
            break;
        case 2:
            cout << "Enter value to search: ";
            cin >> value;
            if (tree.search(tree.root, value))
                cout << "Value found in the tree.\n";
            else
                cout << "Value not found in the tree.\n";
            break;
        case 3:
            cout << "In-Order Traversal: ";
            tree.inOrder(tree.root);
            cout << endl;
            break;
        case 4:
            cout << "Exiting program.\n";
            return 0;
        default:
            cout << "Invalid choice. Please try again.\n";
        }
    }

    return 0;
}
