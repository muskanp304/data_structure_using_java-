package Greedy_method.Assignment;

class Tester {
    
    public static int findSwapCount(String inputString) {
        int balance = 0;  // Current balance
        int maxImbalance = 0;

        for (int i = 0; i < inputString.length(); i++) {
            char c = inputString.charAt(i);
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }

            // If balance goes negative, update maxImbalance
            if (balance < maxImbalance) {
                maxImbalance = balance;
            }
        }

        // Number of swaps is the absolute value of maxImbalance
        return Math.abs(maxImbalance);
    }

    public static void main(String args[]) {
        String inputString = "())()(";
        System.out.println("Number of swaps: " + findSwapCount(inputString));
    }
}

