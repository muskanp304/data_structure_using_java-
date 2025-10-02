package Merge_sort.Exercise;
class Tester {

    public static void mergeSort(int[] elements, int size) {
        if (size < 2) {
            return; // Already sorted
        }

        int mid = size / 2;

        // Create left and right subarrays
        int[] left = new int[mid];
        int[] right = new int[size - mid];

        // Fill left array
        for (int i = 0; i < mid; i++) {
            left[i] = elements[i];
        }

        // Fill right array
        for (int i = mid; i < size; i++) {
            right[i - mid] = elements[i];
        }

        // Recursive calls
        mergeSort(left, mid);
        mergeSort(right, size - mid);

        // Merge sorted arrays
        merge(elements, left, right, mid, size - mid);
    }

    public static void merge(int[] elements, int[] left, int[] right, int leftSize, int rightSize) {
        int i = 0, j = 0, k = 0;

        // Merge both arrays while comparing elements
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                elements[k++] = left[i++];
            } else {
                elements[k++] = right[j++];
            }
        }

        // Copy remaining elements from left
        while (i < leftSize) {
            elements[k++] = left[i++];
        }

        // Copy remaining elements from right
        while (j < rightSize) {
            elements[k++] = right[j++];
        }
    }

    public static void displayArray(int[] elements) {
        for (int element : elements)
            System.out.print(element + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] elements = { 95, 56, 20, 98, 34, 77, 80 };

        System.out.println("Given Array:");
        displayArray(elements);

        mergeSort(elements, elements.length);

        System.out.println("Sorted Array:");
        displayArray(elements);
    }
}
