package pl.mmadej.algorithms.sort;

import org.junit.Before;
import org.junit.Test;
import pl.mmadej.algorithms.ds.BinaryTreeNode;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BinaryTreeTraversalTest {

    private BinaryTreeNode<Integer> node_1 = new BinaryTreeNode<>(1);
    private BinaryTreeNode<Integer> node_2 = new BinaryTreeNode<>(2);
    private BinaryTreeNode<Integer> node_6 = new BinaryTreeNode<>(6);
    private BinaryTreeNode<Integer> node_8 = new BinaryTreeNode<>(8);
    private BinaryTreeNode<Integer> node_9 = new BinaryTreeNode<>(9);
    private BinaryTreeNode<Integer> root = new BinaryTreeNode<>(10);
    private BinaryTreeNode<Integer> node_11 = new BinaryTreeNode<>(11);
    private BinaryTreeNode<Integer> node_12 = new BinaryTreeNode<>(12);
    private BinaryTreeNode<Integer> node_13 = new BinaryTreeNode<>(13);
    private BinaryTreeNode<Integer> node_16 = new BinaryTreeNode<>(16);
    private BinaryTreeNode<Integer> node_17 = new BinaryTreeNode<>(17);
    private BinaryTreeTraversal traverse = new BinaryTreeTraversal();


    /*
                                    10
                    /                               \
                    6                               12
            /               \               /               \
           2                 8             11               16
          /                   \                            /    \
         1                     9                         13     17
     */
    @Before
    public void before() {
        root = new BinaryTreeNode<>(10);
        root.setLeft(node_6);
        root.setRight(node_12);
        //left subtree
        node_6.setRight(node_8);
        node_6.setLeft(node_2);
        node_8.setRight(node_9);
        node_2.setLeft(node_1);
        //right subtree
        node_12.setLeft(node_11);
        node_12.setRight(node_16);
        node_16.setLeft(node_13);
        node_16.setRight(node_17);
    }

    @Test
    public void returnsNodeInInorderSequence() {
        List<Integer> inorderSequence = traverse.inorder(root);
        assertThat(inorderSequence.toString(), is(equalTo("[1, 2, 6, 8, 9, 10, 11, 12, 13, 16, 17]")));
    }
}