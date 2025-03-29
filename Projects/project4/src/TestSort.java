// NOTE: File names assume file is run in "project4" directory

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSort {
    static String fileDir = "project4/data/";
    static String[] fileNames = { "array1.txt", "array2.txt", "array3.txt", "array4.txt", "array5.txt" };

    public static void main(String[] args) {
        Integer[] arrayToSort = inputFileArray(fileDir + "testArray1.txt");

        System.out.println("====================================================");
        System.out.println("COUGAR'S TESTS");
        System.out.println("====================================================");

        System.out.println("Input Array:\n" + Arrays.toString(arrayToSort));
        Shellsort.sort(arrayToSort);
        System.out.println("Sorted Array:\n" + Arrays.toString(Shellsort.getSorted()));

        System.out.println("\nInput Array:\n" + Arrays.toString(arrayToSort));
        Quicksort.sort(arrayToSort);
        System.out.println("Sorted Array:\n" + Arrays.toString(Shellsort.getSorted()));

        System.out.println("\n====================================================");
        System.out.println("ASSIGNMENT TESTS");
        System.out.println("====================================================");

        for (String fileName : fileNames) {
            System.out.println("\nInput Array File: \"" + fileName + "\"");
            // System.out.print("\u001B[36m");
            Shellsort.sort(inputFileArray(fileDir + fileName));
            Quicksort.sort(inputFileArray(fileDir + fileName));
            // System.out.print("\u001B[0m");
            System.out.println("Output Sorted File: \"" + outputFileArray(Quicksort.getSorted(), fileName) + "\"");

        }

    }

    public static Integer[] inputFileArray(String fileName) {
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

    public static String outputFileArray(Integer[] array, String inputFileName) {
        String outputFileName = ("sorted" + inputFileName.substring(0, 1).toUpperCase()
                + inputFileName.substring(1));

        try (BufferedWriter output = new BufferedWriter(new FileWriter(fileDir + outputFileName))) {
            output.write(Arrays.toString(array));
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return outputFileName;
    }
}
