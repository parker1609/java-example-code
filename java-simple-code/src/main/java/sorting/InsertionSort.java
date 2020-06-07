package sorting;

public class InsertionSort implements Sort {
    @Override
    public void run(int[] array) {
        insertionSort(array, array.length);
    }

    private static void insertionSort(int[] array, int size) {
        for (int i = 1; i < size; ++i) {
            int current = array[i];

            int pos;
            for (pos = i - 1; pos >= 0; --pos) {
                if (array[pos] > current) {
                    array[pos + 1] = array[pos];
                } else {
                    break;
                }
            }

            array[pos + 1] = current;
        }
    }
}
