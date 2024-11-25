#include <iostream>
#include <map>
#include <queue>
#include <vector>
using namespace std;

struct Node {
    int data;
    Node* left;
    Node* right;
    Node(int value) : data(value), left(nullptr), right(nullptr) {}
};

vector<int> topView(Node* root) {
    if (!root) return {};
    map<int, int> hdMap;
    queue<pair<Node*, int>> q;
    q.push({root, 0});
    while (!q.empty()) {
        auto [node, hd] = q.front();
        q.pop();
        if (!hdMap.count(hd)) hdMap[hd] = node->data;
        if (node->left) q.push({node->left, hd - 1});
        if (node->right) q.push({node->right, hd + 1});
    }
    vector<int> result;
    for (auto [_, val] : hdMap) result.push_back(val);
    return result;
}

vector<int> bottomView(Node* root) {
    if (!root) return {};
    map<int, int> hdMap;
    queue<pair<Node*, int>> q;
    q.push({root, 0});
    while (!q.empty()) {
        auto [node, hd] = q.front();
        q.pop();
        hdMap[hd] = node->data;
        if (node->left) q.push({node->left, hd - 1});
        if (node->right) q.push({node->right, hd + 1});
    }
    vector<int> result;
    for (auto [_, val] : hdMap) result.push_back(val);
    return result;
}

vector<int> leftView(Node* root) {
    if (!root) return {};
    vector<int> result;
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        result.push_back(q.front()->data);
        for (int i = 0, n = q.size(); i < n; ++i) {
            Node* node = q.front();
            q.pop();
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }
    }
    return result;
}

vector<int> rightView(Node* root) {
    if (!root) return {};
    vector<int> result;
    queue<Node*> q;
    q.push(root);
    while (!q.empty()) {
        result.push_back(q.back()->data);
        for (int i = 0, n = q.size(); i < n; ++i) {
            Node* node = q.front();
            q.pop();
            if (node->left) q.push(node->left);
            if (node->right) q.push(node->right);
        }
    }
    return result;
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

int main() {
    Node* root = buildTree();

    int choice;
    do {
        cout << "\nChoose the view to display:\n";
        cout << "1. Top View\n";
        cout << "2. Bottom View\n";
        cout << "3. Left View\n";
        cout << "4. Right View\n";
        cout << "5. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        vector<int> result;

        switch (choice) {
            case 1:
                result = topView(root);
                cout << "Top View: ";
                for (int val : result) cout << val << " ";
                cout << endl;
                break;
            case 2:
                result = bottomView(root);
                cout << "Bottom View: ";
                for (int val : result) cout << val << " ";
                cout << endl;
                break;
            case 3:
                result = leftView(root);
                cout << "Left View: ";
                for (int val : result) cout << val << " ";
                cout << endl;
                break;
            case 4:
                result = rightView(root);
                cout << "Right View: ";
                for (int val : result) cout << val << " ";
                cout << endl;
                break;
            case 5:
                cout << "Exiting the program." << endl;
                break;
            default:
                cout << "Invalid choice. Please try again." << endl;
        }
    } while (choice != 5);

    return 0;
}
