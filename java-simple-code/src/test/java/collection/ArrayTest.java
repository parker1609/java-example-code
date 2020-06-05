package collection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest {

    @Test
    void String_Array() {
        String[] array = { "aa", "bb", "cc"};
        List<String> list = new ArrayList<>();
        String[] strs = new String[list.size()];
    }

    @Test
    void array_call() {
        String[] array = {"a", "b", "c"};
        convertUpperCase(array);

        for (String s : array) {
            System.out.println(s);
        }
    }

    private void convertUpperCase(String[] array) {
        for (int i=0; i<array.length; ++i) {
            array[i] = array[i].toUpperCase();
        }

        // 아래는 callee에 영향을 못미침
//       for (String s : array) {
//            s = s.toUpperCase();
//        }
    }
}
