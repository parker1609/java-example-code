package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

    @Test
    @DisplayName("병합 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void merge_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        MergeSort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }

    @Test
    @DisplayName("퀵 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void quick_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        QuickSort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }
}
