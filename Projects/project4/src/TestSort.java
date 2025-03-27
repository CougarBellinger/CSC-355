import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TestSort {
    public static void main(String[] args) {
        Scanner scnnr = new Scanner(System.in);
        String fileName = "../data/array1.txt";
        try (FileReader reader = new FileReader(fileName)) {

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
