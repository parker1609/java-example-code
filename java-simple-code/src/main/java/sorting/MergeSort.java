package sorting;

public class MergeSort implements Sort {

    @Override
    public void run(int[] array) {
        int[] helper = new int[array.length];
        mergeSort(array, 0, array.length - 1, helper);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] helper) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid, helper);
            mergeSort(arr, mid + 1, right, helper);
            mergeTwoArea(arr, left, mid, right, helper);
        }
    }

    private static void mergeTwoArea(int[] arr, int left, int mid, int right, int[] helper) {
        int leftAreaIdx = left;
        int rightAreaIdx = mid + 1;

        int sortArrIdx = left;

        while (leftAreaIdx <= mid && rightAreaIdx <= right) {
            if (arr[leftAreaIdx] < arr[rightAreaIdx]) {
                helper[sortArrIdx] = arr[leftAreaIdx++];
            } else {
                helper[sortArrIdx] = arr[rightAreaIdx++];
            }
            sortArrIdx++;
        }

        if (leftAreaIdx <= mid) {
            for (int i = leftAreaIdx; i <= mid; ++i) {
                helper[sortArrIdx++] = arr[i];
            }
        } else if (rightAreaIdx <= right) {
            for (int i = rightAreaIdx; i <= right; ++i) {
                helper[sortArrIdx++] = arr[i];
            }
        }

        for (int i = left; i <= right; ++i) {
            arr[i] = helper[i];
        }
    }
}
