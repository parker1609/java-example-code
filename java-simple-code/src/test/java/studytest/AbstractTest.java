package studytest;

import org.junit.jupiter.api.Test;

public class AbstractTest {
    @Test
    void test1() {
        Animal dog = new Dog("바둑이", 3);
        dog.speak();
    }

    @Test
    void final_test() {
        final Animal dog = new Dog("abc", 3);
        dog.setName("def");
        System.out.println(dog.getName());
    }
}
