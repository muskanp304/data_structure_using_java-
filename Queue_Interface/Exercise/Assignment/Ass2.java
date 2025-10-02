package Assignment;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Ass2 {

    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        // Step 1: Reverse the input stack into a list to access bottom elements
        List<Character> tempList = new ArrayList<>();
        while (!inputStack.isEmpty()) {
            tempList.add(inputStack.pop());
        }

        // Step 2: Separate bottom 3 (last 3 in original stack) and rest
        List<Character> bottomThree = new ArrayList<>();
        List<Character> rest = new ArrayList<>();

        int n = tempList.size();

        for (int i = 0; i < n; i++) {
            if (i < 3) {
                // These were at the bottom originally
                bottomThree.add(tempList.get(n - 1 - i));
            } else {
                rest.add(tempList.get(n - 1 - i));
            }
        }

        // Step 3: Build the updated stack
        Deque<Character> updatedStack = new ArrayDeque<>();

        // Push the remaining elements first (in original order)
        for (Character ch : rest) {
            updatedStack.push(ch);
        }

        // Then push the bottom three (in original order)
        for (Character ch : bottomThree) {
            updatedStack.push(ch);
        }

        return updatedStack;
    }

    public static void main(String[] args) {
        Deque<Character> inputStack = new ArrayDeque<Character>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        // Stack is now: A (bottom) -> B -> C -> D -> E (top)

        Deque<Character> resultStack = updateStack(inputStack);

        System.out.println("The alphabets in updated stack are:");
        for (Character alphabet : resultStack)
            System.out.println(alphabet);
    }
}
