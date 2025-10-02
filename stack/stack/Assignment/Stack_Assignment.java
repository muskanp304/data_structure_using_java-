package stack.stack.Assignment;

class Stack {
    
    private int top; 
    private int maxSize; 
    private int[] arr;

    Stack(int maxSize) {
        this.top = -1; 
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return (top >= (maxSize - 1));
    }

    public boolean push(int data) {
        if (isFull()) {
            return false;
        }
        arr[++top] = data;
        return true;
    }

    public int peek() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return arr[top];
    }

    public void display() {
        if (isEmpty())
            System.out.println("Stack is empty!");
        else {
            System.out.println("Displaying stack elements");
            for (int index = top; index >= 0; index--) {
                System.out.println(arr[index]); 
            }
        }
    }

    public boolean isEmpty() {
        return (top < 0);
    }

    public int pop() {
        if (isEmpty())
            return Integer.MIN_VALUE;
        return arr[top--];
    }
}


class Tester {
      
    public static void main(String args[]) {
            
        Stack stack = new Stack(10);
        stack.push(15);
        stack.push(20);
        stack.push(30);
        stack.push(40);   // Top element is 40
        
        calculateSum(stack);
            
        System.out.println("Updated stack:");
        stack.display();
    }

    public static void calculateSum(Stack stack) {
        if (stack.isEmpty()) return;

        // Step 1: calculate sum using helper
        int sum = calculateAndEmpty(stack);

        // Step 2: restore original order
        restore(stack);

        // Step 3: insert sum at bottom
        insertAtBottom(stack, sum);
    }

    // Helper: Recursively calculate sum and empty stack
    private static int calculateAndEmpty(Stack stack) {
        if (stack.isEmpty()) return 0;
        int top = stack.pop();
        int sum = top + calculateAndEmpty(stack);
        stack.push(top); // put it back
        return sum;
    }

    // Helper: Restore order (ensures stack stays same after sum calc)
    private static void restore(Stack stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        restore(stack);
        stack.push(top);
    }

    // Helper: Insert element at bottom using recursion
    private static void insertAtBottom(Stack stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, value);
        stack.push(top);
    }
}

