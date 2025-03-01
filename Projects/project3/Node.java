public class Node {
    private int data;
    private Node nextNode;
    private Node prevNode;

    public Node(int data, Node nextNode, Node prevNode) {
        this.data = data;
        this.nextNode = nextNode;
        this.prevNode = prevNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node next() {
        return this.nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Node prev() {
        return this.prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

}
