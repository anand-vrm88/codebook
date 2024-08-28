package com.codebook.misc.tree;

import java.util.Objects;

public class BinarySearchTree<D extends Comparable<D>> extends BinaryTree<D> {

    @Override
    public void insert(D data) {
        if (isEmpty()) {
            this.root = new TreeNode<>(data);
            return;
        }
        insert(this.root, data);
    }

    private void insert(TreeNode<D> trackerNode, D data) {
        if (trackerNode.getData().compareTo(data) > 0) {
            if (Objects.isNull(trackerNode.left)) {
                trackerNode.left = new TreeNode<>(data);
            } else {
                insert(trackerNode.left, data);
            }
        } else {
            if (Objects.isNull(trackerNode.right)) {
                trackerNode.right = new TreeNode<>(data);
            } else {
                insert(trackerNode.right, data);
            }
        }
    }
}
