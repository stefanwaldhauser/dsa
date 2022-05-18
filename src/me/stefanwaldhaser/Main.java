package me.stefanwaldhaser;

import me.stefanwaldhaser.trees.BinaryTreeNode;
import me.stefanwaldhaser.trees.TreeProblems;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode bt = BinaryTreeNode.createWikiBinarySearchTree();
//        // Tree traversal
//        Consumer<BinaryTreeNode> printValue = (tree) -> {
//            System.out.println(tree.getValue());
//        };
//        System.out.println("INORDER");
//        bt.processInOrder(printValue);
//        System.out.println("PREORDER");
//        bt.processPostOrder(printValue);
//        System.out.println("POSTORDER");
//        bt.processPostOrder(printValue);
//        // Create minimal binary search tree
//        System.out.println("Create Minimal Binary Search Treee");
//        BinaryTreeNode minimal = TreeProblems.createMinimalBST(new int[]{1,4,10,18,20});
//        minimal.print();
        // Nodes at depth
        bt.print();
        TreeProblems.nodesAtDepth(bt).forEach((k,v) -> {
            System.out.println("===============");
            System.out.println("LEVEL" + k);
            v.forEach(n -> {
                System.out.println(n.getValue());
            });
            System.out.println("===============");
        });



    }
}
