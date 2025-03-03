/*
Let A:
    - be an array of size N that is made up of two separate subarrays that are already sorted in 
      increasing order.

Let i:
    - be the index where the first sorted subarray ends.

Write an algorithm that:
    - runs in O(N) time 
    - merges the two sorted subarrays into a single sorted array.

Example:  
Input: [0, 2, 5, 6, 2, 6, 6, 7, 8, 9], 3 
Output: [0, 2, 2, 5, 6, 6, 6, 7, 8, 9]
*/
package Homeworks.hw3;

public class q2 {
    public static void main(String[] args) {
        int[] A = { 0, 2, 5, 6, 2, 6, 6, 7, 8, 9 };
        int[] B = new int[A.length];
        int i = 3;
        int j;

        int hold1 = 0;
        int hold2 = i + 1;
        for (j = 0; j < B.length; j++) {
            if (hold2 >= B.length) {
                B[j] = A[hold1++];
                continue;
            } else if (hold1 >= i + 1) {
                B[j] = A[hold2++];
                continue;
            }

            if (A[hold1] <= A[hold2]) {
                B[j] = A[hold1++];
            } else {
                B[j] = A[hold2++];
            }
        }

        // Printing arrays
        System.out.print("A: ");
        for (j = 0; j < A.length - 1; j++) {
            System.out.print(A[j] + ", ");
        }
        System.out.println(A[j]);

        System.out.print("B: ");
        for (j = 0; j < B.length - 1; j++) {
            System.out.print(B[j] + ", ");
        }
        System.out.println(B[j]);
    }
}
