public class Main {
    public static void main(String[] args) {
        Queue q = new Queue(); // Tạo đối tượng Queue

        q.enqueue(10);         // Thêm các phần tử vào hàng đợi
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element: " + q.front());  // Output: 10 (Lấy phần tử đầu tiên)
        System.out.println("Dequeue: " + q.dequeue());      // Output: 10 (Xóa phần tử đầu tiên)
        System.out.println("Dequeue: " + q.dequeue());      // Output: 20 (Xóa phần tử tiếp theo)
        System.out.println("Queue is empty? " + q.isEmpty());// Output: false (Hàng đợi chưa rỗng)
        System.out.println("Dequeue: " + q.dequeue());      // Output: 30 (Xóa phần tử cuối cùng)
        System.out.println("Queue is empty? " + q.isEmpty());// Output: true (Hàng đợi đã rỗng)
    }
}
