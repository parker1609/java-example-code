package java8.behaviorparameterization.apple;

import java.util.ArrayList;
import java.util.List;

public class FilteringApples {

    /* 추상적 조건으로 필터링 */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 프레디케이트 객체로 사과 검사 조건을 캡슐화했다.
            if (p.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static <T> List<T> genericFilter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T e: list) {
            if (p.test(e)) {
                result.add(e);
            }
        }

        return result;
    }
}
