public class Quicksort {
    private static Integer[] data;
    private static Integer[] sortedData;
    private static int passes = 0;

    static int partition(Integer[] inputData, int i, int k) {
        int temp;

        int midpoint = i + (k - i) / 2;
        int pivot = inputData[midpoint];

        int l = i;
        int h = k;

        boolean done = false;

        while (!done) {
            while (inputData[l] < pivot) {
                ++l;
            }
            while (pivot < inputData[h]) {
                --h;
            }

            if (l >= h) {
                done = true;
            } else {
                temp = inputData[l];
                inputData[l] = inputData[h];
                inputData[h] = temp;
                ++l;
                --h;
            }
        }

        return h;
    }

    static void quickSort(Integer[] inputData, int i, int k) {
        if (i >= k) {
            return;
        }

        int j = partition(inputData, i, k);

        quickSort(inputData, i, j);
        quickSort(inputData, j + 1, k);

        passes++;
    }

    public static void sort(Integer[] inputData) {
        data = inputData.clone();
        sortedData = data;

        // System.out.println("\nStarting quick sort");
        long start = System.nanoTime();
        quickSort(sortedData, 0, sortedData.length - 1);
        long duration = System.nanoTime() - start;
        System.out.print("\u001B[36m");
        System.out.println("Quick sort (" + passes + " passes in " + duration + " nanoseconds.)");
        System.out.print("\u001B[0m");
    }

    public static Integer[] getSorted() {
        return sortedData;
    }
}
