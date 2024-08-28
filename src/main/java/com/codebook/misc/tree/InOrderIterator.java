package com.codebook.misc.tree;

import java.util.Iterator;
import java.util.Objects;
import java.util.Stack;

public class InOrderIterator implements Iterator<TreeNode<?>> {

    private final Stack<TreeNode<?>> stack;

    public InOrderIterator(TreeNode<?> treeNode) {
        this.stack = new Stack<>();
        refreshStack(treeNode);
    }

    private void refreshStack(TreeNode<?> treeNode) {
        while (!Objects.isNull(treeNode)) {
            this.stack.push(treeNode);
            treeNode = treeNode.left;
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
    public TreeNode<?> next() {
        TreeNode<?> treeNode = this.stack.pop();
        refreshStack(treeNode.right);
        return treeNode;
    }
}
