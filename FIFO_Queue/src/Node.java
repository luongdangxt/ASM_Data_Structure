class Node {
    int data;    // Giá trị được lưu trong node
    Node next;   // Con trỏ tới node tiếp theo

    // Constructor để khởi tạo node
    public Node(int data) {
        this.data = data;
        this.next = null; // Ban đầu, next là null
    }
}
