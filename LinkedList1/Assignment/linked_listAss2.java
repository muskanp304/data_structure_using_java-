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
        LinkedList linkedList = new LinkedList();
        LinkedList reversedLinkedList = new LinkedList();

        linkedList.addAtEnd("Data");
        linkedList.addAtEnd("Structures");
        linkedList.addAtEnd("and");
        linkedList.addAtEnd("Algorithms");

        System.out.println("Initial List");
        linkedList.display();

        System.out.println();

        reverseList(linkedList.getHead(), reversedLinkedList);
        System.out.println("Reversed List");
        reversedLinkedList.display();
    }

    // Recursive reverse
    public static void reverseList(Node head, LinkedList reversedLinkedList) {
        if (head == null) {
            return;
        }

        // go to the end
        reverseList(head.getNext(), reversedLinkedList);

        // add while backtracking
        reversedLinkedList.addAtEnd(head.getData());
    }
}
