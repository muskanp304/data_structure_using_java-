import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

 public class Exercise2 {

    public static Deque<Integer> changeSmallest(Deque<Integer> inputStack) {
        // Handle empty stack
        if (inputStack.isEmpty()) {
            return inputStack;
        }
        
        // Step 1: Extract all elements from the stack
        List<Integer> allElements = new ArrayList<>();
        while (!inputStack.isEmpty()) {
            allElements.add(inputStack.pop());
        }
        
        // Step 2: Find the minimum value
        int minValue = Collections.min(allElements);
        
        // Step 3: Separate minimum and non-minimum elements
        List<Integer> nonMinElements = new ArrayList<>();
        List<Integer> minElements = new ArrayList<>();
        
        for (int element : allElements) {
            if (element == minValue) {
                minElements.add(element);
            } else {
                nonMinElements.add(element);
            }
        }
        
        // Step 4: Reconstruct the stack
        // First push non-minimum elements in reverse order to maintain original sequence
        Collections.reverse(nonMinElements);
        for (int element : nonMinElements) {
            inputStack.push(element);
        }
        
        // Then push minimum elements (they will be at the bottom)
        Collections.reverse(minElements);
        for (int element : minElements) {
            inputStack.push(element);
        }
        
        return inputStack;
    }

    public static void main(String[] args) {
        
        Deque<Integer> inputStack = new ArrayDeque<Integer>();
        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);
    
        Deque<Integer> updatedStack = changeSmallest(inputStack);
        
        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
