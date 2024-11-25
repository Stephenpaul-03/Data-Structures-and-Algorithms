from sortedcontainers import SortedSet

def main():
    sorted_set = SortedSet()

    while True:
        print("\nSortedSet Operations:")
        print("1. Insert Element")
        print("2. Display Elements (In-order Traversal)")
        print("3. Search for an Element")
        print("4. Remove an Element")
        print("5. Range Query")
        print("6. Exit")
        choice = int(input("Enter your choice: "))

        if choice == 1:
            x = int(input("Enter element to insert: "))
            sorted_set.add(x)
            print(f"Element {x} inserted.")
        elif choice == 2:
            print("Elements in SortedSet (in-order):", list(sorted_set))
        elif choice == 3:
            x = int(input("Enter element to search: "))
            if x in sorted_set:
                print(f"Element {x} found in SortedSet.")
            else:
                print(f"Element {x} not found in SortedSet.")
        elif choice == 4:
            x = int(input("Enter element to remove: "))
            if x in sorted_set:
                sorted_set.discard(x)
                print(f"Element {x} removed.")
            else:
                print(f"Element {x} not found in SortedSet.")
        elif choice == 5:
            x = int(input("Enter lower bound (inclusive): "))
            y = int(input("Enter upper bound (exclusive): "))
            range_elements = list(sorted_set.irange(x, y))
            print(f"Elements in range [{x}, {y}):", range_elements)
        elif choice == 6:
            print("Exiting program.")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
