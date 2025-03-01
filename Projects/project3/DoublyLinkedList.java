public class DoublyLinkedList extends SinglyLinkedList {
    private Node tailNode = null;

    public DoublyLinkedList(int N) {
        this.headNode = new Node(++this.data, null, null);
        this.tailNode = headNode;
        Insert(N - 1);
    }

    @Override
    public void Insert(int N) {
        Node iterNode = headNode;
        Node addNode;

        while (iterNode.next() != null) {
            iterNode = iterNode.next();
        }

        for (int i = 0; i < N; i++) {
            addNode = new Node(++this.data, null, iterNode);
            iterNode.setNextNode(addNode);
            iterNode = iterNode.next();
            this.tailNode = iterNode;
        }
    }

    @Override
    public int Delete(int N) {
        Node searchNode;
        Node prevNode;
        Node nextNode;

        boolean isHeadPriority;
        int dataDeleted = 0;
        int numElements = CountElements();

        // Determine if N is closer to head or tail
        if ((N) < (numElements - N)) {
            searchNode = this.headNode;
            isHeadPriority = true;
        } else {
            searchNode = this.tailNode;
            isHeadPriority = false;
        }

        // Base cases
        if (N == 1) {
            this.headNode = searchNode.next();
            dataDeleted = searchNode.getData();
            searchNode = null;

            return dataDeleted;
        } else if (N == numElements) {
            this.tailNode = searchNode.prev();
            this.tailNode.setNextNode(null);

            dataDeleted = searchNode.getData();
            searchNode = null;

            return dataDeleted;
        }

        // Move searchNode to correct place
        if (isHeadPriority) { // Search starts at head
            for (int i = 1; i < N; i++) {
                searchNode = searchNode.next();
            }
        } else { // Search starts at tail
            for (int i = numElements; i > N; i--) {
                searchNode = searchNode.prev();
            }
        }

        prevNode = searchNode.prev();
        nextNode = searchNode.next();

        prevNode.setNextNode(nextNode);
        nextNode.setPrevNode(prevNode);

        dataDeleted = searchNode.getData();

        return dataDeleted;
    }

    @Override
    public Node Search(int N) {
        Node searchNode;
        boolean isHeadPriority;
        int numElements = CountElements();

        if ((N) < (numElements - N)) {
            searchNode = this.headNode;
            isHeadPriority = true;
        } else {
            searchNode = this.tailNode;
            isHeadPriority = false;
        }

        // Move searchNode to correct place
        if (isHeadPriority) { // Search starts at head
            for (int i = 1; i < N; i++) {
                searchNode = searchNode.next();
            }
        } else { // Search starts at tail
            for (int i = numElements; i > N; i--) {
                searchNode = searchNode.prev();
            }
        }

        return searchNode;
    }

    @Override
    public void Traversal() {
        Node iterNode = this.headNode;

        while (true) {
            System.out.printf("[%d]", iterNode.getData());

            if (iterNode.next() != null) {
                System.out.print(" <-> ");
                iterNode = iterNode.next();
            } else {
                System.out.print("\n");
                break;
            }
        }

    }
}
