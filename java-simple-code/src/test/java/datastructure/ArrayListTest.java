package datastructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArrayListTest {
    private ArrayList<Integer> array = new ArrayList<>();

    @BeforeEach
    void setup() {
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
    }

    @Test
    @DisplayName("ArrayList 내부 값을 확인한다.")
    void get() {
        assertThat(array.size()).isEqualTo(5);
        assertThat(array.get(0)).isEqualTo(1);
        assertThat(array.get(1)).isEqualTo(2);
        assertThat(array.get(2)).isEqualTo(3);
        assertThat(array.get(3)).isEqualTo(4);
        assertThat(array.get(4)).isEqualTo(5);
    }

    @Test
    @DisplayName("get()에서 유효하지 않은 인덱스로 접근하는 경우 예외가 발생한다.")
    void get_error() {
        assertThrows(IllegalArgumentException.class, () -> array.get(-1));
        assertThrows(IllegalArgumentException.class, () -> array.get(100));
    }

    @Test
    @DisplayName("add(index, element)로 ArrayList 중간에 값을 정상적으로 삽입하는지 확인한다.")
    void add() {
        array.add(0, -1);
        assertThat(array.get(0)).isEqualTo(-1);
        assertThat(array.get(1)).isEqualTo(1);
        assertThat(array.get(2)).isEqualTo(2);
        assertThat(array.get(3)).isEqualTo(3);
        assertThat(array.get(4)).isEqualTo(4);
        assertThat(array.get(5)).isEqualTo(5);

        array.add(3, 3);
        assertThat(array.get(0)).isEqualTo(-1);
        assertThat(array.get(1)).isEqualTo(1);
        assertThat(array.get(2)).isEqualTo(2);
        assertThat(array.get(3)).isEqualTo(3);
        assertThat(array.get(4)).isEqualTo(3);
        assertThat(array.get(5)).isEqualTo(4);
        assertThat(array.get(6)).isEqualTo(5);
    }

    @Test
    @DisplayName("ArrayList 요소가 정상적으로 제거되는지 확인한다.")
    void remove() {
        array.remove(0);
        assertThat(array.get(0)).isEqualTo(2);
        assertThat(array.get(1)).isEqualTo(3);
        assertThat(array.get(2)).isEqualTo(4);
        assertThat(array.get(3)).isEqualTo(5);

        array.remove(2);
        assertThat(array.get(0)).isEqualTo(2);
        assertThat(array.get(1)).isEqualTo(3);
        assertThat(array.get(2)).isEqualTo(5);
    }
}
