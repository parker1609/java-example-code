package search;

public class BinarySearch {
    public static boolean iterator(int [] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (arr[mid] < target) {
                low = mid + 1;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    public static boolean recursive(int[] arr, int target, int low, int high) {
        if (low > high) {
            return false;
        }

        int mid = (low + high) / 2;
        if (arr[mid] < target) {
            return recursive(arr, target, mid + 1, high);
        } else if (arr[mid] > target) {
            return recursive(arr, target, low, mid - 1);
        } else {
            return true;
        }
    }
}
