package interviewproblem.linkedlist;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public void add(LinkedListNode head, LinkedListNode node) {
        if (head == null) {
            head = node;
        } else {
//            LinkedListNode temp = head;
            while (head.next != null) {
                head = head.next;
            }
            head.next = node;
        }
    }
}
