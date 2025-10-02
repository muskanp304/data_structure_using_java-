package LinkedList1.Assignment;
class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String getData() {
        return this.data;
    }

    public Node getNext() {
        return this.next;
    }
}

class LinkedList {
    private Node head;
    private Node tail;

    public Node getHead() {
        return this.head;
    }

    public Node getTail() {
        return this.tail;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void addAtEnd(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            this.tail.setNext(node);
            this.tail = node;
        }
    }

    public void addAtBeginning(String data) {
        Node node = new Node(data);

        if (this.head == null) {
            this.head = this.tail = node;
        } else {
            node.setNext(this.head);
            this.head = node;
        }
    }

    public void display() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
}

class Tester {
    public static void main(String args[]) {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addAtEnd("ABC");
        linkedList1.addAtEnd("DFG");
        linkedList1.addAtEnd("XYZ");
        linkedList1.addAtEnd("EFG");

        LinkedList linkedList2 = new LinkedList();
        linkedList2.addAtEnd("ABC");
        linkedList2.addAtEnd("DFG");
        linkedList2.addAtEnd("XYZ");
        linkedList2.addAtEnd("EFG");

        System.out.println("Initial List");
        linkedList1.display();

        System.out.println("\nList after left shifting by 2 positions");
        shiftListLeft(linkedList1, 2);
        linkedList1.display();

        System.out.println("\nInitial List");
        linkedList2.display();

        System.out.println("\nList after right shifting by 2 positions");
        shiftListRight(linkedList2, 2);
        linkedList2.display();
    }

    // LEFT SHIFT
    public static void shiftListLeft(LinkedList linkedList, int n) {
        if (linkedList.getHead() == null || n == 0) return;

        // Find length
        int length = 0;
        Node temp = linkedList.getHead();
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        n = n % length; // handle n > length
        if (n == 0) return;

        // Move to (n-1)th node
        Node curr = linkedList.getHead();
        for (int i = 1; i < n; i++) {
            curr = curr.getNext();
        }

        Node newHead = curr.getNext();
        Node newTail = curr;

        // Connect old tail to old head
        linkedList.getTail().setNext(linkedList.getHead());

        // Break the connection
        newTail.setNext(null);

        // Update head and tail
        linkedList.setHead(newHead);
        linkedList.setTail(newTail);
    }

    // RIGHT SHIFT
    public static void shiftListRight(LinkedList linkedList, int n) {
        if (linkedList.getHead() == null || n == 0) return;

        // Find length
        int length = 0;
        Node temp = linkedList.getHead();
        while (temp != null) {
            length++;
            temp = temp.getNext();
        }

        n = n % length;
        if (n == 0) return;

        // Right shift by n = Left shift by (length - n)
        shiftListLeft(linkedList, length - n);
    }
}
