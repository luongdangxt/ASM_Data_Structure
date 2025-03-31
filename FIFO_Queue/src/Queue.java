class Queue {
    private Node front, rear; // Con trỏ tới đầu và cuối của hàng đợi

    // Constructor để khởi tạo hàng đợi rỗng
    public Queue() {
        this.front = this.rear = null; // Cả front và rear đều null khi hàng đợi rỗng
    }

    // Phương thức enqueue: Thêm phần tử vào hàng đợi
    public void enqueue(int data) {
        Node newNode = new Node(data); // Tạo một node mới với dữ liệu truyền vào

        if (this.rear == null) { // Nếu hàng đợi rỗng
            this.front = this.rear = newNode; // Cả front và rear đều trỏ tới node mới
            return;
        }

        this.rear.next = newNode; // Liên kết node cuối cùng với node mới
        this.rear = newNode;      // Cập nhật rear để trỏ tới node mới
    }

    // Phương thức dequeue: Xóa và trả về phần tử đầu tiên trong hàng đợi
    public int dequeue() {
        if (this.front == null) { // Kiểm tra nếu hàng đợi rỗng
            System.out.println("Queue is empty!");
            return -1; // Trả về -1 để biểu thị hàng đợi rỗng
        }

        int value = this.front.data;  // Lưu giá trị của phần tử đầu tiên
        this.front = this.front.next; // Di chuyển front tới node tiếp theo

        if (this.front == null) {     // Nếu hàng đợi trở nên rỗng sau khi xóa
            this.rear = null;         // Cập nhật rear thành null
        }

        return value;
    }

    // Phương thức front: Lấy giá trị phần tử đầu tiên mà không xóa nó
    public int front() {
        if (this.front == null) { // Kiểm tra nếu hàng đợi rỗng
            System.out.println("Queue is empty!");
            return -1; // Trả về -1 để biểu thị hàng đợi rỗng
        }
        return this.front.data;   // Trả về giá trị của phần tử đầu tiên
    }

    // Phương thức isEmpty: Kiểm tra xem hàng đợi có rỗng hay không
    public boolean isEmpty() {
        return this.front == null;
    }
}
