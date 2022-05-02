package me.stefanwaldhaser.trees;

import java.util.function.Consumer;

public class BinaryTreeNode {
    int value;
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;

    public BinaryTreeNode(int value) {
        this.value = value;
        leftChild = null;
        rightChild = null;
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftChild, BinaryTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BinaryTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryTreeNode rightChild) {
        this.rightChild = rightChild;
    }



    public void processInOrder(Consumer<BinaryTreeNode> c) {
        inOrder(this,c);
    }

    public void processPreOrder(Consumer<BinaryTreeNode> c) {
        preOrder(this,c);
    }

    public void processPostOrder(Consumer<BinaryTreeNode> c) {
        postOrder(this,c);
    }

    public void inOrder(BinaryTreeNode bt, Consumer<BinaryTreeNode> c) {
        if(bt != null) {
            inOrder(bt.leftChild, c);
            c.accept(bt);
            inOrder(bt.rightChild, c);
        }
    }

    private void preOrder(BinaryTreeNode bt, Consumer<BinaryTreeNode> c) {
        if(bt != null) {
            c.accept(bt);
            preOrder(bt.leftChild, c);
            preOrder(bt.rightChild, c);
        }
    }

    private void postOrder(BinaryTreeNode bt, Consumer<BinaryTreeNode> c) {
        if(bt != null) {
            postOrder(bt.leftChild, c);
            postOrder(bt.rightChild, c);
            c.accept(bt);

        }
    }

    public void print() {
        print("", this, false);
    }

    private void print(String prefix, BinaryTreeNode n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.value);
            print(prefix + (isLeft ? "|   " : "    "), n.leftChild, true);
            print(prefix + (isLeft ? "|   " : "    "), n.rightChild, false);
        }
    }

    // Example from Wikipedia https://en.wikipedia.org/wiki/Binary_tree -> useful for playing around with trees
    public static BinaryTreeNode createWikiBinaryTree() {
        return new BinaryTreeNode(
                1,
                new BinaryTreeNode(7,
                        new BinaryTreeNode(2),
                        new BinaryTreeNode(6, new BinaryTreeNode(5), new BinaryTreeNode(11))),
                new BinaryTreeNode(9, null, new BinaryTreeNode(9, new BinaryTreeNode(5), null)));
    }

    // Example from Wikipedia https://en.wikipedia.org/wiki/Binary_search_tree -> useful for playing around with trees
    public static BinaryTreeNode createWikiBinarySearchTree() {
        return new BinaryTreeNode(8,
                new BinaryTreeNode(3, new BinaryTreeNode(1), new BinaryTreeNode(6, new BinaryTreeNode(4), new BinaryTreeNode(7))),
                new BinaryTreeNode(10, null, new BinaryTreeNode(14, new BinaryTreeNode(13), null)));
    }



}
