package studytest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SwapTest {
    @Test
    void primitive_integer_swap() {
        int a = 1;
        int b = 2;
        swapPrimitiveInt(a, b);

        assertThat(a).isEqualTo(1);
        assertThat(b).isEqualTo(2);
    }

    private void swapPrimitiveInt(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    @Test
    void object_integer_swap() {
        IntegerHolder a = new IntegerHolder(1);
        IntegerHolder b = new IntegerHolder(2);
        swapObjectInt(a, b);

        assertThat(a.getValue()).isEqualTo(2);
        assertThat(b.getValue()).isEqualTo(1);
    }

    private void swapObjectInt(IntegerHolder a, IntegerHolder b) {
        int temp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(temp);
    }

    static class IntegerHolder {
        private int value;

        public IntegerHolder(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
