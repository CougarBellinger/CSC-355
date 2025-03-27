class Shellsort {
    private static Integer[] data;
    private static Integer[] sortedData;

    // Sorts the array using shell sort
    public static void sort(Integer[] inputData) {
        data = inputData;

        int temp;
        int passes = 0;
        int n = data.length;

        System.out.println("\nStarting shell sort...");
        long startTime = System.nanoTime();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                temp = data[i];
                int j;
                for (j = i; j >= gap && data[j - gap] > temp; j -= gap) {
                    data[j] = data[j - gap];
                }
                data[j] = temp;
            }
        }
        long duration = System.nanoTime() - startTime;
        System.out.println("Shell sort finished! (" + (duration / Math.pow(10, 9)) + ") seconds.\n");
        sortedData = data;
        data = inputData;
    }

    // Outputs sorted array
    public static Integer[] getSorted() {
        return sortedData;
    }

}