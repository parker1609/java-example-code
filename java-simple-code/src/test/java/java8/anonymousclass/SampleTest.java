package java8.anonymousclass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SampleTest {
    public class MeaningOfThis {
        public final int value = 4;
        public void doIt() {
            int value = 6;
            Runnable r = new Runnable() {
                public final int value = 5;
                @Override
                public void run() {
                    int value = 10;
                    System.out.println(this.value);
                }
            };
            r.run();
        }
    }

    @Test
    @DisplayName("익명 클래스 this 범위")
    void test1() {
        MeaningOfThis m = new MeaningOfThis();
        m.doIt();
    }
}
