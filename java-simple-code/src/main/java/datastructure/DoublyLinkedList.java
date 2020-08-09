package datastructure;

public class DoublyLinkedList<T> {
    private class Node {
        private T data;
        private Node next;
        private Node prev;

        public Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node cur;
    private int numOfData;

    public DoublyLinkedList() {
        this.head = null;
        this.cur = null;
        this.numOfData = 0;
    }

    public void insert(T data) {
        Node newNode = new Node(data);

        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }

        newNode.prev = null;
        head = newNode;

        numOfData++;
    }
}
