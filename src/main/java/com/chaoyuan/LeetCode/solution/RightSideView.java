package com.chaoyuan.LeetCode.solution;

/**
 * RightSideView.
 *
 * @author YC
 * @date 2025/11/20 09:22
 * @description RightSideView
 */

import com.chaoyuan.LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 */
public class RightSideView {

    Queue<TreeNode> queue = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        int levelSize = 0;
        if (root != null) {
            queue.add(root);
            levelSize = 1;
        }
        while (!queue.isEmpty()) {
            int nextLevelSize = 0;
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    nextLevelSize++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    nextLevelSize++;
                }
                if (i == levelSize - 1) {
                    result.add(node.val);
                }
            }
            levelSize = nextLevelSize;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
    }
}
