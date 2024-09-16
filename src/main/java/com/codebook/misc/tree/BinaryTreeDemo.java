package com.codebook.misc.tree;

import java.util.Iterator;
import java.util.Objects;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Integer[] binaryTreeArray = new Integer[]{
                0, 1, 0, null, null, 1, 0, null, null, null, null, 0, 0, null, null
        };

        BinaryTree<Integer> binaryTree = new BinaryTree<>(binaryTreeArray);

        pruneZeroSubtrees(binaryTree);

        Iterator<TreeNode<Integer>> iterator = binaryTree.iterator(IteratorStrategy.IN_ORDER);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getData());
        }
    }

    private static void pruneZeroSubtrees(BinaryTree<Integer> binaryTree){
        binaryTree.root.left = pruneZeroSubtrees(binaryTree.root.left);
        binaryTree.root.right = pruneZeroSubtrees(binaryTree.root.right);
    }

    private static TreeNode<Integer> pruneZeroSubtrees(TreeNode<Integer> treeNode) {
        if (Objects.isNull(treeNode)) {
            return null;
        }

        treeNode.left = pruneZeroSubtrees(treeNode.left);
        treeNode.right = pruneZeroSubtrees(treeNode.right);
        if (treeNode.getData() == 0
                && Objects.isNull(treeNode.left)
                && Objects.isNull(treeNode.right)) {
            return null;
        }

        return treeNode;
    }
}
