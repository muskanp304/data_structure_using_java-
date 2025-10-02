import java.util.Deque;
import java.util.ArrayDeque;

class Tester {
    
    public static Deque<Object> mergeQueue(Deque<Integer> intQueue, Deque<Character> charQueue) {
        Deque<Object> mergedQueue = new ArrayDeque<>();

        // Merge while both queues have elements
        while (!intQueue.isEmpty() && !charQueue.isEmpty()) {
            mergedQueue.add(intQueue.poll());     // Add from intQueue first
            mergedQueue.add(charQueue.poll());    // Then from charQueue
        }

        // Add remaining elements from intQueue (if any)
        while (!intQueue.isEmpty()) {
            mergedQueue.add(intQueue.poll());
        }

        // Add remaining elements from charQueue (if any)
        while (!charQueue.isEmpty()) {
            mergedQueue.add(charQueue.poll());
        }

        return mergedQueue;
    }

    public static void main(String[] args) {
		
        Deque<Integer> integerQueue = new ArrayDeque<>();
        integerQueue.add(3);
        integerQueue.add(6);
        integerQueue.add(9);
		
        Deque<Character> characterQueue = new ArrayDeque<>();
        characterQueue.add('a');
        characterQueue.add('e');
        characterQueue.add('i');
        characterQueue.add('o');
        characterQueue.add('u');
        characterQueue.add('b');
		
        Deque<Object> mergedQueue = mergeQueue(integerQueue, characterQueue);
		
        System.out.println("The elements in the merged queue are:");
        for (Object element : mergedQueue)
            System.out.println(element);
	}
}
