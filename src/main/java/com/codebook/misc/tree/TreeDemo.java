package com.codebook.misc.tree;

import java.util.Iterator;

public class TreeDemo {

    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(5);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(1);
        binarySearchTree.insert(3);
        binarySearchTree.insert(6);
        binarySearchTree.insert(11);
        binarySearchTree.insert(8);
    }

    private static boolean containsPair(BinarySearchTree<Integer> tree, int k) {
        Iterator<TreeNode<?>> inOrderIterator = tree.iterator(IteratorStrategy.IN_ORDER);
        Iterator<TreeNode<?>> postOrderIterator = tree.iterator(IteratorStrategy.POST_ORDER);

        while (inOrderIterator.hasNext() && postOrderIterator.hasNext()) {
            TreeNode<?> firstNode = inOrderIterator.next();
            TreeNode<?> lastNode = postOrderIterator.next();
            Object data = firstNode.getData();

        }
        return false;
    }
}


