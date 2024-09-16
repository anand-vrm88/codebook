package com.codebook.misc.tree;

import java.util.Iterator;
import java.util.Objects;

public class BinaryTree<D extends Comparable<D>> implements Tree<D> {

    TreeNode<D> root;

    public BinaryTree() {
    }

    public BinaryTree(D[] binaryTree){
        if (binaryTree.length > 0) {
            this.root = new TreeNode<>(binaryTree[0]);
            this.root.left = buildTree(binaryTree, 1);
            this.root.right = buildTree(binaryTree, 2);
        }
    }

    private TreeNode<D> buildTree(D[] binaryTree, int index) {
        if (index < binaryTree.length && Objects.nonNull(binaryTree[index])) {
            TreeNode<D> treeNode = new TreeNode<>(binaryTree[index]);
            treeNode.left = buildTree(binaryTree, 2 * index + 1);
            treeNode.right = buildTree(binaryTree, 2 * index + 2);
            return treeNode;
        }
        return null;
    }

    @Override
    public void insert(D data) {

    }

    @Override
    public Iterator<TreeNode<D>> iterator(IteratorStrategy strategy) {
        switch (strategy){
            case IN_ORDER:
                return new InOrderIterator<>(this.root);
            case POST_ORDER:
                return new PostOrderIterator<>(this.root);
            default:
                throw new IllegalArgumentException(String.format("Invalid iterator strategy: %s", strategy));
        }
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }
}


