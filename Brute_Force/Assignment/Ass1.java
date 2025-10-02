package Brute_Force.Assignment;

class Tester {

    public static int[][] multiply(int arr1[][], int arr2[][]) {
        int n = arr1.length; // Assuming both matrices are square and of same size
        int[][] result = new int[n][n];

        // Brute-force multiplication
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr1[][] = new int[][] { {2, 4}, {1, 4} };
        int arr2[][] = new int[][] { {1, 4}, {1, 3} };

        int[][] arr3 = multiply(arr1, arr2);

        System.out.println("Resultant Matrix:");
        for (int i = 0; i < arr3.length; i++) {
            for (int j = 0; j < arr3[0].length; j++) {
                System.out.print(arr3[i][j] + " ");
            }
            System.out.println();
        }
    }
}

