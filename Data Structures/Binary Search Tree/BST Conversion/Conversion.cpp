#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int value) : data(value), left(nullptr), right(nullptr) {}
};

void inorderTraversal(Node* root, vector<int>& values) {
    if (root == nullptr) {
        return;
    }
    inorderTraversal(root->left, values);
    values.push_back(root->data);
    inorderTraversal(root->right, values);
}

void assignInorder(Node* root, vector<int>& values, int& index) {
    if (root == nullptr) {
        return;
    }
    assignInorder(root->left, values, index);
    root->data = values[index++];
    assignInorder(root->right, values, index);
}

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

void convertToBST(Node* root) {
    vector<int> values;
    inorderTraversal(root, values);
    sort(values.begin(), values.end());

    int index = 0;
    assignInorder(root, values, index);
}

void inorderPrint(Node* root) {
    if (root == nullptr) {
        return;
    }
    inorderPrint(root->left);
    cout << root->data << " ";
    inorderPrint(root->right);
}

int main() {
    Node* root = buildTree();

    cout << "In-order traversal of original tree: ";
    inorderPrint(root);
    cout << endl;

    convertToBST(root);

    cout << "In-order traversal of the converted BST: ";
    inorderPrint(root);
    cout << endl;

    return 0;
}
