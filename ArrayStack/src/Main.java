// Main.java
public class Main {
    public static void main(String[] args) {
        System.out.println("Array-based Stack:");
        ArrayStack arrayStack = new ArrayStack(5); // Create an ArrayStack with a capacity of 5
        arrayStack.push(10);
        arrayStack.push(20);
        System.out.println("Popped: " + arrayStack.pop()); // Output: 20
        System.out.println("Top Element: " + arrayStack.peek()); // Output: 10
        System.out.println("Stack Size: " + arrayStack.size()); // Output: 1

        System.out.println("\nLinked List-based Stack:");
        LinkedListStack linkedListStack = new LinkedListStack(); // Create a LinkedList-based stack
        linkedListStack.push(10);
        linkedListStack.push(20);
        System.out.println("Popped: " + linkedListStack.pop()); // Output: 20
        System.out.println("Top Element: " + linkedListStack.peek()); // Output: 10
        System.out.println("Is Empty: " + linkedListStack.isEmpty()); // Output: false
        System.out.println("Stack Size: " + linkedListStack.size()); // Output: 1
    }
}

// ArrayStack.java
class ArrayStack {
    private int[] stack;
    private int top;

    public ArrayStack(int capacity) {
        stack = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (top == stack.length - 1) {
            throw new StackOverflowError("Stack is full");
        }
        stack[++top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }
}

// LinkedListStack.java
class LinkedListStack {
    private Node top;
    private int size;

    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int value = top.value;
        top = top.next;
        size--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.value;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
