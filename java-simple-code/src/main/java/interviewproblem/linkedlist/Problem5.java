package interviewproblem.linkedlist;

/*
 * 리스트의 합: 연결리스트로 숫자를 표현할 때 각 노드가 자릿수 하나를 가리키는 방식으로
 * 표현할 수 있다. 각 숫자는 역순으로 배열되어있는데, 즉, 첫 번째 자릿수가 리스트의
 * 맨 앞에 위치하도록 배열된다는 뜻이다. 이와 같은 방식으로 표현된 숫자 두 개가 있을 때,
 * 이 두 수를 더하여 그 합을 연결리스트로 반환하는 함수를 작성하라.
 * 예제
 * 입력: (7->1->6) + (5->9->2). 즉, 617 + 295.
 * 출력: 2->1->9. 즉, 912.
 *
 * 연관 문제
 * 각 자릿수가 정상적으로 배열된다고 가정하고 같은 문제를 풀어 보자.
 * 예제
 * 입력: (6->1->7) + (2->9->5). 즉, 617 + 295.
 * 출력: 9->1->2. 즉, 912.
 */
public class Problem5 {

    public static int solve(LinkedListNode n1, LinkedListNode n2) {
        int num1 = 0, num2 = 0;
        int d = 1;
        while (n1 != null) {
            num1 += n1.data * d;
            d *= 10;
            n1 = n1.next;
        }

        d = 1;
        while (n2 != null) {
            num2 += n2.data * d;
            d *= 10;
            n2 = n2.next;
        }

        return num1 + num2;
    }

    public static int solve2(LinkedListNode n1, LinkedListNode n2) {
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while (n1 != null) {
            num1.append(n1.data);
            n1 = n1.next;
        }

        while (n2 != null) {
            num2.append(n2.data);
            n2 = n2.next;
        }

        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }
}
