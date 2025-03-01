public class SinglyLinkedList {
    protected Node headNode = null;
    protected int data = 0;

    // Initialize new list with a head node, and insert N nodes
    public SinglyLinkedList(int N) {
        // Head starts at 1
        this.headNode = new Node(++data, null, null);

        Insert(N - 1);
    }

    // Inserts N number of nodes
    public void Insert(int N) {
        Node iterNode = this.headNode;
        Node newNode;

        while (iterNode.next() != null) {
            iterNode = iterNode.next();
        }

        for (int i = 0; i < N; i++) {
            newNode = new Node(++data, null, null);

            iterNode.setNextNode(newNode);
            iterNode = iterNode.next();
        }
    }

    // Deletes node at iteration N and returns its data
    public int Delete(int N) {
        int data;
        Node searchNode = this.headNode;
        Node prevNode = null;

        if (N == 1) {
            this.headNode = searchNode.next();
            data = searchNode.getData();
            searchNode = null;

            return data;
        }

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

        data = searchNode.getData();
        searchNode = null;

        return data;
    }

    public Node Search(int N) {
        Node searchNode = this.headNode;

        // Move variables to correct location
        for (int i = 1; i < N; i++) {
            searchNode = searchNode.next();
        }

        return searchNode;
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

    public int CountElements() {
        Node iterNode = this.headNode;
        int count = 1;

        while (iterNode.next() != null) {
            iterNode = iterNode.next();
            ++count;
        }

        return count;
    }

}