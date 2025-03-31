// Student.java
public class Student {
    String id;
    String name;
    double marks;

    public Student(String id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String getRank() {
        if (marks < 5.0) return "Fail";
        if (marks < 6.5) return "Medium";
        if (marks < 7.5) return "Good";
        if (marks < 9.0) return "Very Good";
        return "Excellent";
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + marks + " - " + getRank();
    }

    int getFirstNum(int[] arr) {
        return arr[0]; // Direct access via index
    }

    int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) { // Iterating through all elements
            sum += num;
        }
        return sum;
    }

    void printAllPairs(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) { // Nested loop
                System.out.println(arr[i] + ", " + arr[j]);
            }
        }
    }

    int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // Dividing search space
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }


    void swap(int a, int b) {
        int temp = a; // Only 3 fixed variables
        a = b;
        b = temp;
    }


    int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length]; // Allocating a new array
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    int[][] generateIdentityMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 1; // Identity matrix n×n
        }
        return matrix;
    }


    double power(double x, int n) {
        if (n == 0) return 1.0;
        double half = power(x, n / 2); // Recursive depth log n
        return (n % 2 == 0) ? half * half : x * half * half;
    }



}

