package Dynamic_Programming.Exercise;
class Tester {

    public static int cutRod(int[] price, int n) {
        int[] dp = new int[n + 1];  // dp[i] will store max price for rod length i
        dp[0] = 0;

        // Build the dp[] array bottom-up
        for (int i = 1; i <= n; i++) {
            int maxVal = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                maxVal = Math.max(maxVal, price[j] + dp[i - j - 1]);
            }
            dp[i] = maxVal;
        }

        return dp[n]; // Max price for rod of length n
    }

    public static void main(String[] args) {
        int price[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int n = 4;
        System.out.println("Maximum price: " + cutRod(price, n));
    }
}
