package sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {
    private Sort sort;

    @Test
    @DisplayName("삽입 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void insertion_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort = new InsertionSort();
        sort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }

    @Test
    @DisplayName("선택 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void selection_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort = new SelectionSort();
        sort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }

    @Test
    @DisplayName("버블 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void bubble_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort = new BubbleSort();
        sort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }

    @Test
    @DisplayName("병합 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void merge_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort = new MergeSort();
        sort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }

    @Test
    @DisplayName("퀵 정렬이 정상적으로 동작하는지 확인한다.(오름 차순)")
    void quick_sort() {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        sort = new QuickSort();
        sort.run(arr);

        assertThat(arr).isSorted();
        assertThat(arr[0]).isEqualTo(1);
        assertThat(arr[9]).isEqualTo(10);
    }
}
