package Bubble_Sort.Assignment;

class Tester {

    // Bubble Sort
    public static void sortArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Optimization: stop if already sorted
        }
    }

    // Maximum sum of top 'm' largest elements
    public static int findMaxSum(int arr[], int m) {
        if (m > arr.length) return 0;

        int sum = 0;
        int n = arr.length;
        for (int i = n - m; i < n; i++) {
            sum += arr[i];
        }
        return sum;
    }

    // Minimum sum of top 'm' smallest elements
    public static int findMinSum(int arr[], int m) {
        if (m > arr.length) return 0;

        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

        sortArray(arr);  // Sort the array before finding min/max

        System.out.println("Maximum Sum for m=4: " + findMaxSum(arr, 4));
        System.out.println("Minimum Sum for m=3: " + findMinSum(arr, 3));
    }
}
