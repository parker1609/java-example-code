package interviewproblem.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LinkedListNodeTest {

    @Test
    void add() {
        LinkedListNode head = new LinkedListNode(1);
        head.add(head, new LinkedListNode(2));

        assertThat(head.data).isEqualTo(1);
        assertThat(head.next.data).isEqualTo(2);

        head.add(head, new LinkedListNode(3));
        assertThat(head.next.next.data).isEqualTo(3);
    }
}
