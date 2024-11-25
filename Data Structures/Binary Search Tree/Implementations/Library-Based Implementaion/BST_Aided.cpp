#include <iostream>
#include <set>
using namespace std;

int main() {
    set<int> treeSet;
    int choice, x, y;

    while (true) {
        cout << "\nSet Operations Menu:\n";
        cout << "1. Insert Element\n";
        cout << "2. Display Elements (In-order Traversal)\n";
        cout << "3. Search for an Element\n";
        cout << "4. Remove an Element\n";
        cout << "5. Range Query (Lower and Upper Bound)\n";
        cout << "6. Exit\n";
        cout << "Enter your choice: ";
        cin >> choice;

        switch (choice) {
        case 1:
            cout << "Enter element to insert: ";
            cin >> x;
            treeSet.insert(x);
            cout << "Element inserted.\n";
            break;

        case 2:
            cout << "Sorted Elements: ";
            for (int elem : treeSet) {
                cout << elem << " ";
            }
            cout << endl;
            break;

        case 3:
            cout << "Enter element to search: ";
            cin >> x;
            if (treeSet.find(x) != treeSet.end()) {
                cout << "Element found.\n";
            } else {
                cout << "Element not found.\n";
            }
            break;

        case 4:
            cout << "Enter element to remove: ";
            cin >> x;
            if (treeSet.erase(x)) {
                cout << "Element removed.\n";
            } else {
                cout << "Element not found in the set.\n";
            }
            break;

        case 5:
            cout << "Enter lower bound: ";
            cin >> x;
            cout << "Enter upper bound: ";
            cin >> y;
            cout << "Elements in range [" << x << ", " << y << "]: ";
            for (auto it = treeSet.lower_bound(x); it != treeSet.upper_bound(y); ++it) {
                cout << *it << " ";
            }
            cout << endl;
            break;

        case 6:
            cout << "Exiting program.\n";
            return 0;

        default:
            cout << "Invalid choice. Please try again.\n";
        }
    }

    return 0;
}
