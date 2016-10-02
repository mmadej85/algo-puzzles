package pl.mmadej.algorithms.ds;

public class BinaryTreeNode<T extends Comparable<T>> {
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;

    private T value;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }

    public T getValue() {
        return value;
    }
}
