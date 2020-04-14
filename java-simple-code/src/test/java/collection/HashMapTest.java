package collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    private HashMap<String, Integer> personAge = new HashMap<>();

    @BeforeEach
    void setup() {
        personAge.put("Park", 28);
        personAge.put("Kim", 25);
        personAge.put("Lee", 27);
    }

    @Test
    void get() {
        int age = personAge.get("Park");
        System.out.println("Park age: " + age);
    }

    @Test
    void get_none() {
        int age = personAge.get("Jin");
        System.out.println("Jin age: " + age);
    }

    @Test
    void get_or_default() {
        int age = personAge.getOrDefault("Jin", 32);
        System.out.println("Jin age: " + age);
    }

    @Test
    void put_already_exist() {
        personAge.put("Park", 30);

        int age = personAge.get("Park");
        System.out.println("Park age: " + age);
    }

    @Test
    void key_for() {
        Set<String> keys = personAge.keySet();

        for (String key : keys) {
            System.out.println(key);
        }

        System.out.println("-----");

        keys.forEach(System.out::println);
    }

    @Test
    void value_for() {
        Collection<Integer> values = personAge.values();
        values.forEach(System.out::println);
    }

    @Test
    void key_value_for() {
        Set<Map.Entry<String, Integer>> entries = personAge.entrySet();

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.print("key: "+ entry.getKey());
            System.out.println(", Value: "+ entry.getValue());
        }

        personAge.forEach((key, value) -> {
            System.out.print("key: "+ key);
            System.out.println(", Value: "+ value);
        });
    }

    @Test
    void containsKey() {
        if (personAge.containsKey("Park")) {
            System.out.println("Park 은 존재합니다.");
        }
        else {
            System.out.println("Park 은 존재하지 않습니다.");
        }
    }

    @Test
    void containsValue() {
        if (personAge.containsValue(32)) {
            System.out.println("나이가 32살인 사람이 존재합니다.");
        }
        else {
            System.out.println("나이가 32살인 사람이 존재하지 않습니다.");
        }
    }
}
