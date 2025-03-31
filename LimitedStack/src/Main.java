// Base Stack class
class Stack {
    protected int[] stackArray;
    protected int top;
    protected int capacity;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.capacity = size;
        this.stackArray = new int[size];
        this.top = -1;
    }

    // Push method to add an element to the stack
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow!");
            return;
        }
        stackArray[++top] = value;
    }

    // Pop method to remove and return the top element of the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stackArray[top--];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
}

// LimitedStack class extending Stack
class LimitedStack extends Stack {
    private int maxPushCount;
    private int pushCount;

    // Constructor to initialize LimitedStack
    public LimitedStack(int size, int maxPushCount) {
        super(size);
        this.maxPushCount = maxPushCount;
        this.pushCount = 0;
    }

    // Overridden push method with a limit on push count
    @Override
    public void push(int value) {
        if (pushCount == maxPushCount) {
            System.out.println("Push limit reached!");
            return;
        }
        super.push(value);
        pushCount++;
    }
}

// Main class to test the functionality
public class Main {
    public static void main(String[] args) {
        LimitedStack stack = new LimitedStack(5, 2);

        stack.push(10); // Pushes 10 into the stack
        stack.push(20); // Pushes 20 into the stack
        stack.push(30); // Will be blocked due to push limit

        System.out.println("Pop: " + stack.pop()); // Output: 20
        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: false
    }
}
