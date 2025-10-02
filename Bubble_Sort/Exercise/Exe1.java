package Bubble_Sort.Exercise;

class Tester {
	static int noOfSwaps = 0;
	static int noOfPasses = 0;

	// Swap two elements in the array
	public static void swap(int[] elements, int firstIndex, int secondIndex) {
		int temp = elements[firstIndex];
		elements[firstIndex] = elements[secondIndex];
		elements[secondIndex] = temp;
		noOfSwaps++;
	}

	// Bubble Sort with intermediate display and pass count
	public static int bubbleSort(int[] elements) {
		int n = elements.length;
		boolean swapped;

		for (int i = 0; i < n - 1; i++) {
			swapped = false;

			for (int j = 0; j < n - 1 - i; j++) {
				if (elements[j] > elements[j + 1]) {
					swap(elements, j, j + 1);
					swapped = true;
				}
			}

			noOfPasses++;
			System.out.print("After pass " + noOfPasses + ": ");
			displayArray(elements);

			if (!swapped) break; // Array already sorted
		}

		return noOfPasses;
	}

	// Display the array
	public static void displayArray(int[] elements) {
		for (int element : elements)
			System.out.print(element + " ");
		System.out.println();
	}

	// Main method
	public static void main(String[] args) {

		int[] elements = { 23, 67, 45, 76, 34, 68, 90 };

		System.out.println("Given array:");
		displayArray(elements);

		int noOfPasses = bubbleSort(elements);

		System.out.println("==========================");
		System.out.println("Total number of passes needed to sort the array: " + noOfPasses);
		System.out.println("==========================");

		System.out.println("Array after sorting:");
		displayArray(elements);
	}
}

