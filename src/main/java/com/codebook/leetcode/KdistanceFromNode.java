package com.codebook.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class KdistanceFromNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        KdistanceFromNode kdistanceFromNode = new KdistanceFromNode();
        System.out.println(kdistanceFromNode.distanceK(root, root.left, 2));
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> result = new LinkedList<>();
        if(root == null){
            return result;
        }

        Map<TreeNode, TreeNode> childToParentMap = new HashMap<>();
        buildChildToParentMap(root, childToParentMap);

        Set<Integer> visited = new HashSet<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target.val);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.remove();
                if(K == 0){
                    result.add(node.val);
                }

                if(node.left != null && visited.add(node.left.val)){
                    queue.add(node.left);
                }

                if(node.right != null && visited.add(node.right.val)){
                    queue.add(node.right);
                }

                TreeNode parent = childToParentMap.get(node);
                if(parent != null && visited.add(parent.val)){
                    queue.add(parent);
                }
            }

            K--;
            if(K < 0) {
                break;
            }
        }

        return result;
    }

    private void buildChildToParentMap(TreeNode root, Map<TreeNode, TreeNode> childToParentMap){
        if(root == null){
            return;
        }

        if(root.left != null){
            childToParentMap.put(root.left, root);
        }

        if(root.right != null){
            childToParentMap.put(root.right, root);
        }

        buildChildToParentMap(root.left, childToParentMap);
        buildChildToParentMap(root.right, childToParentMap);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
