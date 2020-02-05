package search;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchTest {

    @Test
    @DisplayName("반복문과 재귀로 구현된 이진 탐색을 각각 확인한다.")
    void binary_search() {
        /* 이진 탐색을 사용하려면 해당 배열은 정렬되어 있어야 한다. */
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        assertThat(BinarySearch.iterator(arr, 7)).isEqualTo(true);
        assertThat(BinarySearch.iterator(arr, 11)).isEqualTo(false);

        assertThat(BinarySearch.recursive(arr, 7, 0, arr.length - 1)).isEqualTo(true);
        assertThat(BinarySearch.recursive(arr, 11, 0, arr.length - 1)).isEqualTo(false);
    }
}
