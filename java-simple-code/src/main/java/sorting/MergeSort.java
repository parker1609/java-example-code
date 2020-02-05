package sorting;

public class MergeSort {
    public static void run(int[] array) {
        int[] helper = new int[array.length];
        mergeSorting(array, helper, 0, array.length - 1);
    }

    private static void mergeSorting(int[] array, int[] helper, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSorting(array, helper, low, mid);  // 왼쪽 절반 정렬
            mergeSorting(array, helper, mid + 1, high);  // 오른쪽 절반 정렬
            merge(array, helper, low, mid, high);  // 병합
        }
    }

    private static void merge(int[] array, int[] helper, int low, int mid, int high) {
        /* 절반짜리 두 배열을 helper 배열에 복사한다. */
        for (int i = low; i <= high; ++i) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = mid + 1;
        int current = low;

        /* helper 배열 순회. 왼쪽 절반과 오른쪽 절반을 비교하여 작은 원소를
         * 절반짜리 두 배열을 helper 배열에 복사한다. */
        while (helperLeft <= mid && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current] = helper[helperLeft];
                helperLeft++;
            } else {  // 오른쪽 원소가 왼쪽 원소보다 작으면
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        /* 왼쪽 절반 배열에 남은 원소들을 원래 배열에 복사해 넣는다. */
        int remaining = mid - helperLeft;
        for (int i = 0; i <= remaining; ++i) {
            array[current + i] = helper[helperLeft + i];
        }
    }
}
