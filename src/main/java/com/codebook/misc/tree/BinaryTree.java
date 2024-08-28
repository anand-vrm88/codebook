package com.codebook.misc.tree;

import java.util.Iterator;

public class BinaryTree<D extends Comparable<D>> implements Tree<D> {

    TreeNode<D> root;

    @Override
    public void insert(D data) {

    }

    @Override
    public Iterator<TreeNode<?>> iterator(IteratorStrategy strategy) {
        switch (strategy){
            case IN_ORDER:
                return new InOrderIterator(this.root);
            case POST_ORDER:
                return new PostOrderIterator(this.root);
            default:
                throw new IllegalArgumentException(String.format("Invalid iterator strategy: %s", strategy));
        }
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }
}


