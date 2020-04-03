package studytest;

import org.junit.jupiter.api.Test;

public class AbstractTest {
    @Test
    void test1() {
        Animal dog = new Dog("바둑이", 3);
        dog.speak();
    }
}
