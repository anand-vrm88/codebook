package com.codebook.misc.tree;

import java.util.Iterator;

public class BinarySearchTreeDemo {

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

        System.out.println(containsPair(binarySearchTree, 23));
    }

    private static boolean containsPair(BinarySearchTree<Integer> tree, int k) {
        Iterator<TreeNode<Integer>> inOrderIterator = tree.iterator(IteratorStrategy.IN_ORDER);
        Iterator<TreeNode<Integer>> postOrderIterator = tree.iterator(IteratorStrategy.POST_ORDER);
        TreeNode<Integer> firstNode = inOrderIterator.next();
        TreeNode<Integer> lastNode = postOrderIterator.next();
        while (inOrderIterator.hasNext() && postOrderIterator.hasNext()) {
            if ((firstNode.getData() + lastNode.getData()) == k) {
                return true;
            } else if ((firstNode.getData() + lastNode.getData()) < k) {
                firstNode = inOrderIterator.next();
            } else {
                lastNode = postOrderIterator.next();
            }
        }
        return false;
    }
}


