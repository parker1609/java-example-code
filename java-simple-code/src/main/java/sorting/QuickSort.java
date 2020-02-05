package sorting;

public class QuickSort {
    public static void run(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] arr, int left, int right) {
        int mid = partition(arr, left, right);
        if (left < mid - 1) {  // 왼쪽 절반 정렬
            quickSort(arr, left, mid - 1);
        }
        if (mid < right) {     // 오른쪽 절반 정렬
            quickSort(arr, mid, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];  // 분할 기준 원소 선정
        while (left <= right) {
            // 왼쪽에서 오른쪽으로 옮겨야 하는 원소 탐색
            while (arr[left] < pivot) left++;

            // 오른쪽에서 왼쪽으로 옮겨야 하는 원소 탐색
            while (arr[right] > pivot) right--;

            // 원소를 스왑한 뒤 left와 right를 이동
            if (left <= right) {
                swap(arr, left, right);  // 스왑
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
