package interviewproblem.linkedlist;

/*
 * 중간 노드 삭제: 단방향 연결리스트가 주어졌을 때 중간(정확히 가운데 노드일 필요는 없고
 * 처음과 끝 노드만 아니면 된다)에 있는 노드 하나를 삭제하는 알고리즘을 구현하라.
 * 단, 삭제할 노드에만 접근할 수 있다.
 * 예제
 * 입력: 연결리스트 a->b->c->d->e 에서 노드 c
 * 결과: 아무것도 반환할 필요는 없지만, 결과로 연결리스트 a->b->d->e가 되어 있어야 한다.
 */
public class Problem3 {

    /*
     * 삭제할 노드에만 접근할 수 있다는 말은 head 에도 접근할 수 없다는 말이다.
     */
    public static void solve(LinkedListNode delete) {
        if (delete == null || delete.next == null) {
            throw new IllegalArgumentException();
        }

        LinkedListNode nextNode = delete.next;
        delete.data = nextNode.data;
        delete.next = nextNode.next;
    }
}
