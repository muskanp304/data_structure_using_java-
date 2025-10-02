package LinkedList2.Assignment;
import java.util.LinkedList;

class Queue {
    private LinkedList<String> list;
    private int capacity;

    public Queue(int capacity) {
        this.capacity = capacity;
        this.list = new LinkedList<>();
    }

    public void enqueue(String element) {
        if (list.size() == capacity) {
            System.out.println("Queue is full. Cannot enqueue " + element);
            return;
        }
        list.addLast(element);
    }

    public String dequeue() {
        if (list.isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        return list.removeFirst();
    }

    public LinkedList<String> getQueue() {
        return list;
    }
}

public class ass4 {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue("Emily");
        queue.enqueue("Lily");
        queue.enqueue("Rachel");
        queue.enqueue("Rose");

        queue.dequeue();
        queue.dequeue();

        System.out.println(queue.getQueue());
    }
}
