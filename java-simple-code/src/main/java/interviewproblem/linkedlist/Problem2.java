package interviewproblem.linkedlist;

import java.util.ArrayList;
import java.util.List;

/*
 * 뒤에서 k 번 째 원소 구하기: 단방향 연결리스트가 주어졌 을 때 뒤에서
 * k번째 원소를 찾는 알고리즘을 구현하라.
 */
public class Problem2 {
    /*
     * 1) 리스트를 한 번 순회하여 전체 크기 n을 구한 뒤 (n - k) 번 리스트를 순회한 값 반환
     * 2) 리스트를 한 번 순회하면서 배열(동적배열)에 값을 순서대로 삽입안 뒤 해당 배열 인덱스가 (n-k)인 값 반환
     */
    public static int solve1(LinkedListNode head, int k) {
        int n = 0;
        LinkedListNode temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < (n - k); i++) {
            temp = temp.next;
        }

        return temp.data;
    }

    public static int solve2(LinkedListNode head, int k) {
        List<Integer> array = new ArrayList<>();
        LinkedListNode temp = head;
        while (temp != null) {
            array.add(temp.data);
            temp = temp.next;
        }

        return array.get(array.size() - k);
    }

    /*
     * 3) 포인터를 2개 두고, 하나를 K번 미리 이동한 후, 미리 이동한 포인터와 처음을 가리키는 포인터를 같이 순회한다.
     */

    public static int solve3(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                throw new IllegalArgumentException();
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2.data;
    }
}
