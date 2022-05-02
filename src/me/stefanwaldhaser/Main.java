package me.stefanwaldhaser;

import me.stefanwaldhaser.trees.BinaryTreeNode;
import me.stefanwaldhaser.trees.TreeProblems;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
	    // Tree traversal
        BinaryTreeNode bt = BinaryTreeNode.createWikiBinarySearchTree();
        Consumer<BinaryTreeNode> printValue = (tree) -> {
            System.out.println(tree.getValue());
        };
        System.out.println("INORDER");
        bt.processInOrder(printValue);
        System.out.println("PREORDER");
        bt.processPostOrder(printValue);
        System.out.println("POSTORDER");
        bt.processPostOrder(printValue);
        // Create minimal binary search tree
        System.out.println("Create Minimal Binary Search Treee");
        BinaryTreeNode minimal = TreeProblems.createMinimalBST(new int[]{1,4,10,18,20});
        minimal.print();
    }
}
