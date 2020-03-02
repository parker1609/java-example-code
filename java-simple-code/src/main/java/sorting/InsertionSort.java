package sorting;

public class InsertionSort implements Sort {
    @Override
    public void run(int[] array) {
        insertionSort(array, array.length);
    }

    private static void insertionSort(int[] array, int size) {
        for (int i = 1; i < size; ++i) {
            int insertionData = array[i];

            int insertionIndex;
            for (insertionIndex = i - 1; insertionIndex >= 0; --insertionIndex) {
                if (array[insertionIndex] > insertionData) {
                    array[insertionIndex + 1] = array[insertionIndex];
                } else {
                    break;
                }
            }

            array[insertionIndex + 1] = insertionData;
        }
    }
}
