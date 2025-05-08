package Projects.project6;

public class BinaryTreeTest {
    public static void main(String[] args) {
        Tree<Integer, String> tree = new Tree<>();
        tree.put(5, "Five");
        tree.put(3, "Three");
        tree.put(7, "Seven");
        tree.put(2, "Two");
        tree.put(4, "Four");
        tree.put(6, "Six");
        tree.put(8, "Eight");

        System.out.println("Tree size: " + tree.size());
        System.out.println("Tree height: " + tree.height());
        System.out.println("Is the tree empty? " + tree.isEmpty());

        System.out.println("Value for key 4: " + tree.get(4));
        System.out.println("Value for key 5 before change: " + tree.get(5));

        tree.put(5, "Five but Different");
        System.out.println("Value for key 5 after change: " + tree.get(5));

    }
}
