package studytest;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {

    @Test
    void immutable_concat() {
        String str1 = new String("Hello");
        String str2 = "Hello";
        String str2_1 = new String("Hello").intern();

        assertThat(str1 == str2).isFalse();
        assertThat(str1.equals(str2)).isTrue();
        assertThat(str2 == str2_1).isTrue();

        assertThat(str1 == (str1 + "World")).isFalse();
        assertThat(str2 == (str2 + "World")).isFalse();

        StringBuilder str3 = new StringBuilder("Hello");

        assertThat(str3 == (str3.append("World"))).isTrue();
    }
}
