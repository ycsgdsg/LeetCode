package com.chaoyuan.LeetCode.solution;

/**
 * Flatten.
 *
 * @author YC
 * @date 2025/11/20 09:40
 * @description Flatten
 */

import com.chaoyuan.LeetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        List<TreeNode> traversal = traversal(root);
        for (int i = 0; i < traversal.size(); i++) {
            TreeNode node = traversal.get(i);
            TreeNode nextNode = null;
            if (i < traversal.size() - 1) {
                nextNode = traversal.get(i + 1);
            }
            node.left = null;
            node.right = nextNode;
        }
    }

    public List<TreeNode> traversal(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        if (root != null) {
            result.add(root);
            result.addAll(traversal(root.left));
            result.addAll(traversal(root.right));
        }
        return result;
    }
}
