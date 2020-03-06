package interviewproblem.linkedlist;

import java.util.HashSet;

/*
 * 중복 없애기: 정렬되어 있지 않은 연결리스트가 주어졌을 때 이 리스트에서 중복되는 원소를 제거하는 코드를 작성하라.
 * 연관 문제
 * 임시 버퍼를 사용할 수 없다면 어떻게 풀까?
 */
public class Problem1 {

    public static void solve(LinkedListNode n) {
        HashSet<Integer> unique = new HashSet<>();
        LinkedListNode previous = null;
        while (n != null) {
            if (unique.contains(n.data)) {
                previous.next = n.next;
            } else {
                unique.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }

    /*
     * 버퍼가 없는 경우(set과 같은 자료구조를 사용할 수 없는 경우로 이해함)
     */
    public static void solveWithoutBuffer(LinkedListNode n) {
        LinkedListNode runner = null;
        LinkedListNode previous = null;
        while (n != null) {
            runner = n.next;
            previous = n;
            while ( runner != null) {
                if (n.data == runner.data) {
                    previous.next = runner.next;
                } else {
                    previous = runner;
                }
                runner = runner.next;
            }
            n = n.next;
        }
    }
}
