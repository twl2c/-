package bsttree;

public interface BST {

    boolean search(int e);

    void insert(int e);

    void delete(int e);

    int getMax();

    int getMin();

    int getSize();

}
