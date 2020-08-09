package datastructure;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class HashTest {
    @Test
    void hash_map() {
        Map<String, String> hash = new HashMap<>();

        hash.put("key1", "value1");
        hash.put("key2", "value2");
        hash.put("key3", "value3");

        assertThat(hash.get("key1")).isEqualTo("value1");
        assertThat(hash.get("key2")).isEqualTo("value2");
        assertThat(hash.get("key3")).isEqualTo("value3");
    }
}
