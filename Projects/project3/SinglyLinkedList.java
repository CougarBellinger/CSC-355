public class SinglyLinkedList {
    private Node headNode = null;
    private int data = 0;

    // Initialize new list with a head node, and insert N nodes
    public SinglyLinkedList(int N) {
        // Head starts at 1
        this.headNode = new Node(++data, null);

        Insert(N);
    }

    // Inserts N number of nodes
    public void Insert(int N) {
        Node iterNode = this.headNode;
        Node newNode;

        for (int i = 1; i < N; i++) {
            newNode = new Node(++data, null);

            iterNode.setNextNode(newNode);
            iterNode = iterNode.next();
        }
    }

    // Deletes node at iteration N
    public void Delete(int N) {
        Node searchNode = this.headNode;
        Node prevNode = null;

        // Move variables to correct location
        for (int i = 1; i < N; i++) {
            prevNode = searchNode;
            searchNode = searchNode.next();
        }

        if (searchNode.next() != null) { // If search node is not last node
            prevNode.setNextNode(searchNode.next());
        } else { // If search node was last node
            prevNode.setNextNode(null);
        }

        searchNode = null;
    }

    public void Traversal() {
        Node iterNode = this.headNode;

        while (true) {
            System.out.printf("[%d]", iterNode.getData());

            if (iterNode.next() != null) {
                System.out.print(" -> ");
                iterNode = iterNode.next();
            } else {
                System.out.print("\n");
                break;
            }
        }
    }

}