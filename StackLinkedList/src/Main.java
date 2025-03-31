class StackLinkedList {

    // Node class to represent each element in the stack
    private class Node {
        int data;   // Data stored in the node
        Node next;  // Reference to the next node

        // Constructor for Node
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // Top of the stack (head of the linked list)

    // Constructor for StackLinkedList
    public StackLinkedList() {
        this.top = null; // Initialize stack as empty
    }

    // Push operation: Adds a new element to the top of the stack
    public void push(int data) {
        Node newNode = new Node(data); // Create a new node with given data
        newNode.next = top;           // Link new node to current top
        top = newNode;                // Update top to new node
    }

    // Pop operation: Removes and returns the top element of the stack
    public int pop() {
        if (isEmpty()) { // Check if stack is empty
            System.out.println("Stack Underflow!");
            return -1;   // Return -1 to indicate underflow
        }
        int value = top.data;  // Get data from the top node
        top = top.next;        // Update top to next node
        return value;          // Return popped value
    }

    // Helper method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a StackLinkedList object
        StackLinkedList stack = new StackLinkedList();

        // Print initial stack status
        System.out.println("Is the stack initially empty? " + stack.isEmpty());

        // Add elements to the stack
        System.out.println("Pushing elements onto the stack:");
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Check status after pushing elements
        System.out.println("Is the stack empty after pushing? " + stack.isEmpty());

        // Pop elements from the stack
        System.out.println("Popping elements from the stack:");
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // Check status after popping some elements
        System.out.println("Is the stack empty after popping some elements? " + stack.isEmpty());

        // Continue popping remaining elements
        System.out.println("Popped element: " + stack.pop());

        // Try popping when the stack is empty (Underflow)
        System.out.println("Attempting to pop from an empty stack:");
        System.out.println("Popped element: " + stack.pop());
    }
}
