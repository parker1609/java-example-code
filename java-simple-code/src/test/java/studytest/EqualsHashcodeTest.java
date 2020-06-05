package studytest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class EqualsHashcodeTest {

    @Test
    @DisplayName("객체에서 equals와 hashcode 두 메서드 모두 오버라이딩을 하지 않았을 때")
    void no_equals_no_hashcode() {
        Person person1 = new Person(20, "park");
        Person person2 = new Person(20, "park");

        assertThat(person1 == person2).isFalse();
        assertThat(person1.equals(person2)).isFalse();
        assertThat(person1.equals(person1)).isTrue();
    }

    @Test
    @DisplayName("객체에서 equals만 오버라이딩 했을 때")
    void no_hashcode() {
        Person person1 = new Person(20, "park");
        Person person2 = new Person(20, "park");

        assertThat(person1 == person2).isFalse();
        assertThat(person1.equals(person2)).isTrue();

        Set<Person> uniquePerson = new HashSet<>();
        uniquePerson.add(person1);
        uniquePerson.add(person2);
        assertThat(uniquePerson.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("객체에서 equals, hashcode 모두 오버라이딩 되어 있을 때")
    void all_overriding() {
        Person person1 = new Person(20, "park");
        Person person2 = new Person(20, "park");

        assertThat(person1 == person2).isFalse();
        assertThat(person1.equals(person2)).isTrue();

        Set<Person> uniquePerson = new HashSet<>();
        uniquePerson.add(person1);
        uniquePerson.add(person2);
        assertThat(uniquePerson.size()).isEqualTo(1);
    }
}
