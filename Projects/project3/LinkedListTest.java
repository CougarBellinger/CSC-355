import java.util.Scanner;

public class LinkedListTest {
    private static Scanner scanIn;

    public static void exit() {
        System.out.println("goodbye...");
        scanIn.close();
        System.exit(0);
    }

    public static void ExecuteSinglyLinkedList(SinglyLinkedList listIn, int option) {
        int count = listIn.CountElements();
        switch (option) {
            case 1:
                System.out.print("Insert number of items to add: ");
                int numInsert = scanIn.nextInt();
                if (numInsert < 0) {
                    System.out.print("(ERROR) Expected positive integer\n");
                    return;
                }
                listIn.Insert(numInsert);
                System.out.printf("Inserted %d items to linked list\n", numInsert);
                break;

            case 2:
                int dataDeleted;
                int indexDelete;
                System.out.printf("Instructions:\n");
                System.out.printf("  Enter \"First\" to delete first element\n");
                System.out.printf("  Enter \"Last\" to delete last element\n");
                System.out.printf("  Enter index to delete (1 - %d)\n", count);
                System.out.printf("Type: ");

                String deleteChoice = scanIn.next();
                if (deleteChoice.equalsIgnoreCase("first")) {
                    dataDeleted = listIn.Delete(1);
                    System.out.printf("Deleted first element [%d]\n", dataDeleted);

                } else if (deleteChoice.equalsIgnoreCase("last")) {
                    dataDeleted = listIn.Delete(count);
                    System.out.printf("Deleted last element [%d]\n", dataDeleted);

                } else {
                    try {
                        indexDelete = Integer.parseInt(deleteChoice);
                    } catch (NumberFormatException e) {
                        System.out.print("(ERROR) Input not recognized");
                        break;
                    }

                    if (indexDelete < 0 || indexDelete > count) {
                        System.out.print("(ERROR) Element out of range");
                        break;
                    }

                    dataDeleted = listIn.Delete(indexDelete);
                    System.out.printf("Deleted element [%d] at index %d\n", dataDeleted, indexDelete);
                }

                break;

            case 3:
                System.out.printf("Insert element index to search for (1 - %d): ", count);
                int indexFind = scanIn.nextInt();
                if (indexFind < 0 || indexFind > count) {
                    System.out.print("(ERROR) Element out of range");
                }
                int dataFound = listIn.Search(indexFind).getData();
                System.out.printf("Element [%d] found at index %d\n", dataFound, indexFind);
                break;
            case 4:
                System.out.println("Here's your linked list:");
                listIn.Traversal();
                break;

            default:
                break;
        }
    }

    public static void main(String[] args) {
        scanIn = new Scanner(System.in);
        SinglyLinkedList testList;
        String optionString;
        int optionInt;
        int N = 0;

        System.out.print("\nHello!\nInsert number of items to initialize list: ");
        N = scanIn.nextInt();
        while (true) {
            if (N > 0) {
                break;
            }

            System.out.println("Please enter a number greater than 0");
        }

        testList = new SinglyLinkedList(N);

        System.out.println("Here is your linked list:");
        testList.Traversal();

        while (true) {
            System.out.println("\nPlease select option (q to quit):");
            System.out.println("  1) Insert");
            System.out.println("  2) Delete");
            System.out.println("  3) Search");
            System.out.println("  4) Traversal and print");
            System.out.print("Enter: ");

            optionString = scanIn.next();
            if (optionString.equalsIgnoreCase("q") || optionString.equalsIgnoreCase("quit")) {
                exit();
            }

            try {
                optionInt = Integer.parseInt(optionString);
            } catch (NumberFormatException e) {
                System.out.println("\n(ERROR)Unrecognized input");
                continue;
            }

            if (optionInt <= 0 || optionInt > 4) {
                System.out.println("\n(ERROR)Please enter integer in range 1-4");
                continue;
            } else {
                System.out.printf("\nOption %d selected\n", optionInt);
                ExecuteSinglyLinkedList(testList, optionInt);
            }
        }

    }
}
