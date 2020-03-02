package sorting;

public class BubbleSort implements Sort {
    @Override
    public void run(int[] array) {
        bubbleSort(array, array.length);
    }

    private static void bubbleSort(int[] array, int size) {
        for (int i = 0; i < size - 1; ++i) {
            for (int j = 0; j < (size - i - 1); ++j) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
