package sorting;

public class SelectionSort implements Sort {
    @Override
    public void run(int[] array) {
        selectionSort(array, array.length);
    }

    private static void selectionSort(int[] array, int size) {
        for (int i = 0; i < size - 1; ++i) {
            int minIdx = i;

            for (int j = i + 1; j < size; ++j) {
                if (array[minIdx] > array[j]) {
                    minIdx = j;
                }
            }

            int temp = array[i];
            array[i] = array[minIdx];
            array[minIdx] = temp;
        }
    }
}
