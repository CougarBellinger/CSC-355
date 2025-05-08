package Projects.project6;

class Node<K, V> {
    K key;
    V val;
    Node<K, V> left, right;

    // Node constructor
    public Node(K key, V val) {
        this.key = key;
        this.val = val;
        this.left = this.right = null;
    }
}

public class Tree<K, V> {
    private Node<K, V> root;

    // Insert (key, val) into the tree
    // or update val if key is already in the tree.
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> node, K key, V val) {
        if (node == null) {
            return new Node<>(key, val);
        }

        int cmp = ((Comparable<K>) key).compareTo(node.key);

        if (cmp < 0) {
            node.left = put(node.left, key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val = val;
        }
        return node;
    }

    // Get the value associated with key in the tree or return null if
    // the key does not exist.
    public V get(K key) {
        return get(root, key);
    }

    private V get(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = ((Comparable<K>) key).compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }

    // Return true if the tree is empty or false otherwise
    public boolean isEmpty() {
        return root == null; // ez pz :)
    }

    // return number of nodes in the tree
    public int size() {
        return size(root);
    }

    private int size(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    // return height of tree in O(1) time
    public int height() {
        return height(root);
    }

    private int height(Node<K, V> node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    // return heigh of subtree with K root. If key DNE, return -1
    // should take same time as the time it takes to find the node
    public int height(K key) {
        Node<K, V> node = findNode(root, key);
        if (node == null) {
            return -1; // Key does not exist
        }
        return height(node);
    }

    private Node<K, V> findNode(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = ((Comparable<K>) key).compareTo(node.key);
        if (cmp < 0) {
            return findNode(node.left, key);
        } else if (cmp > 0) {
            return findNode(node.right, key);
        } else {
            return node; // Key found
        }
    }

    // return true if the key is in the tree
    public boolean contains(K key) {
        return findNode(root, key) != null;
    }

    // return size of subtree whose root contains the key
    // return -1 if key DNE, size should be included in node itself
    // time shouldn't be worse than it takes to find the node
    public int size(K key) {
        Node<K, V> node = findNode(root, key);
        if (node == null) {
            return -1; // Key does not exist
        }
        return size(node); // Calculate the size of the subtree
    }
}
