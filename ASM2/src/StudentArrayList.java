// StudentArrayList.java
public class StudentArrayList {
    private Student[] students;
    private int size;

    public StudentArrayList() {
        students = new Student[1000]; // 1000 sinh viên
        size = 0;
    }

    // Thêm sinh viên vào danh sách
    public void addStudent(Student s) {
        if (size < students.length) {
            students[size++] = s;
        }
    }

    public void updateStudent(String id, String newName, double newMarks) {
        for (int i = 0; i < size; i++) {
            if (students[i].id.equals(id)) {
                students[i].name = newName;
                students[i].marks = newMarks;
                return;
            }
        }
    }


    // Xóa sinh viên theo ID
    public void deleteStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].id.equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    students[j] = students[j + 1];
                }
                students[--size] = null;
                return;
            }
        }
    }

    // In danh sách sinh viên
    public void printStudents() {
        for (int i = 0; i < size; i++) {
            System.out.println(students[i]);
        }
    }

    // Tìm kiếm sinh viên theo ID
    public Student searchStudent(String id) {
        for (int i = 0; i < size; i++) {
            if (students[i].id.equals(id)) {
                return students[i];
            }
        }
        return null; // Không tìm thấy
    }

    // Sắp xếp sinh viên theo điểm (Bubble Sort)
    public void sortStudentsByMarks() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (students[j].marks > students[j + 1].marks) {
                    // Hoán đổi hai sinh viên
                    Student temp = students[j];
                    students[j] = students[j + 1];
                    students[j + 1] = temp;
                }
            }
        }
    }

    // StudentArrayList.java
    public void quickSortStudentsByMarks() {
        quickSort(students, 0, size - 1);
    }

    private void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].marks;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].marks < pivot) {
                i++;
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    // StudentArrayList.java
    public Student binarySearchStudentByMarks(double marks) {
        quickSortStudentsByMarks();

        int left = 0, right = size - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (students[mid].marks == marks) {
                return students[mid];
            }
            if (students[mid].marks < marks) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}