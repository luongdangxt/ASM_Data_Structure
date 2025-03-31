// Node class to represent each element in the stack


// Stack class implemented using linked list


    // Main method for testing the stack implementation
class main{
    public static void main(String[] args) {
        Stack stack = new Stack();

        System.out.println("Pushing elements onto the stack:");
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display(); // Output: Stack (top -> bottom): 30 20 10

        System.out.println("Top element: " + stack.peek()); // Output: Top element: 30

        System.out.println("Popping element: " + stack.pop()); // Output: Popping element: 30
        stack.display(); // Output: Stack (top -> bottom): 20 10

        System.out.println("Popping element: " + stack.pop()); // Output: Popping element: 20
        System.out.println("Popping element: " + stack.pop()); // Output: Popping element: 10

        System.out.println("Is stack empty? " + stack.isEmpty()); // Output: Is stack empty? true
    }
}
