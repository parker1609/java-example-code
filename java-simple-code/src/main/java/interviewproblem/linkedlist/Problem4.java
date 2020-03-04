package interviewproblem.linkedlist;

/*
 * 분할: 값 x가 주어졌을 때 x보다 작은 노드들을 x보다 크거나 같은 노드들보다
 * 앞에 오도록 하는 코드를 작성하라. 만약 x가 리스트에 있다면 x는 그보다 작은
 * 원소들보다 뒤에 나오기만 하면 된다. 즉, 원소 x는 '오른쪽 그룹' 어딘가에만
 * 존재하면된다. 왼쪽과 오른쪽 그룹 사이에 있을 필요는 없다.
 * 예제
 * 입력:3->5->8->5->10->2->1 [분할값 x=5] 
 * 출력:3->1->2->10->5->5->8
 */
public class Problem4 {

    public static LinkedListNode solveStable(LinkedListNode head, int x) {
        LinkedListNode leftGroupStart = null;
        LinkedListNode leftGroupEnd = null;
        LinkedListNode rightGroupStart = null;
        LinkedListNode rightGroupEnd = null;

        LinkedListNode node = head;
        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;

            if (node.data <  x) {
                if (leftGroupStart == null) {
                    leftGroupStart = node;
                    leftGroupEnd = leftGroupStart;
                } else {
                    leftGroupEnd.next = node;
                    leftGroupEnd = node;
                }
            } else {
                if (rightGroupStart == null) {
                    rightGroupStart = next;
                    rightGroupEnd = rightGroupStart;
                } else {
                    rightGroupEnd.next = node;
                    rightGroupEnd = node;
                }
            }
            node = next;
        }

        if (leftGroupStart == null) {
            return rightGroupStart;
        }

        leftGroupEnd.next = rightGroupStart;
        return leftGroupStart;
    }

    public static LinkedListNode solveUnStable(LinkedListNode node, int x) {
        LinkedListNode head = node;
        LinkedListNode tail = node;

        while (node != null) {
            LinkedListNode next = node.next;
            node.next = null;

            if (node.data < x) {
                // head 에 추가
                node.next = head;
                head = node;
            } else {
                // tail 에 추가
                tail.next = node;
                tail = node;
            }
            node = next;
        }

        return head;
    }
}
