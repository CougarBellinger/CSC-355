/*
A palindrome is a string that reads the same forwards as backwards.
Using only:
    - a fixed number of stacks and queues
    - the stack and queue functions
    - a fixed number of int and char variables
    
Write an algorithm to determine if a string is a palindrome.
Assume that the string is read from standard input one character at a time.

The algorithm should output true or false as appropriate.
 */

package Homeworks.hw3;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class q4 {
    public static void main(String[] args) {
        // Initialize Variables
        Scanner scanner = new Scanner(System.in);
        boolean isPalindrome = true;
        String stringIn;
        char[] charArray;

        Queue<Character> forwards = new LinkedList<Character>();
        Queue<Character> backwards = new LinkedList<Character>();

        // Get string input and convert it to char array
        System.out.print("Input string to check for palidrome: ");
        stringIn = scanner.nextLine();
        charArray = stringIn.toCharArray();
        System.out.printf("You entered \"%s\"\n", stringIn);

        // populate queues for comparison
        for (int i = 0; i < charArray.length; i++) {
            forwards.offer(charArray[i]);
            backwards.offer(charArray[charArray.length - 1 - i]);
        }

        // simultanously poll the qeues while comparing them, flagging false with fail
        // condition
        while (forwards.peek() != null) {
            if (forwards.poll() != backwards.poll()) {
                isPalindrome = false;
                System.out.printf("%s is NOT a palindrome :(\n", stringIn);
                System.exit(0);
            }
        }

        System.out.printf("%s IS a palindrome :)\n", stringIn);
    }
}
