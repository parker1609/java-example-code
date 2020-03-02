package sorting;

public class QuickSort implements Sort {

    @Override
    public void run(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left <= right) {
            int pivot = partition(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int low = left + 1;
        int high = right;

        while (low <= high) {
            while (low <= right && pivot >= arr[low])
                low++;
            while (high >= (left + 1) && pivot <= arr[high])
                high--;

            if (low <= high) {
                swap(arr, low, high);
            }
        }

        swap(arr, left, high);

        return high;
    }

    private static void swap(int[] arr, int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}
