package com.codebook.misc.tree;

import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

public class PostOrderIterator<D extends Comparable<D>> implements Iterator<TreeNode<D>> {

    private final Stack<TreeNode<D>> stack;

    public PostOrderIterator(TreeNode<D> treeNode) {
        this.stack = new Stack<>();
        refreshStack(treeNode);
    }

    private void refreshStack(TreeNode<D> treeNode) {
        while (!Objects.isNull(treeNode)) {
            this.stack.push(treeNode);
            treeNode = treeNode.right;
        }
    }

    @Override
    public boolean hasNext() {
        return !this.stack.empty();
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public TreeNode<D> next() {
        TreeNode<D> treeNode = this.stack.pop();
        refreshStack(treeNode.left);
        return treeNode;
    }
}
