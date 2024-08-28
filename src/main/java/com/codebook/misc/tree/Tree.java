package com.codebook.misc.tree;

import java.util.Iterator;

public interface Tree<D> {

    void insert(D data);

    Iterator<TreeNode<D>> iterator(IteratorStrategy strategy);

    boolean isEmpty();
}
