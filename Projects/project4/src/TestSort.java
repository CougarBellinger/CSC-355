import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSort {
    public static void main(String[] args) {
        // Scanner scnnr = new Scanner(System.in);
        String fileName = "project4/data/testArray1.txt";

        // sort the array and store it in Shellsort instance
        Integer[] arrayToSort = fileArray(fileName);
        System.out.println("Input Array:\n" + Arrays.toString(arrayToSort));
        Shellsort.sort(arrayToSort);

        // print out the shellsort sorted array using to string
        System.out.println("Sorted Array:\n" + Arrays.toString(Shellsort.getSorted()));
    }

    public static Integer[] fileArray(String fileName) {
        ArrayList<Integer> inputArray = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                inputArray.add(Integer.parseInt(line));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        Integer[] data = new Integer[inputArray.size()];
        return inputArray.toArray(data);
    }
}
