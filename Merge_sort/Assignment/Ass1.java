package Merge_sort.Assignment;

class Tester {

    // Merge Sort
    public static void mergeSort(int[] elements, int size) {
        if (size < 2) {
            return; // Array with one element is already sorted
        }

        int mid = size / 2;
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        // Divide array into left and right halves
        for (int i = 0; i < mid; i++) {
            left[i] = elements[i];
        }
        for (int i = mid; i < size; i++) {
            right[i - mid] = elements[i];
        }

        // Recursively sort both halves
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        // Merge sorted halves
        merge(elements, left, right, mid, size - mid);
    }

    // Merge two sorted arrays into the original array
    public static void merge(int[] elements, int[] left, int[] right, int leftMerge, int rightMerge) {
        int i = 0, j = 0, k = 0;

        // Merge while comparing elements
        while (i < leftMerge && j < rightMerge) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < leftMerge) {
            elements[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < rightMerge) {
            elements[k++] = right[j++];
        }
    }

    // Find the median of a sorted array
    public static double findMedian(int[] elements) {
        int n = elements.length;
        if (n % 2 == 1) {
            return elements[n / 2]; // Odd length: middle element
        } else {
            return (elements[(n / 2) - 1] + elements[n / 2]) / 2.0; // Even length: average of two middle elements
        }
    }

    public static void main(String[] args) {
        int elements[] = { 64, 34, 25, 12, 22, 11, 90 }; 

        mergeSort(elements, elements.length); 

        System.out.println("Median: " + findMedian(elements));
    }
}
