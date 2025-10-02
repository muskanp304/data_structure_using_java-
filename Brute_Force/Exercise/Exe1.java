package Brute_Force.Exercise;
class Tester {

    public static int calculatePower(int num, int p) {
        int result = 1;

        // Multiply num by itself p times
        for (int i = 1; i <= p; i++) {
            result *= num;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2, 3));  // Output: 8
    }
}
