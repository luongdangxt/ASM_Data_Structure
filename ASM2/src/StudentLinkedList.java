// StudentLinkedList.java
public class StudentLinkedList {
    private Node head;

    // Thêm sinh viên vào danh sách liên kết
    public void addStudent(Student s) {
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public void updateStudent(String id, String newName, double newMarks) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.id.equals(id)) {
                temp.data.name = newName;
                temp.data.marks = newMarks;
                return;
            }
            temp = temp.next;
        }
    }


    // Xóa sinh viên theo ID
    public void deleteStudent(String id) {
        if (head == null) return;
        if (head.data.id.equals(id)) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && !temp.next.data.id.equals(id)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // In danh sách sinh viên
    public void printStudents() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public Student searchStudent(String id) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.id.equals(id)) {
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }

    // Sắp xếp sinh viên theo điểm (Bubble Sort)
    public void sortStudentsByMarks() {
        if (head == null || head.next == null) return;

        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            Node previous = null;

            while (current.next != null) {
                if (current.data.marks > current.next.data.marks) {
                    // Hoán đổi dữ liệu giữa hai nút
                    Student temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                previous = current;
                current = current.next;
            }
        } while (swapped);
    }

    public void quickSortStudentsByMarks() {
        if (head == null || head.next == null) return;
        head = quickSort(head);
    }

    private Node quickSort(Node start) {
        if (start == null || start.next == null) return start;


        Node pivot = start;
        Node smallerHead = null, smallerTail = null;
        Node largerHead = null, largerTail = null;
        Node current = start.next;

        while (current != null) {

            if (current.data.marks > pivot.data.marks) {
                if (smallerHead == null) {
                    smallerHead = smallerTail = current;
                } else {
                    smallerTail.next = current;
                    smallerTail = current;
                }
            } else {
                if (largerHead == null) {
                    largerHead = largerTail = current;
                } else {
                    largerTail.next = current;
                    largerTail = current;
                }
            }
            current = current.next;
        }


        if (smallerTail != null) smallerTail.next = null;
        if (largerTail != null) largerTail.next = null;

        // Đệ quy sắp xếp các phần nhỏ hơn và lớn hơn
        Node sortedSmaller = quickSort(smallerHead);
        Node sortedLarger = quickSort(largerHead);


        if (sortedSmaller == null) {
            pivot.next = sortedLarger;
            return pivot;
        } else {
            Node temp = sortedSmaller;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = pivot;
            pivot.next = sortedLarger;
            return sortedSmaller;
        }
    }
}