package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class instanceofTest {

    @Test
    @DisplayName("자기 자신 인스턴스")
    void test_1() {
        Dog dog = new Dog("baduk", 3);

        assertThat(dog instanceof Dog).isTrue();
//        assertThat(dog instanceof Sparrow).isFalse();
    }

    @Test
    @DisplayName("부모 인스턴스")
    void test_2() {
        Dog dog = new Dog("baduk", 3);

        assertThat(dog instanceof Animal).isTrue();
    }

    @Test
    @DisplayName("부모, 자식 인스턴스")
    void test_3() {
        Animal dog = new Dog("baduk", 3);

        assertThat(dog instanceof Dog).isTrue();
        assertThat(dog instanceof Animal).isTrue();
    }
}
