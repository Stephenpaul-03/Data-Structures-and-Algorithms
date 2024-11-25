#include <iostream>
#include <queue>
#include <climits>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int value) : data(value), left(nullptr), right(nullptr) {}
};

Node* buildTree() {
    int value;
    cout << "Enter the root node value: ";
    cin >> value;
    Node* root = new Node(value);

    queue<Node*> q;
    q.push(root);

    while (!q.empty()) {
        Node* current = q.front();
        q.pop();

        cout << "Enter left child of " << current->data << " (-1 for no child): ";
        cin >> value;
        if (value != -1) {
            current->left = new Node(value);
            q.push(current->left);
        }

        cout << "Enter right child of " << current->data << " (-1 for no child): ";
        cin >> value;
        if (value != -1) {
            current->right = new Node(value);
            q.push(current->right);
        }
    }

    return root;
}

bool inorderTraversal(Node* root, int& prevValue) {
    if (root == nullptr) {
        return true;
    }

    if (!inorderTraversal(root->left, prevValue)) {
        return false;
    }

    if (root->data <= prevValue) {
        return false;
    }

    prevValue = root->data;

    return inorderTraversal(root->right, prevValue);
}

bool isBST(Node* root) {
    int prevValue = INT_MIN;
    return inorderTraversal(root, prevValue);
}

int main() {
    Node* root = buildTree();

    if (isBST(root)) {
        cout << "The tree is a valid Binary Search Tree (BST)." << endl;
    } else {
        cout << "The tree is NOT a valid Binary Search Tree (BST)." << endl;
    }

    return 0;
}
