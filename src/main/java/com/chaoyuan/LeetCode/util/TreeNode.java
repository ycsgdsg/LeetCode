package com.chaoyuan.LeetCode.util;

/**
 * TreeNode.
 *
 * @author YC
 * @date 2025/11/13 15:44
 * @description TreeNode
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
