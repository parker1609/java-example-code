package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LinkedListTest {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    @BeforeEach
    void setup() {
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
    }

    @Test
    @DisplayName("ArrayList 내부 값을 확인한다.")
    void get() {
        assertThat(linkedList.size()).isEqualTo(5);
        assertThat(linkedList.get(0)).isEqualTo(1);
        assertThat(linkedList.get(1)).isEqualTo(2);
        assertThat(linkedList.get(2)).isEqualTo(3);
        assertThat(linkedList.get(3)).isEqualTo(4);
        assertThat(linkedList.get(4)).isEqualTo(5);
    }

    @Test
    @DisplayName("get()에서 유효하지 않은 인덱스로 접근하는 경우 예외가 발생한다.")
    void get_error() {
        assertThrows(IllegalArgumentException.class, () -> linkedList.get(-1));
        assertThrows(IllegalArgumentException.class, () -> linkedList.get(100));
    }

    @Test
    @DisplayName("add(index, element)로 ArrayList 중간에 값을 정상적으로 삽입하는지 확인한다.")
    void add() {
        linkedList.add(0, -1);
        assertThat(linkedList.get(0)).isEqualTo(-1);
        assertThat(linkedList.get(1)).isEqualTo(1);
        assertThat(linkedList.get(2)).isEqualTo(2);
        assertThat(linkedList.get(3)).isEqualTo(3);
        assertThat(linkedList.get(4)).isEqualTo(4);
        assertThat(linkedList.get(5)).isEqualTo(5);

        linkedList.add(3, 3);
        assertThat(linkedList.get(0)).isEqualTo(-1);
        assertThat(linkedList.get(1)).isEqualTo(1);
        assertThat(linkedList.get(2)).isEqualTo(2);
        assertThat(linkedList.get(3)).isEqualTo(3);
        assertThat(linkedList.get(4)).isEqualTo(3);
        assertThat(linkedList.get(5)).isEqualTo(4);
        assertThat(linkedList.get(6)).isEqualTo(5);
    }

    @Test
    @DisplayName("ArrayList 요소가 정상적으로 제거되는지 확인한다.")
    void remove() {
        linkedList.remove(0);
        assertThat(linkedList.get(0)).isEqualTo(2);
        assertThat(linkedList.get(1)).isEqualTo(3);
        assertThat(linkedList.get(2)).isEqualTo(4);
        assertThat(linkedList.get(3)).isEqualTo(5);

        linkedList.remove(2);
        assertThat(linkedList.get(0)).isEqualTo(2);
        assertThat(linkedList.get(1)).isEqualTo(3);
        assertThat(linkedList.get(2)).isEqualTo(5);

        linkedList.removeFirst();
        assertThat(linkedList.get(0)).isEqualTo(3);
        assertThat(linkedList.get(1)).isEqualTo(5);

        linkedList.removeLast();
        assertThat(linkedList.get(0)).isEqualTo(3);
    }

    @Test
    void indexOf_test() {
        int findIndex = linkedList.indexOf(4);

        assertThat(findIndex).isEqualTo(3);
    }
}
