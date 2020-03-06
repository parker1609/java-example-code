package interviewproblem.linkedlist;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListProblemTest {

    @Test
    void problem_1_solve() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(4);

        Problem1.solve(head);

        assertThat(head.data).isEqualTo(1);
        assertThat(head.next.data).isEqualTo(2);
        assertThat(head.next.next.data).isEqualTo(4);
    }

    @Test
    void problem_1_solveWithoutBuffer() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(1);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(4);

        Problem1.solveWithoutBuffer(head);

        assertThat(head.data).isEqualTo(1);
        assertThat(head.next.data).isEqualTo(2);
        assertThat(head.next.next.data).isEqualTo(4);
    }

    @Test
    void problem_2_1() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        assertThat(Problem2.solve1(head, 1)).isEqualTo(5);
        assertThat(Problem2.solve1(head, 2)).isEqualTo(4);
        assertThat(Problem2.solve1(head, 3)).isEqualTo(3);
        assertThat(Problem2.solve1(head, 4)).isEqualTo(2);
        assertThat(Problem2.solve1(head, 5)).isEqualTo(1);
    }

    @Test
    void problem_2_2() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        assertThat(Problem2.solve2(head, 1)).isEqualTo(5);
        assertThat(Problem2.solve2(head, 2)).isEqualTo(4);
        assertThat(Problem2.solve2(head, 3)).isEqualTo(3);
        assertThat(Problem2.solve2(head, 4)).isEqualTo(2);
        assertThat(Problem2.solve2(head, 5)).isEqualTo(1);
    }

    @Test
    void problem_2_3() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        assertThat(Problem2.solve3(head, 1)).isEqualTo(5);
        assertThat(Problem2.solve3(head, 2)).isEqualTo(4);
        assertThat(Problem2.solve3(head, 3)).isEqualTo(3);
        assertThat(Problem2.solve3(head, 4)).isEqualTo(2);
        assertThat(Problem2.solve3(head, 5)).isEqualTo(1);
    }

    @Test
    void problem_3() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);

        // node 2를 삭제
        Problem3.solve(head.next);

        assertThat(head.data).isEqualTo(1);
        assertThat(head.next.data).isEqualTo(3);
        assertThat(head.next.next.data).isEqualTo(4);
        assertThat(head.next.next.next.data).isEqualTo(5);
    }

    @Test
    void problem_4_stable() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next.next = new LinkedListNode(5);
    }

    @Test
    void problem_5_1() {
        LinkedListNode n1 = new LinkedListNode(7);
        n1.next = new LinkedListNode(1);
        n1.next.next = new LinkedListNode(6);

        LinkedListNode n2 = new LinkedListNode(5);
        n2.next = new LinkedListNode(9);
        n2.next.next = new LinkedListNode(2);

        assertThat(Problem5.solve(n1, n2)).isEqualTo(912);
    }

    @Test
    void problem_5_2() {
        LinkedListNode n1 = new LinkedListNode(6);
        n1.next = new LinkedListNode(1);
        n1.next.next = new LinkedListNode(7);

        LinkedListNode n2 = new LinkedListNode(2);
        n2.next = new LinkedListNode(9);
        n2.next.next = new LinkedListNode(5);

        assertThat(Problem5.solve2(n1, n2)).isEqualTo(912);
    }

    @Test
    void problem_6_1() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);

        assertTrue(Problem6.isPalindromeReverse(head));

        head.next.next.next.next = new LinkedListNode(3);
        assertFalse(Problem6.isPalindromeReverse(head));
    }

    @Test
    void problem_6_2() {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(2);
        head.next.next.next = new LinkedListNode(1);

        assertTrue(Problem6.isPalindromeIter(head));

        head.next.next.next.next = new LinkedListNode(3);
        assertFalse(Problem6.isPalindromeIter(head));
    }
}
