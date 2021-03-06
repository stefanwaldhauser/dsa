package me.stefanwaldhaser.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TreeProblems {
    //=============================

    // Given a sorted (increasing order) array with unique integer elements,
    // write an algorithm to create a binary search tree with minimal height.
    public static BinaryTreeNode createMinimalBST(int[] sortedAscending) {
        return createMinimalBSTHelper(sortedAscending, 0, sortedAscending.length-1);
    }

    private static BinaryTreeNode createMinimalBSTHelper(int[] sortedAscending, int l, int r) {
        // base cases
        if(l > r) {
            return null;
        }
        if(l == r) {
            return new BinaryTreeNode(sortedAscending[l]);
        }
        // idea: number of nodes left subtree must be as close as possible to number of nodes in right subtree
        // -> array is sorted, so if we pick the middle, we know all left to the middle will be in the left subtree
        // and all right to the middle will be in the right subtree, and both trees nearly equally large
        // the recursive subproblems are now just the left minimalbst and the right minimalbst
        int mid = (l + r) / 2;
        BinaryTreeNode leftMinimalBST = createMinimalBSTHelper(sortedAscending, l, mid-1);
        BinaryTreeNode rightMinimalBST = createMinimalBSTHelper(sortedAscending, mid+1, r);
        return new BinaryTreeNode(sortedAscending[mid], leftMinimalBST, rightMinimalBST);
    }

    //=============================

    public static HashMap<Integer, List<BinaryTreeNode>> nodesAtDepth(BinaryTreeNode root) {
        HashMap<Integer, List<BinaryTreeNode>> depthToNodes = new HashMap<>();
        nodesAtDepthHelper(root, 0, depthToNodes);
        return depthToNodes;
    }

    private static void nodesAtDepthHelper(BinaryTreeNode currentNode, int currentLevel, HashMap<Integer, List<BinaryTreeNode>> depthToNodes) {
        if(currentNode == null) {
            return;
        }
        // dfs - prenode
        //visit
        depthToNodes.computeIfAbsent(currentLevel, k -> new ArrayList<>());
        depthToNodes.get(currentLevel).add(currentNode);
        // left
        nodesAtDepthHelper(currentNode.leftChild, currentLevel+1, depthToNodes);

        // right
        nodesAtDepthHelper(currentNode.rightChild, currentLevel+1, depthToNodes);
    }
}
