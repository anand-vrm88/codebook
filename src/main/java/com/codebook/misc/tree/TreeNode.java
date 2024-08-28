package com.codebook.misc.tree;

public class TreeNode<D> {
    private final D data;
    TreeNode<D> left;
    TreeNode<D> right;

    public TreeNode(D data) {
        this.data = data;
    }

    public void setLeft(TreeNode<D> left) {
        this.left = left;
    }

    public void setRight(TreeNode<D> right) {
        this.right = right;
    }

    public D getData() {
        return data;
    }

    public TreeNode<D> getLeft() {
        return left;
    }

    public TreeNode<D> getRight() {
        return right;
    }
}
