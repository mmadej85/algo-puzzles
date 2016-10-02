package pl.mmadej.algorithms.sort;


import pl.mmadej.algorithms.ds.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {

    public <T extends Comparable<T>> List<T> inorder(BinaryTreeNode<T> root) {
        Stack<BinaryTreeNode<T>> stack = new Stack<>();

        List<T> values = new ArrayList<>();
        BinaryTreeNode<T> current = root;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                current = stack.pop();
                values.add(current.getValue());
                current = current.getRight();
            }
        }
        return values;
    }
}
