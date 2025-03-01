public class DoublyLinkedList extends SinglyLinkedList {
    private Node tailNode = null;

    public DoublyLinkedList(int N) {
        super(N);

        this.headNode = new Node(++this.data, null, null);
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
            addNode = new Node(++data, null, iterNode);
            iterNode.setNextNode(addNode);
            iterNode = iterNode.next();
        }

        // super.Insert(N);
    }

    Node headNode;

}
