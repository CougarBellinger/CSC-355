/*
Write an algorithm that takes a linked list of size N elements and splits it into two linked lists 
where the first list contains all the elements that are less than or equal to the first element in the 
list and the second list contains all the elements that are greater than the first element in the list.

 */

package Homeworks.hw3;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class q1 {
    public static void printList(LinkedList list) {
        Iterator<Integer> iter = list.iterator();
        while (true) {
            System.out.print(iter.next());
            if (iter.hasNext()) {
                System.out.print(" -> ");
                continue;
            }
            return;
        }
    }

    public static void main(String[] args) {
        Integer[] input = { 3, 4, 1, 0, 2, 9 };

        LinkedList<Integer> masterList = new LinkedList<Integer>(Arrays.asList(input));
        LinkedList<Integer> lessThanList = new LinkedList<Integer>();
        LinkedList<Integer> greaterThanList = new LinkedList<Integer>();

        Integer decider = masterList.peekFirst();
        Integer element;
        Iterator<Integer> iter = masterList.iterator();

        while (iter.hasNext()) {
            element = iter.next();

            if (element <= decider) {
                lessThanList.add(element);
            } else {
                greaterThanList.add(element);
            }
        }

        System.out.print("Input:\n\tL = ");
        printList(masterList);

        System.out.println("\nOutput:");
        System.out.print("\tL1 = ");
        printList(lessThanList);

        System.out.print("\n\tL2 = ");
        printList(greaterThanList);

        System.out.println("");

    }
}
