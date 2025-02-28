import java.util.Scanner;

public class LinkedListTest {
    public static void main(String[] args) {
        Scanner scanIn = new Scanner(System.in);

        // Works!
        SinglyLinkedList tester1 = new SinglyLinkedList(5);
        tester1.Traversal();

        int N = 1;

        try {
            if (N <= 0) {
                throw new IllegalArgumentException("Please enter a positive integer\n");
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
