package Divide_conquer.Assignment;
class Tester {

    // Function to find the maximum crossing subarray sum
    public static int findMaxCrossingSubarraySum(int arr[], int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }

        return leftSum + rightSum;
    }

    // Recursive function to find max subarray sum
    public static int findMaxSum(int arr[], int low, int high) {
        // Base case: only one element
        if (low == high)
            return arr[low];

        int mid = (low + high) / 2;

        int leftMax = findMaxSum(arr, low, mid);
        int rightMax = findMaxSum(arr, mid + 1, high);
        int crossMax = findMaxCrossingSubarraySum(arr, low, mid, high);

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    public static void main(String[] args) {
        int arr[] = { -2, -5, 6, -2, -3, 1, 5, -6 };
        System.out.println("Maximum sum: " + findMaxSum(arr, 0, arr.length - 1));
    }
}
