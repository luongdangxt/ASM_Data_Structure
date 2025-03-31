// Stack class implementation


// Main class to test the Stack implementation
public class StackExample {
    public static void main(String[] args) {
        Stack myStack = new Stack(5); // Create a stack with size 5

        myStack.push(10); // Push elements onto the stack
        myStack.push(20);
        myStack.push(30);

        myStack.display(); // Display the stack elements

        System.out.println("Peeked Element: " + myStack.peek()); // Peek at the top element

        myStack.pop(); // Pop an element from the stack
        myStack.display(); // Display the remaining elements

        System.out.println("Is stack empty? " + myStack.isEmpty()); // Check if the stack is empty
    }
}
