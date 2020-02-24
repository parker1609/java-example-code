package java8.behaviorparameterization.apple;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FilteringApplesTest {

    @Test
    @DisplayName("인터페이스 추상화로 동작 파라미터 사용하기")
    void test1() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155), new Apple("red", 120));

        List<Apple> heavyApples = FilteringApples.filterApples(inventory, new AppleHeavyWeightPredicate());
        List<Apple> greenApples = FilteringApples.filterApples(inventory, new AppleGreenColorPredicate());

        assertThat(heavyApples).hasSize(1);
        assertThat(greenApples).hasSize(2);
    }

    @Test
    @DisplayName("익명 클래스로 동작 파라미터 사용하기")
    void test2() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155), new Apple("red", 120));

        List<Apple> heavyApples = FilteringApples.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getWeight() > 150;
            }
        });
        List<Apple> greenApples = FilteringApples.filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return "green".equals(apple.getColor());
            }
        });

        assertThat(heavyApples).hasSize(1);
        assertThat(greenApples).hasSize(2);
    }

    @Test
    @DisplayName("람다로 동작 파라미터 사용하기")
    void test3() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155), new Apple("red", 120));

        List<Apple> heavyApples = FilteringApples.filterApples(inventory,
                (Apple apple) -> apple.getWeight() > 150);
        List<Apple> greenApples = FilteringApples.filterApples(inventory,
                (Apple apple) -> "green".equals(apple.getColor()));

        assertThat(heavyApples).hasSize(1);
        assertThat(greenApples).hasSize(2);
    }

    @Test
    @DisplayName("제네릭으로 만든 Predicate 인터페이스 사용")
    void test4() {
        List<Apple> inventory = Arrays.asList(new Apple("green", 80),
                new Apple("green", 155), new Apple("red", 120));

        List<Apple> heavyApples = FilteringApples.genericFilter(inventory,
                (Apple apple) -> apple.getWeight() > 150);
        List<Apple> greenApples = FilteringApples.genericFilter(inventory,
                (Apple apple) -> "green".equals(apple.getColor()));

        assertThat(heavyApples).hasSize(1);
        assertThat(greenApples).hasSize(2);
    }
}
