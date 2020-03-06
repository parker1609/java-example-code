package interviewproblem.linkedlist;

/*
 * 교집합: 단방향 연결리스트 두 개가 주어졌을 때 이 두 리스트의 교집합 노드를 찾은 뒤
 * 반환하는 코드를 작성하라. 여기서 교집합이란 노드의 값이 아니라 노드의 주소가 완전히
 * 같은 경우를 말한다. 즉, 첫 번째 리스트에 있는 k 번째 노드와 두 번째 리스트에 있는
 * j 번째 노드가 주소까지 완전히 같다면 이 노드는 교집합의 원소가 된다.
 */
public class Problem7 {

    public static class Result {
        public LinkedListNode tail;
        public int size;

        public Result(LinkedListNode tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public static LinkedListNode solve(LinkedListNode n1, LinkedListNode n2) {
        if (n1 == null || n2 == null) {
            return null;
        }

        /* 마지막 노드와 길이를 구한다 */
        Result r1 = getTailAndSize(n1);
        Result r2 = getTailAndSize(n2);

        /* 마지막 노드가 다르면 교집합이 없다는 뜻이다. */
        if (r1.tail != r2.tail) {
            return null;
        }

        /* 각 연결리스트 시작점에 포인터를 세팅한다. */
        LinkedListNode longer = r1.size > r2.size ? n1 : n2;
        LinkedListNode shorter = r1.size > r2.size ? n2 : n1;

        /* 길이가 더 긴 리스트를 길이가 짧은 리스트와 길이가 같도록 앞으로 당긴다. */
        longer = getKThNode(longer, Math.abs(r1.size - r2.size));

        /* 두 포인터가 만날 때까지 포인터를 움직인다. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* 둘 중 아무 포인터나 반환한다. */
        return longer;
    }

    private static Result getTailAndSize(LinkedListNode node) {
        int size = 1;
        while (node.next != null) {
            size++;
            node = node.next;
        }

        return new Result(node, size);
    }

    private static LinkedListNode getKThNode(LinkedListNode node, int k) {
        while (k > 0) {
            node = node.next;
            k--;
        }

        return node;
    }
}
