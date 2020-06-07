package sorting;

public class SelectionSort implements Sort {
    @Override
    public void run(int[] array) {
        selectionSort(array, array.length);
    }

    private void selectionSort(int[] array, int length) {
        for (int i = 0; i < length - 1; i++) {
            int minData = array[i];
            int minPosition = i;

            for (int j = i + 1; j < length; j++) {
                if (minData > array[j]) {
                    minData = array[j];
                    minPosition = j;
                }
            }

            int temp = array[i];
            array[i] = array[minPosition];
            array[minPosition] = temp;
        }
    }
}
