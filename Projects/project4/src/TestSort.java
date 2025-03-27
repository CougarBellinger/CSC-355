import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner scnnr = new Scanner(System.in);
        String fileName = "../data/testArray1.txt";

        // sort the array and store it in Shellsort instance
        Shellsort.sort(fileArray(fileName));
        // print out the shellsort sorted array using to string
        System.out.println(Arrays.toString(Shellsort.getSorted()));
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
