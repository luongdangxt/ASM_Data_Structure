class Stack {
    private int maxSize; // Maximum size of the stack
    private int[] stackArray; // Array to store stack elements
    private int top; // Top of the stack

    // Constructor to initialize stack
    public Stack(int size) {
        this.maxSize = size;
        this.stackArray = new int[maxSize];
        this.top = -1; // Indicates empty stack
    }

    // Push: Add an element to the stack
    public void push(int value) {
        if (top >= maxSize - 1) {
            System.out.println("Stack Overflow! Cannot push " + value);
            return;
        }
        stackArray[++top] = value;
        System.out.println("Pushed: " + value);
    }

    // Pop: Remove and return the top element
    public int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow! No elements to pop.");
            return -1;
        }
        System.out.println("Popped: " + stackArray[top]);
        return stackArray[top--];
    }

    // Peek: Return the top element without removing it
    public int peek() {
        if (top < 0) {
            System.out.println("Stack is empty! No top element.");
            return -1;
        }
        return stackArray[top];
    }

    // isEmpty: Check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Display: Show all elements in the stack
    public void display() {
        if (top < 0) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }
}