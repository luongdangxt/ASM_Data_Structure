class Stack {
    private Node top; // Reference to the top of the stack

    // Constructor to initialize an empty stack
    public Stack() {
        this.top = null;
    }

    // Method to push an element onto the stack
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top; // Link the new node to the current top
        top = newNode; // Update the top reference
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack Underflow: Cannot pop from an empty stack.");
        }
        int value = top.data; // Get the value of the top node
        top = top.next; // Update the top reference to the next node
        return value;
    }

    // Method to peek at the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        return top.data; // Return the value of the top node
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Method to display all elements in the stack (top -> bottom)
    public void display() {
        Node current = top;
        System.out.print("Stack (top -> bottom): ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next; // Move to the next node
        }
        System.out.println();
    }
}
