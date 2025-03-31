class Queue {
    private Node front, rear; // Front and rear pointers of the queue

    // Constructor to initialize an empty queue
    public Queue() {
        this.front = this.rear = null;
    }

    // Method to add an element to the queue
    public void enqueue(int data) {
        Node newNode = new Node(data); // Create a new node with the given data
        if (rear == null) { // If the queue is empty
            front = rear = newNode; // Both front and rear point to the new node
        } else {
            rear.next = newNode; // Link the new node to the end of the queue
            rear = newNode; // Update rear pointer to the new node
        }
    }

    // Method to remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) { // Check if the queue is empty
            throw new RuntimeException("Queue Underflow: Cannot dequeue from an empty queue.");
        }
        int value = front.data; // Get the data from the front node
        front = front.next; // Move front pointer to the next node
        if (front == null) { // If the queue becomes empty after dequeuing
            rear = null; // Set rear to null as well
        }
        return value; // Return dequeued value
    }

    // Method to get the element at the front of the queue without removing it
    public int peek() {
        if (isEmpty()) { // Check if the queue is empty
            throw new RuntimeException("Queue is empty.");
        }
        return front.data; // Return data from the front node
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null; // Queue is empty if front is null
    }

    // Method to display all elements in the queue from front to rear
    public void display() {
        Node current = front; // Start from the front of the queue
        System.out.print("Queue (front -> rear): ");
        while (current != null) { // Traverse until end of queue (rear)
            System.out.print(current.data + " "); // Print data of each node
            current = current.next; // Move to next node
        }
        System.out.println(); // Print a newline at end of display output
    }
}