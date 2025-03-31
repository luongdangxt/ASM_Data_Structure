
public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(); // Create a new queue instance

        System.out.println("Enqueuing elements:");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.display();  // Output: Queue (front -> rear): 10 20 30

        System.out.println("Front element: " + queue.peek());  // Output: Front element: 10

        System.out.println("Dequeuing element: " + queue.dequeue());
        queue.display();  // Output: Queue (front -> rear): 20 30

        System.out.println("Dequeuing element: " + queue.dequeue());
        System.out.println("Dequeuing element: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());  // Output: Is queue empty? true
    }
}
