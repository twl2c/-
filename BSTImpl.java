package bsttree;

public class BSTImpl implements BST {

    private Node root;
    private int size;

    static class Node {

        int key;
        Node left;
        Node right;

        public Node(int key) {

            this.key = key;
            this.left = null;
            this.right = null;

        }
    }


    @Override
    public boolean search(int key) {
        return recursionSearch(root, key) != null;
    }

    private Node recursionSearch(Node node, int element) {
        if (node == null) {
            return null;
        }
        if (element == node.key) {
            return node;
        } else if (element < node.key) {
            return recursionSearch(node.left, element);
        } else {
            return recursionSearch(node.right, element);
        }
    }


    @Override
    public void insert(int element) {
        root = insert(root, element);
    }

    private Node insert(Node node, int element) {
        if (node == null) {
            size++;
            return new Node(element);
        }
        if (element < node.key) {
            node.left = insert(node.left, element);
        } else if (element > node.key) {
            node.right = insert(node.right, element);
        }
        return node;
    }


    @Override
    public void delete(int key) {
        root = delete(root, key);
    }

    private Node delete(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = delete(node.left, key);
        } else if (key > node.key) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null && node.right == null) {
                size--;
                return null;
            }
            if (node.left == null) {
                size--;
                return node.right;
            }
            if (node.right == null) {
                size--;
                return node.left;
            }
            Node succ = findMin(node.right);
            node.key = succ.key;
            node.right = delete(node.right, succ.key);
        }

        return node;
    }

    @Override
    public int getMin() {
        Node minNode = findMin(root);
        return minNode.key;
    }

    @Override
    public int getMax() {
        Node maxNode = findMax(root);
        return maxNode.key;
    }

    private Node findMin(Node node) {
        while (node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }

    private Node findMax(Node node) {
        while (node != null && node.right != null) {
            node = node.right;
        }
        return node;
    }

    @Override
    public int getSize() {
        return size;
    }






}
