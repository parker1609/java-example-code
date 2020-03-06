package interviewproblem.linkedlist;

import java.util.Stack;

/*
 * 회문(palindrome): 주어진 연결리스트가 회문인지를 검사하는 함수를 작성하라.
 */
public class Problem6 {

    /*
     * 1) 뒤집어서 비교하기
     */

    public static boolean isPalindromeReverse(LinkedListNode head) {
        LinkedListNode reversed = reverseAndClone(head);
        return isEqual(head, reversed);
    }

    private static LinkedListNode reverseAndClone(LinkedListNode head) {
        LinkedListNode reversed = null;
        while (head != null) {
            LinkedListNode node = new LinkedListNode(head.data);
            node.next = reversed;
            reversed = node;
            head = head.next;
        }

        return reversed;
    }

    private static boolean isEqual(LinkedListNode normal, LinkedListNode reversed) {
        while (normal != null && reversed != null) {
            if (normal.data != reversed.data) {
                return false;
            }
            normal = normal.next;
            reversed = reversed.next;
        }

        return normal == null && reversed == null;
    }

    /*
     * 2) 순환적 접근 (stack 이용)
     * 리스트의 길이를 안다면 for 문으로, 모른다면 slow, fast 두 포인터 사용
     */
    public static boolean isPalindromeIter(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        Stack<Integer> s = new Stack<>();

        /*
         * 연결리스트의 앞 절반을 스택에 쌓는다.
         * fast runner(2배 빠른)가 끝에 도달했다면, slow runner 는 중간에 도달했다는 것을 알 수 있다.
         */
        while (fast != null && fast.next != null) {
            s.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        /* 원소의 개수가 홀 수개라면 가운데 원소는 넘긴다. */
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            Integer top = s.pop();
            if (slow.data != top) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }
}
