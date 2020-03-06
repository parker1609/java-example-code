package interviewproblem.linkedlist;

/*
 * 루프 발견: 순환 연결리스트(circular linked list)가 주어졌을 때,
 * 순환되는 부분의 첫째 노드를 반환하는 알고리즘을 작성하라. 순환 연결리스트란 노드의
 * next 포인터가 앞선 노드들 가운데 어느 하나를 가리키도록 설정되어 있는,
 * 엄밀히 말해서는 변질된 방식의 연결리스트를 의미한다.
 * 예제
 * 입력: A-> ->C->D->E->C (앞에 나온 C와 같음)
 * 출력: C
 */
public class Problem8 {

    public static LinkedListNode solve(LinkedListNode head) {
        LinkedListNode fast = head;
        LinkedListNode slow = head;

        /*
         * LOOP_SIZE = 루프 크기(루프를 이루는 노드의 총 개수)
         * k = 리스트 시작점에서 루프 시작 지점 전까지의 개수(루프 시작점은 포함하지 않는다.)
         */
        /* 만나는 지점을 찾는다. 연결리스트 안에서 LOOP_SIZE - k만큼 들어간 상태이다. */
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {  // 충돌한다면
                break;
            }
        }

        /* 에러 체크, 만나는 지점이 없다면 루프도 없다. */
        if (fast == null || fast.next == null) {
            return null;
        }

        /*
         * 루프가 있다면, slow 는 head 로 옮기고, fast 는 그대로 둔다.
         * 이 둘은 루프 시작점에서 각각 k만큼 떨어져 있다.
         * 이 둘을 같은 속도로 움직인다면 루프 시작점에서 만나게 된다.
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        /* fast, slow 둘 다 루프 시작점을 가르킨다. */
        return fast;
    }
}
