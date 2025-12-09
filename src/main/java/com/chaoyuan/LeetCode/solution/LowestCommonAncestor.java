package com.chaoyuan.LeetCode.solution;

/**
 * LowestCommonAncestor.
 *
 * @author YC
 * @date 2025/11/20 10:55
 * @description LowestCommonAncestor
 */

import com.chaoyuan.LeetCode.util.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 */
public class LowestCommonAncestor {
    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return res;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root != null) {
            boolean lson = dfs(root.left, p, q);
            boolean rson = dfs(root.right, p, q);
            if ((lson && rson) || ((root == p || root == q) && (lson || rson))) {
                res = root;
            }
            return lson || rson || (root == p || root == q);
        }
        return false;

    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.left = three;
        one.right = two;
        LowestCommonAncestor solution = new LowestCommonAncestor();
        System.out.println(solution.lowestCommonAncestor(one, two, three).val);
    }
}
