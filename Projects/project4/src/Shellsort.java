class Shellsort {
    private static Integer[] data;
    private static Integer[] sortedData;
    private static int passes;

    // Sorts the array using shell sort
    public static void sort(Integer[] inputData) {
        data = inputData.clone();

        int temp;
        int passes = 0;
        int n = data.length;

        // System.out.println("\nStarting shell sort...");
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
            passes++;
        }
        long duration = System.nanoTime() - startTime;
        System.out.print("\u001B[36m");
        System.out.println("Shell sort (" + passes + " passes in " + duration + " nanoseconds.)");
        System.out.print("\u001B[0m");
        sortedData = data;
        data = inputData;
    }

    // Outputs sorted array
    public static Integer[] getSorted() {
        return sortedData;
    }

}