// File: QuickSort.java

class QuickSort {
    // Method to perform QuickSort
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Method to partition the array
    static int partition(int arr[], int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = (low - 1); // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than the pivot
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and pivot (arr[high])
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Main method to test QuickSort
    public static void main(String args[]) {
        int arr[] = {64, 34, 25, 12, 22, 11, 90};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
