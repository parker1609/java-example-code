package datastructure;

public class LinkedList<T> {
    private int size;
    private Node head;
    private Node tail;

    private class Node {
        private T data;
        private Node next;

        public Node(T input) {
            this.data = input;
            this.next = null;
        }
    }

    public LinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void addFirst(T data) {
        Node newNode = new Node(data);

        newNode.next = head;
        head = newNode;

        size++;

        if (newNode.next == null) {
            tail = head;
        }
    }

    public void addLast(T data) {
        Node newNode = new Node(data);

        if (size == 0) {
            addFirst(data);
        } else {
            tail.next = newNode;
            tail = newNode;

            size++;
        }
    }

    Node node(int index) {
        Node result = head;

        for (int i = 0; i < index; ++i) {
            result = result.next;
        }

        return result;
    }

    public void add(int index, T data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == (size - 1)) {
            addLast(data);
        } else if (index > 0 && index < (size - 1)) {
            Node newNode = new Node(data);
            Node previousNode = node(index - 1);
            Node afterNode = node(index);

            previousNode.next = newNode;
            newNode.next = afterNode;

            size++;
        } else {
            throw new IllegalArgumentException("Invalid index!");
        }
    }

    public T removeFirst() {
        if (size == 0) {
            throw new IllegalArgumentException("Not exist data!");
        }

        Node removeNode = head;
        head = removeNode.next;
        removeNode.next = null;

        size--;

        T returnData = removeNode.data;
        removeNode = null;

        return returnData;
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }

        if (index == 0) {
            return removeFirst();
        } else {
            Node removeNode = node(index);
            Node previousNode = node(index - 1);

            previousNode.next = removeNode.next;

            if (index == (size - 1)) {
                tail = previousNode;
            }

            T returnData = removeNode.data;
            removeNode = null;

            size--;

            return returnData;
        }
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid index!");
        }

        Node node = node(index);
        return node.data;
    }

    public int indexOf(T data) {
        Node iterNode = head;

        int index = 0;

        while (iterNode.data != data) {
            iterNode = iterNode.next;

            index++;

            if (iterNode == null) {
                return -1;
            }
        }

        return index;
    }
}
